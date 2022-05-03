package com.scosm.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    //@JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    private String comment;

    //TODO private Status status;


    // product and quantity
    @OneToMany
    @Column(name = "products")
    private List<Product> product;

    private BigDecimal total;
    //TODO added, modified, COD, shipping, discount_voucher(coupon),
}
