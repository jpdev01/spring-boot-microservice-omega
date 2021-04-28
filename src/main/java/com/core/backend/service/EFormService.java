package com.core.backend.service;

import com.core.backend.entity.OnroadObject;
import com.core.backend.repository.hibernate.PersistEngine;
import com.core.components.form.Form;
import com.core.components.form.field.FieldForm;
import com.core.components.form.field.PasswordFieldForm;
import com.core.components.form.field.TextFieldForm;
import com.core.components.form.isFieldForm;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;

@Service
public class EFormService {
    public Form build(OnroadObject object) {
//        PersistEngine persistEngine = new PersistEngine();
//        persistEngine.getOnroadObject(object.getClass(), object.getId());
        Form form = new Form();

        ArrayList<FieldForm> fields = new ArrayList<>();
        Class clazz = object.getClass();
        for (Field attribute : clazz.getDeclaredFields()) {
            if (attribute.isAnnotationPresent(isFieldForm.class)) {
                if (attribute.getType().equals(String.class)) {
                    String id = attribute.getName();
                    String label = attribute.getAnnotation(isFieldForm.class).label();
                    if (id.equals("password")) {
                        PasswordFieldForm fieldForm = new PasswordFieldForm(id, label);
                        fields.add(fieldForm);
                    } else {
                        TextFieldForm fieldForm = new TextFieldForm(id, label);
                        fields.add(fieldForm);
                    }
                }
            }
        }
        form.setFields(fields);
        return form;
    }
}
