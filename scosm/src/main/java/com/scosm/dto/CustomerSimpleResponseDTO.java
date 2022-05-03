package com.scosm.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomerSimpleResponseDTO {
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;

}