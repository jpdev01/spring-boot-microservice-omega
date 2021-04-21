package com.core.backend.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;

    @OneToMany
    private List<Product> products;

    public Provider (){}

    public Provider(Integer id, String name, String description)
    {
        this.setId(id);
        this.setName(name);
        this.setDescription(description);
    }

    public Provider(String name, String description)
    {
        this.setName(name);
        this.setDescription(description);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
