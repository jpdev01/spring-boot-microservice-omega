package onroad.dao.impl;

import onroad.config.connection.PersistEngine;
import onroad.dao.SaleDAO;
import onroad.entity.Sale;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.Set;

public class SaleDAOImpl implements SaleDAO {

    PersistEngine persistEngine = new PersistEngine();

    @Override
    public void save(Sale sale) {

        EntityManager em = persistEngine.createConnection();
        try
        {
            em.getTransaction().begin();
            if (sale.getId() == null)
            {
                em.persist(sale);
            }
            else
            {
                em.merge(sale);
            }
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
    public void remove(Integer id) {

        EntityManager em = persistEngine.getConnection();
        try
        {
            Sale sale = getById(id);
            if (sale != null)
            {
                em.getTransaction().begin();
                em.remove(sale);
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

    @Override
    public Sale getById(Integer id) {

        EntityManager em = persistEngine.getConnection();
        Sale sale = null;

        try
        {
            sale = em.find(Sale.class, id);
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
        finally
        {
            em.close();
        }
        return sale;
    }

    @Override
    public Set<Sale> getAll() {

        EntityManager em = persistEngine.getConnection();
        Set<Sale> sales = new HashSet<>();
        try
        {
            sales.addAll(em.createQuery("FROM Sale").getResultList());
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
        finally
        {
            em.close();
        }
        return sales;
    }
}
