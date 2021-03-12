package com.onroad.backend.entity;

import com.onroad.custom.KinshipLevel;

import javax.persistence.*;
import java.util.List;

@Entity
public class Reference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private KinshipLevel kinshipLevel;
    private String relativeName;
    @ManyToMany(mappedBy = "references", fetch = FetchType.LAZY)
    private List<Customer> customers;

}
