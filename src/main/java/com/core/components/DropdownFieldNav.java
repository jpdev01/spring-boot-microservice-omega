package com.core.components;

import java.util.ArrayList;
import java.util.List;

public class DropdownFieldNav implements FieldNavInterface{
    private String title;
    private String icon;
    private List<FieldNav> fields = new ArrayList<>();

    public DropdownFieldNav(String title, String icon, List<FieldNav> fields) {
        this.title = title;
        this.icon = icon;
        this.fields = fields;
    }

    public DropdownFieldNav(String title, String image) {
        this.title = title;
        this.icon = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<FieldNav> getFields() {
        return fields;
    }

    public void setFields(List<FieldNav> fields) {
        this.fields = fields;
    }

    public void addField(FieldNav newField)
    {
        this.fields.add(newField);
    }
}
