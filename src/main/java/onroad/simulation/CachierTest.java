package onroad.simulation;

import onroad.dao.CashierDAO;
import onroad.dao.impl.CashierDAOImpl;
import onroad.entity.Cashier;
import onroad.entity.TypeMovimentCashier;

import java.util.Date;

public class CachierTest {

    private static CashierDAO dao = new CashierDAOImpl();

    public static void main(String[] args) {
        saveTest();
    }

    public static void saveTest()
    {
        Date date = new Date();
        Cashier cashier = new Cashier(100, date, "Caixa atual", TypeMovimentCashier.ENTRY);
        dao.save(cashier);
    }
}
