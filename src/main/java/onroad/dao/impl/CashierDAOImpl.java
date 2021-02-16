package onroad.dao.impl;

import onroad.config.connection.PersistEngine;
import onroad.dao.CashierDAO;
import onroad.entity.Cashier;
import onroad.entity.Product;

import javax.persistence.EntityManager;
import java.util.List;
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
                em.merge(cashier);
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
        EntityManager em = persistEngine.createConnection();
        Cashier cashier = null;
        try {
            cashier =  em.find(Cashier.class, id);
        } catch (Exception e){
            System.err.println(e);
        } finally {
            em.close();
        }
        return cashier;
    }

    @Override
    public Set<Cashier> findAll() {
        EntityManager em = persistEngine.createConnection();
        Set<Cashier> cashiers = null;

        try {

            cashiers.addAll(em.createQuery("from cashier c").getResultList());

        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }

        return cashiers;
    }

    @Override
    public void remove(Integer id) {
        EntityManager em = persistEngine.createConnection();

        try {
            Cashier cashier = findById(id);
            if (cashier != null) {
                em.getTransaction().begin();
                em.remove(cashier);
                em.getTransaction().commit();
            }

        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
