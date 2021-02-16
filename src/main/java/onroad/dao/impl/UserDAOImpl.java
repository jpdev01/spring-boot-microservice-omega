package onroad.dao.impl;

import onroad.config.connection.PersistEngine;
import onroad.dao.UserDAO;
import onroad.entity.Category;
import onroad.entity.User;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Set;

public class UserDAOImpl implements UserDAO {

    private PersistEngine persistEngine = new PersistEngine();

    public void save(User u){

        EntityManager em = persistEngine.createConnection();

        try {

            em.getTransaction().begin();

            if (u.getId() == null){
                // nao tem ID: significa que é um objeto novo, insert.
                em.persist(u);
            }
            else {
                // se tiver id, significa que já foi persistido, update
                em.merge(u);
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

    public User findById(Integer id){
        EntityManager em = persistEngine.createConnection();
        User user = null;

        try{

            user = em.find(User.class, id);

        } catch (Exception e){
            System.out.println("Erro ao fazer busca pelo id\n" + e);
        } finally {
            em.close();
        }

        return user;
    }

    public Set<User> findAll(){
        EntityManager em = persistEngine.createConnection();
        // busca por query
        Set<User> users = null;

        try {

            // JDBC: SELECT * FROM CATEGORY
            users.addAll(em.createQuery("from user").getResultList());

        } catch (Exception e) {

            System.err.println(e);

        } finally {

            em.close();
        }

        return users;
    }

    public void remove(Integer id){
        EntityManager em = persistEngine.createConnection();
        try {

            User user = findById(id);
            if (user != null) {
                em.getTransaction().begin();
                em.remove(user);
                em.getTransaction().commit();
            }

        } catch (Exception e){
            System.err.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

}
