package com.scosm.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class RegisterDTO {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String telephone;
    private String zone;
    private String city;
    private String address;
    //TODO private Boolean newsletter;

}