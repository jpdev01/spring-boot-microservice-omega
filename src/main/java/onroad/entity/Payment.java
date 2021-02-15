package onroad.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Float value;
    private Date date;
    private String description;
    private Sale sale;
    private String frmPgto;
    private String method;
    private CardFlag cardFlag;
}
