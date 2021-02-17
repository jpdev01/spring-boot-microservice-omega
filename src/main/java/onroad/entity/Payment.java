package onroad.entity;

import onroad.custom.Method;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Float value;
    private Date date;
    private String description;

    @ManyToOne
    private Sale sale;

    private String frmPgto;

    @Enumerated(EnumType.ORDINAL)
    private Method method;

    @Enumerated(EnumType.ORDINAL)
    private CardFlag cardFlag;
}
