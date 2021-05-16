package com.core.backend.service.list;

import com.core.backend.repository.query.Query;
import com.core.backend.repository.hibernate.PersistEngine;
import com.core.components.form.field.CheckboxFieldForm;
import com.core.components.form.field.FieldFormType;
import com.core.components.form.field.RadioFieldForm;
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
                    int indexColumn = attribute.getAnnotation(isFieldList.class).order();
                    attribute.setAccessible(true);
                    if (obj != null && obj instanceof List) {
                        for (int indexRow = 0; indexRow < ((List<?>) obj).size(); indexRow++) {
                            Object entity = ((List<?>) obj).get(indexRow);
                            FieldFormType contentInputType = content.getInput();
                            if(contentInputType != null)
                            {
                                if(FieldFormType.RADIO.equals(contentInputType))
                                {
                                    if(indexColumn == 0)
                                    {
                                        String label = clazz.getSimpleName().toLowerCase();
                                        rows.get(indexRow).getValue().add(indexColumn, new RadioFieldForm("1", label, 0));
                                    }
                                    indexColumn++;
                                }
                                else if (FieldFormType.CHECKBOX.equals(contentInputType))
                                {
                                    if(indexColumn == 0)
                                    {
                                        String label = clazz.getSimpleName().toLowerCase();
                                        rows.get(indexRow).getValue().add(indexColumn, new CheckboxFieldForm("1", label, 0));
                                    }
                                    indexColumn++;
                                }
                            }
                            Object objValue = attribute.get(entity);
                            if (objValue != null) {
                                if (objValue instanceof String) {
                                    objValue = (String) objValue;
                                } else if (objValue instanceof Enum) {
                                    objValue = (String) ((Enum<?>) objValue).name();
                                }
                            } else {
                                objValue = "";
                            }
                            rows = validatePositionOfRow(rows, indexRow);
                            rows.get(indexRow).getValue().add(indexColumn, objValue);
                        }
                    }
                    String col = getFieldCol(attribute);

                    if (cols.size() == 0 || cols.size() < indexColumn) {
                        for (int i = 0; i < indexColumn; i++) {
                            if (cols.size() < indexColumn) {
                                cols.add(i, null);
                            }
                        }
                    }
                    cols.add(indexColumn, col);
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
