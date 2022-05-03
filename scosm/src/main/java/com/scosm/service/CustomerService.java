package com.scosm.service;

import com.scosm.dto.CustomerSimpleResponseDTO;
import com.scosm.dto.RegisterDTO;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService extends UserDetailsService {
    CustomerSimpleResponseDTO register(RegisterDTO registerDTO);
}
