package com.core.backend.service.list;

import com.core.backend.repository.query.Query;
import com.core.backend.repository.hibernate.PersistEngine;
import com.core.components.list.isFieldList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Component
public class ListBuilder {

    @Autowired
    PersistEngine persistEngine;
    public EntityList build(Class clazz){
        EntityList entityList = new EntityList();
        EntityListContent listContent = new EntityListContent();

        ArrayList<String> cols = new ArrayList();
        Query query = new Query(clazz);
        ArrayList<String> queryParams = new ArrayList<>();
        for (Field attribute : clazz.getDeclaredFields()) {
            if (attribute.isAnnotationPresent(isFieldList.class)) {
                String col = getFieldCol(attribute);
                cols.add(col);
                queryParams.add(col);
            }
        }


        listContent.setCols(cols);

        query.addSelect(queryParams);
        listContent.setRows(populateRows(query.getSb()));
        entityList.setContent(listContent);

        return entityList;
    }

    private String getFieldCol(Field attribute){
        return attribute.getName();
    }

    private List<List<String>> populateRows(StringBuilder SBQuery)
    {
        Object rows = persistEngine.find(SBQuery);
        if (rows != null)
        {
            return (ArrayList) rows;
        }
        return new ArrayList<>();
    }
}
