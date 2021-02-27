package com.onroad.backend.entity;

import com.onroad.custom.TypeMovimentCashier;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Cashier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Float actualValue;
    private Date startDate;
    private Date closeDate;
    private String description;

    public Cashier()
    {

    }

    public Cashier(Integer id, Float actualValue, Date startDate, Date closeDate, String description, TypeMovimentCashier type) {
        this.setId(id);
        this.setStartDate(startDate);
        this.setActualValue(actualValue);
        this.setCloseDate(closeDate);
        this.setDescription(description);
    }

    public Cashier(Float actualValue, Date startDate, Date closeDate, String description, TypeMovimentCashier type) {
        this.setStartDate(startDate);
        this.setActualValue(actualValue);
        this.setCloseDate(closeDate);
        this.setDescription(description);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getActualValue() {
        return actualValue;
    }

    public void setActualValue(Float actualValue) {
        this.actualValue = actualValue;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
