package onroad.dao.impl;

import onroad.config.connection.PersistEngine;
import onroad.dao.ReservationDAO;
import onroad.entity.Reservation;

import javax.persistence.EntityManager;
import java.util.Set;

public class ReservationDAOImpl implements ReservationDAO {

    PersistEngine persistEngine = new PersistEngine();

    @Override
    public void save(Reservation reservation) {

        EntityManager em = persistEngine.createConnection();
        try
        {
            em.getTransaction().begin();
            if (reservation.getId() == null)
            {
                em.persist(reservation);
            }
            else
            {
                em.merge(reservation);
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
            Reservation reservation = em.find(Reservation.class, id);
            if (reservation != null)
            {
                em.getTransaction().begin();
                em.remove(reservation);
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
    public Reservation getById(Integer id) {

        EntityManager em = persistEngine.createConnection();
        Reservation reservation = null;

        try
        {
            reservation = em.find(Reservation.class, id);
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

        return reservation;
    }

    @Override
    public Set<Reservation> getAll() {

        EntityManager em = persistEngine.createConnection();
        Set<Reservation> reservations = null;
        try
        {
            reservations.addAll(em.createQuery("FROM Reservation").getResultList());
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
        finally
        {
            em.close();
        }
        return reservations;
    }
}
