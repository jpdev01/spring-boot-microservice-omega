package com.core.backend.entity;

import com.core.components.list.ListModule;
import com.core.components.list.isFieldList;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @isFieldList(isVisible = ListModule.ALL, label = "Nome", order = 0)
    private String name;
    @isFieldList(isVisible = ListModule.ALL, label = "Descrição", order = 1)
    private String description;

    @ManyToMany(mappedBy = "categories", fetch = FetchType.EAGER)
    private List<Product> products;

    public Category()
    {

    }

    public Category(Integer id, String name, String description)
    {
        this.setId(id);
        this.setName(name);
        this.setDescription(description);
    }

    public Category(String name, String description)
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

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
