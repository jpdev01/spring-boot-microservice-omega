package onroad.dao;

import onroad.entity.Sale;

import java.util.Set;

public interface SaleDAO {

    public void save(Sale sale);
    public void remove(Integer id);
    public Sale getById(Integer id);
    public Set<Sale> getAll();

}
