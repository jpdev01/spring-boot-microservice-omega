package com.onroad.backend.entity;

import com.onroad.custom.KinshipLevel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Customer customer;
    private KinshipLevel kinshipLevel;
    private String relativeName;

}
