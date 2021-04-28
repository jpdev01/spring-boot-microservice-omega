package com.core.backend.repository.hibernate;

import com.core.backend.entity.OnroadObject;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PersistEngine {
    public OnroadObject getOnroadObject(Class clazz, Integer id)
    {
        EntityManager em = new ConnectionFactory().createConnection();
        String tableName = clazz.getSimpleName();
        Query query = em.createQuery("from " + tableName + " WHERE id = " + id);
        List resultList = query.getResultList();
        if (resultList != null)
        {
            return (OnroadObject) resultList.get(0);
        }
        return null;
    }
}
