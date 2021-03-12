package com.onroad.backend.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String nickname;
    private String cpf;
    private String RG;
    private Date bornDate;
    private Date dateReg;
    private String email;
    private Integer fone;
    private Integer mobile;
    private String description;
    private Float credit;
    private String size;
    private String size2;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="customers_has_references", joinColumns=
    @JoinColumn(name="customer_id"), inverseJoinColumns=
    @JoinColumn(name="reference_id"))
    private List<Reference> references;

    private String office;

    @ManyToOne
    private Address address;

    // criar implementação de família. Talvez uma classe.

}
