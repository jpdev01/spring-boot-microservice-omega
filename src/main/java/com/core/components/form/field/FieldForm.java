package com.core.components.form.field;

public abstract class FieldForm {
    private String id;
    private String label;
    private String group;
    private FieldFormType fieldType;

    public FieldForm(String id, String label, String group)
    {
        this.setId(id);
        this.setLabel(label);
        this.setGroup(group);
    }

    public FieldForm(String id, String label, String group, FieldFormType type)
    {
        this.setId(id);
        this.setLabel(label);
        this.setGroup(group);
        this.fieldType = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public FieldFormType getFieldType() {
        return fieldType;
    }

    public void setFieldType(FieldFormType fieldType) {
        this.fieldType = fieldType;
    }
}
