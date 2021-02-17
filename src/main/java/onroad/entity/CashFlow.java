package onroad.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class CashFlow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Float value;
    private Date date;
    @Enumerated(EnumType.ORDINAL)
    private TypeMovimentCashier type;
}
