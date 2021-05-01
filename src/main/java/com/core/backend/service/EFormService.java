package com.core.backend.service;

import com.core.backend.entity.OnroadObject;
import com.core.components.form.Eform;
import com.core.components.form.field.FieldForm;
import com.core.components.form.field.PasswordFieldForm;
import com.core.components.form.field.TextFieldForm;
import com.core.components.form.isFieldForm;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;

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
            }
        }
        eform.setFields(fields);
        return eform;
    }

    public FieldForm getFieldByType(Field attribute)
    {
        FieldForm fieldForm = null;
        if (attribute.getType().equals(String.class)) {
            String id = attribute.getName();
            String label = attribute.getAnnotation(isFieldForm.class).label();
            if (id.equals("password")) {
                fieldForm = new PasswordFieldForm(id, label);

            } else {
                fieldForm = new TextFieldForm(id, label);
            }
        }

        return fieldForm;
    }
}
