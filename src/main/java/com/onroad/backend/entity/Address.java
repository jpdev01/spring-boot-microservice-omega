package com.onroad.backend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cep;
    private String uf;
    private String publicPlace;
    private String neighborhood;
    private String city;
    private String complement;

    public Address(){}

    public Address(Integer id, String cep, String uf, String publicPlace, String neighborhood, String city, String complement) {
        this.setId(id);
        this.setCep(cep);
        this.setUf(uf);
        this.setPublicPlace(publicPlace);
        this.setNeighborhood(neighborhood);
        this.setCity(city);
        this.setComplement(complement);
    }

    public Address(String cep, String uf, String publicPlace, String neighborhood, String city, String complement) {
        this.setCep(cep);
        this.setUf(uf);
        this.setPublicPlace(publicPlace);
        this.setNeighborhood(neighborhood);
        this.setCity(city);
        this.setComplement(complement);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getPublicPlace() {
        return publicPlace;
    }

    public void setPublicPlace(String publicPlace) {
        this.publicPlace = publicPlace;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }
}
