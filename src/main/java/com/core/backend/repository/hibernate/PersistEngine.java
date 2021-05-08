package com.core.backend.repository.hibernate;

import com.core.backend.entity.OnroadObject;
import com.core.backend.repository.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Component
public class PersistEngine {
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    private EntityManager em;

    public Object find(StringBuilder sb) {
        String query = sb.toString();
        return em.createQuery(query).getResultList();
    }

    public Object find(StringBuilder sb, Class clazz) {
        String query = sb.toString();
        return em.createQuery(query, clazz).getResultList();
    }

    public Object find(Query query, Class clazz) {
        String hql = query.getSb().toString();
        return em.createQuery(hql, clazz).getResultList();
    }
}
