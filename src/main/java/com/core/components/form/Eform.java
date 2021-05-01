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
}
