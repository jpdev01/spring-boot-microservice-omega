package onroad.dao.impl;

import onroad.config.connection.PersistEngine;
import onroad.dao.ProviderDAO;
import onroad.entity.Category;
import onroad.entity.Provider;

import javax.persistence.EntityManager;
import java.util.List;

public class ProviderDAOImpl implements ProviderDAO {

    private PersistEngine persistEngine = new PersistEngine();

    public void save(Provider provider){
        EntityManager em = persistEngine.createConnection();
        try {

            em.getTransaction().begin();

            if (provider.getId() == null){
                // nao tem ID: significa que é um objeto novo, insert.
                em.persist(provider);
            }
            else {
                // se tiver id, significa que já foi persistido, update
                em.merge(provider);
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

    public Provider findById(Integer id){
        EntityManager em = persistEngine.createConnection();
        Provider provider = null;

        try{

            provider = em.find(Provider.class, id);

        } catch (Exception e){
            System.out.println("Erro ao fazer busca pelo id\n" + e);
        } finally {
            em.close();
        }

        return provider;
    }

    public List<Provider> findAll(){
        EntityManager em = persistEngine.createConnection();
        // busca por query
        List<Provider> providers = null;

        try {

            providers = em.createQuery("from provider").getResultList();

        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }

        return providers;
    }

    public void remove(Integer id){
        EntityManager em = persistEngine.createConnection();
        try {

            Provider provider = findById(id);
            if (provider != null) {
                em.getTransaction().begin();
                em.remove(provider);
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
