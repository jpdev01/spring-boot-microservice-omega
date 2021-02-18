package onroad.dao.impl;

import onroad.config.connection.PersistEngine;
import onroad.dao.AddressDAO;
import onroad.entity.Address;
import javax.persistence.EntityManager;
import java.util.Set;

public class AddressDAOImpl implements AddressDAO {

    PersistEngine persistEngine = new PersistEngine();

    @Override
    public void save(Address address) {
        EntityManager em = persistEngine.getConnection();
        try
        {
            em.getTransaction().begin();
            if (address.getId() == null)
            {
                em.persist(address);
            }
            else
            {
                em.merge(address);
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

        EntityManager em = persistEngine.createConnection();
        try
        {
            Address address = getById(id);
            if (address != null)
            {
                em.getTransaction().begin();
                em.remove(address);
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
    public Address getById(Integer id) {

        EntityManager em = persistEngine.createConnection();
        Address address = null;
        try
        {
            address = em.find(Address.class, id);
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
        finally
        {
            em.close();
        }
        return address;
    }

    @Override
    public Set<Address> getAll() {
        EntityManager em = persistEngine.createConnection();
        Set<Address> address = null;

        try {
            address.addAll(em.createQuery("FROM Address").getResultList());
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }

        return address;
    }
}
