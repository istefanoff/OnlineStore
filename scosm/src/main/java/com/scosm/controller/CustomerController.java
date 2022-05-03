package com.scosm.controller;


import com.scosm.dto.CustomerSimpleResponseDTO;
import com.scosm.dto.RegisterDTO;
import com.scosm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers/")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("register")
    public ResponseEntity<CustomerSimpleResponseDTO> register(@RequestBody RegisterDTO registerDTO){
        CustomerSimpleResponseDTO dto = customerService.register(registerDTO);
        return ResponseEntity.status(201).body(dto);
    }



}