package com.core.components.form;

import com.core.backend.entity.OnroadObject;
import com.core.backend.entity.User;
import com.core.components.form.field.FieldForm;
import com.core.components.form.field.PasswordFieldForm;
import com.core.components.form.field.TextFieldForm;
import com.core.utils.PatternUrl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Eform {
    private String nameId;
    private List<FieldForm> fields;
    private EventBinding onSave;
    private EventBinding onSaveError;

    public Eform() {

    }

    public Eform(String nameId, List<FieldForm> fields) {
        this.nameId = nameId;
        this.fields = fields;
    }

    public void addFields(List<FieldForm> newFields) {
        if (this.fields == null) {
            this.fields = new ArrayList<FieldForm>();
        }
        this.fields.addAll(newFields);
    }

    public void addField(FieldForm newField) {
        if (this.fields == null) {
            this.fields = new ArrayList<FieldForm>();
        }
        this.fields.add(newField);
    }

    public String getNameId() {
        return nameId;
    }

    public void setNameId(String nameId) {
        this.nameId = nameId;
    }

    public List<FieldForm> getFields() {
        return fields;
    }

    public void setFields(List<FieldForm> fields) {
        this.fields = fields;
    }

    public EventBinding getOnSave() {
        return onSave;
    }

    public void setOnSave(EventBinding onSave) {
        this.onSave = onSave;
    }

    public EventBinding getOnSaveError() {
        return onSaveError;
    }

    public void setOnSaveError(EventBinding onSaveError) {
        this.onSaveError = onSaveError;
    }

    public List<FieldForm> findFields(String fieldId)
    {
        Predicate<FieldForm> fieldFilter = field -> field.getId().equalsIgnoreCase(fieldId);

        // Recupera a lista contendo o id
        List<FieldForm> allFields = this.getFields();
        List<FieldForm> fields;
        fields = allFields.stream()
                .filter(fieldFilter)
                .collect(Collectors.toList());
        return fields;
    }

    public FieldForm findField(String fieldId)
    {
        FieldForm field = null;
        if(fieldId != null)
        {
            List<FieldForm> fields = this.findFields(fieldId);
            if (fields != null && !fields.isEmpty())
            {
                field = fields.get(0);
            }
        }
        return field;
    }
}
