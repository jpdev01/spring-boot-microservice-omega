package com.core.backend.entity;

import com.core.custom.Status;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Customer customer;

    @Enumerated(EnumType.ORDINAL)
    private Status status = Status.PENDING;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="reservation_has_products", joinColumns=
    @JoinColumn(name="reservation_id"), inverseJoinColumns=
    @JoinColumn(name="product_id"))
    private List<Product> products;

    private Date startDate;
    private Date closeDate;

    @ManyToOne
    private User vendor;

    public Reservation()
    {

    }

    public Reservation(Customer customer, Status status, List<Product> products, Date startDate, Date closeDate, User vendor) {
        this.customer = customer;
        this.status = status;
        this.products = products;
        this.startDate = startDate;
        this.closeDate = closeDate;
        this.vendor = vendor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public User getVendor() {
        return vendor;
    }

    public void setVendor(User vendor) {
        this.vendor = vendor;
    }
}

