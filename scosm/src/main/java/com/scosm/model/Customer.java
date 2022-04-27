package com.scosm.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

@Entity
@Table
@NoArgsConstructor
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @Email
    @NotNull
    private String email;

    @NotNull
    @Length(min = 10)
    private String telephone;

    @NotNull
    private String password;

    private Boolean status;

    private Boolean newsletter;

    private LocalDate dateAdded;

    private Set<Product> wishList;

    private Map<Product, Integer> cart;

    //TODO private List<Order> orders;


}
