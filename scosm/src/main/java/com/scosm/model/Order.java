package com.scosm.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Map;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Customer customer;

    private String comment;

    //TODO private Status status;


    // product and quantity
    @ManyToMany
    private Map<Product, Integer> product;

    private BigDecimal total;
    //TODO added, modified, COD, shipping, discount_voucher(coupon),
}
