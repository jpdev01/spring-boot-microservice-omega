package onroad.dao;

import onroad.entity.Cashier;

import java.util.Set;

public interface CashierDAO {

    public void save(Cashier cashier);
    public Cashier findById(Integer id);
    public Set<Cashier> findAll();
    public void remove(Integer id);
}
