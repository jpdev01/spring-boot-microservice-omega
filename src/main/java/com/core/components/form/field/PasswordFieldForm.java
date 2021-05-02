package com.core.components.form.field;

public class PasswordFieldForm extends FieldForm{
    public PasswordFieldForm(String id, String label, String group)
    {
        super(id, label, group, FieldFormType.PASSWORD);
    }
    private String value;
}
