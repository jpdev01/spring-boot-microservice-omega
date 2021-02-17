package onroad.dao;

import onroad.entity.CashFlow;
import onroad.entity.Cashier;

import java.util.List;

public interface CashFlowDAO {

    public void save(CashFlow cashier);
    public void remove(Integer id);
    public List<CashFlow> findAll();
    public CashFlow findById(Integer id);

}
