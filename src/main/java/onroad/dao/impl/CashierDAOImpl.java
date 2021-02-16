package onroad.dao.impl;

import onroad.config.connection.PersistEngine;
import onroad.dao.CashierDAO;
import onroad.entity.Cashier;

import javax.persistence.EntityManager;
import java.util.Set;

public class CashierDAOImpl implements CashierDAO {

    private PersistEngine persistEngine = new PersistEngine();

    @Override
    public void save(Cashier cashier) {
        EntityManager em = persistEngine.createConnection();
        try {

            em.getTransaction().begin();

            if (cashier.getId() == null){
                // nao tem ID: significa que é um objeto novo, insert.
                em.persist(cashier);
            }
            else {
                // se tiver id, significa que já foi persistido, update
                em.merge(c);
            }
            em.getTransaction().commit();

        } catch (Exception e) {

            System.out.println("Erro de transação! Será feito rollback da transação. \n" + e );
            em.getTransaction().rollback();
            // desfaz tudo

        } finally {

            em.close();

        }
    }

    @Override
    public Cashier findById(Integer id) {
        return null;
    }

    @Override
    public Set<Cashier> findAll() {
        return null;
    }

    @Override
    public void remove(Integer id) {

    }
}
