package onroad.entity;

import onroad.entity.Category;
import onroad.entity.Provider;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    private Float finalValue;
    private Float initialValue;

    private String description;
    private Integer qtde;
    private String color;
    private String genre;

    private Date entryDate;
    private String style;
    private String size;
    private String size2;

    private String code;

    @ManyToMany
    private List<Category> categories;

    @ManyToOne
    private Provider provider;
}