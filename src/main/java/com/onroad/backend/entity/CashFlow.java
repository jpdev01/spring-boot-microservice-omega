package com.onroad.backend.entity;

import com.onroad.custom.TypeMovimentCashier;

import javax.persistence.*;
import java.util.Date;

@Entity
public class CashFlow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Float value;
    private Date date;
    @Enumerated(EnumType.ORDINAL)
    private TypeMovimentCashier type;
    @ManyToOne
    private Cashier cashier;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TypeMovimentCashier getType() {
        return type;
    }

    public void setType(TypeMovimentCashier type) {
        this.type = type;
    }

    public Cashier getCashier() {
        return cashier;
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }
}
