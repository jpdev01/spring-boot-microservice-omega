package onroad.entity;

import onroad.custom.CardFlag;
import onroad.custom.FormPgto;
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

    @Enumerated(EnumType.ORDINAL)
    private FormPgto frmPgto;

    @Enumerated(EnumType.ORDINAL)
    private Method method;

    @Enumerated(EnumType.ORDINAL)
    private CardFlag cardFlag;

    public Payment()
    {

    }

    public Payment(Integer id, Float value, Date date, String description, Sale sale, FormPgto frmPgto, Method method, CardFlag cardFlag) {
        this.id = id;
        this.value = value;
        this.date = date;
        this.description = description;
        this.sale = sale;
        this.frmPgto = frmPgto;
        this.method = method;
        this.cardFlag = cardFlag;
    }

    public Payment(Float value, Date date, String description, Sale sale, FormPgto frmPgto, Method method, CardFlag cardFlag) {
        this.value = value;
        this.date = date;
        this.description = description;
        this.sale = sale;
        this.frmPgto = frmPgto;
        this.method = method;
        this.cardFlag = cardFlag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public FormPgto getFrmPgto() {
        return frmPgto;
    }

    public void setFrmPgto(FormPgto frmPgto) {
        this.frmPgto = frmPgto;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public CardFlag getCardFlag() {
        return cardFlag;
    }

    public void setCardFlag(CardFlag cardFlag) {
        this.cardFlag = cardFlag;
    }
}
