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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="products_has_categories", joinColumns=
    @JoinColumn(name="product_id"), inverseJoinColumns=
    @JoinColumn(name="category_id"))
    private List<Category> categories;

    @ManyToOne
    private Provider provider;

    public Product(){}

    public Product(Integer id, String name, Float finalValue, Float initialValue, String description, Integer qtde, String color, String genre, Date entryDate, String style, String size, String size2, String code, List<Category> categories, Provider provider) {
        this.id = id;
        this.name = name;
        this.finalValue = finalValue;
        this.initialValue = initialValue;
        this.description = description;
        this.qtde = qtde;
        this.color = color;
        this.genre = genre;
        this.entryDate = entryDate;
        this.style = style;
        this.size = size;
        this.size2 = size2;
        this.code = code;
        this.categories = categories;
        this.provider = provider;
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

    public Float getFinalValue() {
        return finalValue;
    }

    public void setFinalValue(Float finalValue) {
        this.finalValue = finalValue;
    }

    public Float getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(Float initialValue) {
        this.initialValue = initialValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQtde() {
        return qtde;
    }

    public void setQtde(Integer qtde) {
        this.qtde = qtde;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSize2() {
        return size2;
    }

    public void setSize2(String size2) {
        this.size2 = size2;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
}
