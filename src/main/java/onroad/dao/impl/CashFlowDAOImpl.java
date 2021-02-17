package onroad.dao.impl;

import onroad.config.connection.PersistEngine;
import onroad.entity.CashFlow;
import onroad.entity.Cashier;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Set;

public class CashFlowDAOImpl {

    PersistEngine persistEngine = new PersistEngine();

    public void save(CashFlow cashier) {
        EntityManager em = persistEngine.createConnection();
        try
        {
            em.getTransaction().begin();
            if (cashier.getId() == null)
            {
                em.persist(cashier);
            }
            else
            {
                em.merge(cashier);
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

    public void remove(Integer id) {
        EntityManager em = persistEngine.createConnection();
        try
        {
            CashFlow cf = findById(id);
            if (cf != null && cf.getId() != null)
            {
                em.getTransaction().begin();
                em.remove(cf);
                em.getTransaction().commit();
            }
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

    public Set<CashFlow> findAll() {
        EntityManager em = persistEngine.createConnection();
        Set<CashFlow> cfs = null;

        try {
            cfs.addAll(em.createQuery("from CashFlow").getResultList());
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return cfs;
    }

    public CashFlow findById(Integer id) {
        EntityManager em = persistEngine.createConnection();
        CashFlow fc = null;
        try
        {
            fc = em.find(CashFlow.class, id);
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
        finally
        {
            em.close();
        }
        return fc;
    }


}
