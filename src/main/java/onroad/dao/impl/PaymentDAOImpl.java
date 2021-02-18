package onroad.dao.impl;

import onroad.config.connection.PersistEngine;
import onroad.dao.PaymentDAO;
import onroad.entity.Payment;

import javax.persistence.EntityManager;
import java.util.Set;

public class PaymentDAOImpl implements PaymentDAO {

    PersistEngine persistEngine = new PersistEngine();

    @Override
    public void save(Payment p) {
        EntityManager em = persistEngine.createConnection();
        try
        {
            em.getTransaction().begin();
            if (p.getId() == null)
            {
                em.persist(p);
            }
            else
            {
                em.merge(p);
            }
            em.getTransaction().commit();
        }
        catch (Exception e)
        {

            System.out.println("Erro de transação! Será feito rollback da transação. \n" + e );
            em.getTransaction().rollback();
            // desfaz tudo

        }
        finally {
            em.close();
        }
    }

    @Override
    public void remove(Integer id) {

        EntityManager em = persistEngine.getConnection();
        try
        {
            Payment payment = em.find(Payment.class, id);
            em.getTransaction().begin();
            em.remove(payment);
            em.getTransaction().commit();
        }
        catch (Exception e)
        {
            System.err.println(e);
            em.getTransaction().rollback();
        }
        finally
        {
            em.close();
        }
    }

    @Override
    public Payment getById(Integer id) {

        EntityManager em = persistEngine.createConnection();
        Payment payment =  null;
        try
        {
            payment = em.find(Payment.class, id);
        }
        catch (Exception e)
        {
            System.err.println(e);
            em.getTransaction().rollback();
        }
        finally
        {
            em.close();
        }
        return payment;
    }

    @Override
    public Set<Payment> getAll() {
        EntityManager em = persistEngine.createConnection();
        Set<Payment> payments = null;

        try {

            payments.addAll(em.createQuery("FROM Payment").getResultList());

        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }

        return payments;
    }
}
