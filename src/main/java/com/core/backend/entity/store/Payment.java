package com.core.backend.entity.store;

import com.core.custom.Method;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.ORDINAL)
    private Method method;
    private Float value;
    private Date date;
}


