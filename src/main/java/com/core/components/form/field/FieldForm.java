package com.core.components.form.field;

public abstract class FieldForm {
    private String id;
    private String label;

    public FieldForm(String id, String label)
    {
        this.setId(id);
        this.setLabel(label);
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
}
