package onroad.dao;

import onroad.entity.Payment;

import java.util.Set;

public interface PaymentDAO {

    public void save(Payment p);
    public void remove(Integer id);
    public Payment getById(Integer id);
    public Set<Payment> getAll();

}
