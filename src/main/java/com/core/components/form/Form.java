package com.core.components.form;

import com.core.components.form.field.FieldForm;

import java.util.ArrayList;
import java.util.List;

public class Form {
    private String nameId;
    private List<FieldForm> fields;

    public Form()
    {

    }

    public Form(String nameId, List<FieldForm> fields) {
        this.nameId = nameId;
        this.fields = fields;
    }

    public void addFields(List<FieldForm> newFields)
    {
        if (this.fields == null)
        {
            this.fields = new ArrayList<FieldForm>();
        }
        this.fields.addAll(newFields);
    }

    public void addField(FieldForm newField)
    {
        if (this.fields == null)
        {
            this.fields = new ArrayList<FieldForm>();
        }
        this.fields.add(newField);
    }
}
