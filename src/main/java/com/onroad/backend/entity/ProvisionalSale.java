package com.onroad.backend.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class ProvisionalSale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Customer customer;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="sales_has_products", joinColumns=
    @JoinColumn(name="sale_id"), inverseJoinColumns=
    @JoinColumn(name="product_id"))
    private List<Product> products;

    private Date date;

}
