package onroad.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String apelido;
    private String cpf;
    private String RG;
    private Date bornDate;
    private Date dateReg;
    private String email;
    private Integer fone;
    private Integer mobile;
    private String description;
    private Float credit;
    private String size;
    private String size2;
    private String reference;
    private String office;

    @ManyToOne
    private Address address;

    // criar implementação de família. Talvez uma classe.

}
