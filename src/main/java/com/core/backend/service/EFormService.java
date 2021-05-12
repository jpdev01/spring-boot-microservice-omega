package com.core.backend.service;

import com.core.backend.entity.OnroadObject;
import com.core.components.form.Eform;
import com.core.components.form.field.*;
import com.core.components.form.isFieldForm;
import com.core.components.form.isListFieldForm;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;

@Service
public class EFormService {
    public Eform build(OnroadObject object) {
        Eform eform = new Eform();

        ArrayList<FieldForm> fields = new ArrayList<>();
        Class clazz = object.getClass();
        for (Field attribute : clazz.getDeclaredFields()) {
            if (attribute.isAnnotationPresent(isFieldForm.class)) {
                fields.add(getFieldByType(attribute));
            }
        }
        eform.setFields(fields);
        return eform;
    }

    public Eform build(Class clazz) {
        Eform eform = new Eform();

        ArrayList<FieldForm> fields = new ArrayList<>();
        for (Field attribute : clazz.getDeclaredFields()) {
            if (attribute.isAnnotationPresent(isFieldForm.class)) {
                fields.add(getFieldByType(attribute));
            } else if (attribute.isAnnotationPresent(isListFieldForm.class)) {
                fields.add(getListField(attribute));
            }
        }
        eform.setFields(fields);
        return eform;
    }

    public FieldForm getFieldByType(Field attribute) 
    {
        FieldForm fieldForm = null;
        String id = attribute.getName();
        String label = attribute.getAnnotation(isFieldForm.class).label();
        Integer group = attribute.getAnnotation(isFieldForm.class).group();
        FieldFormType type = attribute.getAnnotation(isFieldForm.class).type();

        Class<?> attributeType = attribute.getType();
        boolean isSelectField = type == FieldFormType.SELECT;
        boolean isTextField = attributeType.equals(String.class);
        boolean isNumberField = attributeType.equals(Integer.class) || attributeType.equals(Float.class) && !isSelectField;
        boolean isDateField = attributeType.equals(Date.class);
        if (isSelectField)
        {
            fieldForm = new SelectFieldForm(id, label, null, group);
        }
        else if (isTextField)
        {
            if (id.equals("password"))
            {
                fieldForm = new PasswordFieldForm(id, label, group);
            } else
            {
                fieldForm = new TextFieldForm(id, label, group);
            }
        }
        else if (isNumberField)
        {
            fieldForm = new NumberFieldForm(id, label, group);
        }
        else if (isDateField)
        {
            fieldForm = new DateFieldForm(id, label, group);
        }
        return fieldForm;
    }

    public ListFieldForm getListField(Field attribute) {
        String id = attribute.getName();
        String label = attribute.getAnnotation(isListFieldForm.class).label();
        Integer group = attribute.getAnnotation(isListFieldForm.class).group();
        FieldView view = attribute.getAnnotation(isListFieldForm.class).modeView();
        ListType listType = attribute.getAnnotation(isListFieldForm.class).listType();
        ListFieldForm fieldForm = new ListFieldForm(id, label, group, view);
        return fieldForm;
    }
}
