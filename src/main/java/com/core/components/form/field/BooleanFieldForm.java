package com.core.components.form.field;

public class BooleanFieldForm extends FieldForm{
    private Boolean value;

    public BooleanFieldForm(String id, String label, Integer group) {
        super(id, label, group, FieldFormType.BOOLEAN);
    }
}
