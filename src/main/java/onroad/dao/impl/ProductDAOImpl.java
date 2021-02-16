package onroad.dao.impl;

import onroad.config.connection.PersistEngine;
import onroad.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class ProductDAOImpl {

    PersistEngine persistEngine = new PersistEngine();

    public void save(Product p){

        EntityManager connection = persistEngine.createConnection();

        try {
            connection.getTransaction().begin(); // inicia a transação

            if (p.getId() == null){
                connection.persist(p);
            } else {
                connection.merge(p);
            }
            connection.getTransaction().commit();

        } catch (Exception e){

            System.err.println(e);
            connection.getTransaction().rollback();

        } finally {
            connection.close();
        }

    }

    public Product findById(Integer id){
        EntityManager em = persistEngine.createConnection();
        Product product = null;
        try {
            product =  em.find(Product.class, id);
        } catch (Exception e){
            System.err.println(e);
        } finally {
            em.close();
        }
        return product;
    }

    public List<Product> findAll(){
        EntityManager em = persistEngine.createConnection();
        List<Product> products = null;

        try {

            products = em.createQuery("from product p").getResultList();

        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }

        return products;
    }

    public void remove(Integer id){
        EntityManager em = persistEngine.createConnection();

        try {
            Product p = findById(id);
            if (p != null) {
                em.getTransaction().begin();
                em.remove(p);
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
