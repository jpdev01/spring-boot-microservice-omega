package onroad.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Float totalValue;
    private Date date;
    private String description;
    private String installments;

    @ManyToOne
    private Customer customer;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="sales_has_products", joinColumns=
    @JoinColumn(name="sale_id"), inverseJoinColumns=
    @JoinColumn(name="product_id"))
    private List<Product> products;

    public Sale() {
    }
}
