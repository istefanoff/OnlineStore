package com.scosm.service.impl;

import com.scosm.dto.CustomerSimpleResponseDTO;
import com.scosm.dto.RegisterDTO;
import com.scosm.exception.BadRequestException;
import com.scosm.exception.NotFoundException;
import com.scosm.model.Address;
import com.scosm.model.Customer;
import com.scosm.repository.CustomerRepository;
import com.scosm.repository.ZoneRepository;
import com.scosm.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private ZoneRepository zoneRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public Customer loadUserByUsername(String username) throws NotFoundException {
        return customerRepository.findCustomerByEmail(username).orElseThrow(() -> new NotFoundException("No such registration exists."));
    }

    @Override
    public CustomerSimpleResponseDTO register(RegisterDTO registerDTO) {
        customerRepository.findCustomerByEmail(registerDTO.getEmail()).orElseThrow(() -> new BadRequestException("E-mail already exists"));

        Address currentAddress = new Address(){{
            setAddress(registerDTO.getAddress());
            setCity(registerDTO.getCity());
            setZone(zoneRepository.getByName(registerDTO.getZone()));
        }};

        Customer customer = new Customer(){{
            setEmail(registerDTO.getEmail());
            setFirstName(registerDTO.getFirstName());
            setLastName(registerDTO.getLastName());
            setTelephone(registerDTO.getTelephone());
            setPassword(passwordEncoder.encode(registerDTO.getPassword()));
            getAddress().add(currentAddress);

        }};

        customerRepository.save(customer);
        return modelMapper.map(customer, CustomerSimpleResponseDTO.class);
    }
}
