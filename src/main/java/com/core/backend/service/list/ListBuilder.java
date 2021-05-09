package com.core.backend.service.list;

import com.core.backend.repository.query.Query;
import com.core.backend.repository.hibernate.PersistEngine;
import com.core.components.list.isFieldList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Id;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Component
public class ListBuilder {

    @Autowired
    PersistEngine persistEngine;

    public EntityList build(Class clazz, EntityList entityList) {
        if (entityList == null) {
            entityList = new EntityList();
        }
        try {
            ArrayList<Object> cols = new ArrayList();
            EntityListContent content = entityList.getContent();
            if (content != null && content.getCols() != null)
            {
                cols.addAll(content.getCols());
            }
            List<Row> rows = new ArrayList<>();
            Query query = new Query(clazz);
            Object obj = persistEngine.find(query, clazz);
            for (Field attribute : clazz.getDeclaredFields()) {
                if (attribute.isAnnotationPresent(isFieldList.class)) {
                    int position = attribute.getAnnotation(isFieldList.class).order();
                    attribute.setAccessible(true);
                    if (obj != null && obj instanceof List) {
                        for (int i = 0; i < ((List<?>) obj).size(); i++) {
                            if(content.isInputRadioInRows())
                            {
                                if(position == 0)
                                {
                                    rows.get(i).getValue().add(position, "RADIO");
                                }
                                position++;
                            }
                            Object objValue = attribute.get(((List<?>) obj).get(i));
                            if (objValue != null) {
                                if (objValue instanceof String) {
                                    objValue = (String) objValue;
                                } else if (objValue instanceof Enum) {
                                    objValue = (String) ((Enum<?>) objValue).name();
                                }
                            } else {
                                objValue = "";
                            }
                            rows = validatePositionOfRow(rows, i);
                            rows.get(i).getValue().add(position, objValue);
                        }
                    }
                    String col = getFieldCol(attribute);

                    if (cols.size() == 0 || cols.size() < position) {
                        for (int i = 0; i < position; i++) {
                            if (cols.size() < position) {
                                cols.add(i, null);
                            }
                        }
                    }
                    cols.add(position, col);
                }
                if (attribute.isAnnotationPresent(Id.class)) {
                    for (int i = 0; i < ((List<?>) obj).size(); i++) {
                        attribute.setAccessible(true);
                        rows = validatePositionOfRow(rows, i);
                        Integer objValue = (Integer) attribute.get(((List<?>) obj).get(i));
                        rows.get(i).setKey(objValue);
                    }
                }
            }
            content.setCols(cols);
            content.setRows(rows);
            entityList.setContent(content);
            if (entityList.getView() == null)
            {
                entityList.setView(View.FULL);
            }

        } catch (Exception e) {
            System.out.println("Erro ao buildar o eform!" + e);
        }
        return entityList;
    }

    public EntityList build(Class clazz)
    {
        return build(clazz, null);
    }

    private String getFieldCol(Field attribute) {
        return attribute.getName();
    }

    private List<Row> validatePositionOfRow(List<Row> rows, Integer index) {
        boolean indexIsNull = rows.size() == 0 || rows.size() < (index + 1) || rows.get(index) == null;
        if (indexIsNull) {
            rows.add(new Row());
        }
        return rows;
    }

}
