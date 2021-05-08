package com.core.backend.service.list;

import com.core.backend.entity.User;
import com.core.backend.repository.query.Query;
import com.core.backend.repository.hibernate.PersistEngine;
import com.core.components.list.isFieldList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.text.html.ListView;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Component
public class ListBuilder {

    @Autowired
    PersistEngine persistEngine;
    public EntityList build(Class clazz) throws IllegalAccessException {
        EntityList entityList = new EntityList();
        EntityListContent listContent = new EntityListContent();

        ArrayList<String> cols = new ArrayList();
        List<List<Object>> rows = new ArrayList<>();
        Query query = new Query(clazz);
        Object obj = persistEngine.find(query, clazz);
        for (Field attribute : clazz.getDeclaredFields()) {
            if (attribute.isAnnotationPresent(isFieldList.class)) {
                int position = attribute.getAnnotation(isFieldList.class).order();
                attribute.setAccessible(true);
                if (obj != null && obj instanceof List)
                {
                    for (int i = 0; i < ((List<?>) obj).size(); i++)
                    {
                        Object objValue = attribute.get(((List<?>) obj).get(i));
                        if (objValue != null)
                        {
                            if (objValue instanceof String)
                            {
                                objValue = (String) objValue;
                            }
                            else if (objValue instanceof Enum)
                            {
                                objValue = (String) ((Enum<?>) objValue).name();
                            }
                        }
                        else
                        {
                            objValue = "";
                        }
                        boolean indexIsNull = rows.size() == 0 || rows.size() < (i + 1) || rows.get(i) == null;
                        if (indexIsNull)
                        {
                            rows.add(new ArrayList<>());
                        }
                        rows.get(i).add(position, objValue);
                        //rows.get(i).add(objValue);
                    }
                }
                String col = getFieldCol(attribute);

                if (cols.size() == 0 || cols.size() < position)
                {
                    for(int i = 0; i < position; i++)
                    {
                        if (cols.size() < position)
                        {
                            cols.add(i, null);
                        }
                    }
                }
                //cols.add(position, col);
              cols.add(position, col);
            }
        }
        listContent.setCols(cols);
        listContent.setRows(rows);
        entityList.setContent(listContent);
        entityList.setView(View.FULL);

        return entityList;
    }

    private String getFieldCol(Field attribute){
        return attribute.getName();
    }

}
