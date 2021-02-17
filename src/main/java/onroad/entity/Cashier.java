package onroad.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Cashier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer actualValue;
    private Date startDate;
    private Date closeDate;
    private String description;

    public Cashier()
    {

    }

    public Cashier(Integer id, Integer actualValue, Date closeDate, String description, TypeMovimentCashier type) {
        this.setId(id);
        this.setActualValue(actualValue);
        this.setCloseDate(closeDate);
        this.setDescription(description);
    }

    public Cashier(Integer actualValue, Date closeDate, String description, TypeMovimentCashier type) {
        this.setActualValue(actualValue);
        this.setCloseDate(closeDate);
        this.setDescription(description);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getActualValue() {
        return actualValue;
    }

    public void setActualValue(Integer actualValue) {
        this.actualValue = actualValue;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
