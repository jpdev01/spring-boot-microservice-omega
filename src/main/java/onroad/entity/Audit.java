package onroad.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String type;
    private String description;
    private Date date;
    private Integer onroadId;
}
