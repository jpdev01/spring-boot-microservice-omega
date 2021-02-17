package onroad.entity;

import onroad.custom.Status;

import javax.persistence.*;
import java.util.List;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Customer customer;

    @Enumerated(EnumType.ORDINAL)
    private Status status = Status.PENDING;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="reservation_has_products", joinColumns=
    @JoinColumn(name="reservation_id"), inverseJoinColumns=
    @JoinColumn(name="product_id"))
    private List<Product> products;

}

