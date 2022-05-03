package com.scosm.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    @NotNull
    @UniqueElements
    private String model;

    private String description;

    private BigDecimal price;

    private String pictureUrl;

    private Long quantity;

    private Boolean status;

    private Boolean sortOrder;

    //TODO private Manufacturer manufacturer;

    //TODO meta keywords, title, description
    //TODO SKU,EAN if needed
    //TODO view counter for statistics | MOQ, dateAdded, dateModified, dateAvailabe, bonusPoints?


}