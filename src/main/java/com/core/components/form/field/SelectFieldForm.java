package com.core.components.form.field;

import com.core.custom.Permission;

import java.util.HashMap;
import java.util.List;

public class SelectFieldForm extends FieldForm{
    public SelectFieldForm(String id, String label, List<Permission> options, String group)
    {
        super(id, label, group, FieldFormType.SELECT);
        this.options = options;
    }

//    public SelectFieldForm(Class options)
//    {
//        System.out.println(options);
//        //this.options = options;
//    }
    private List<Permission> options;

    public List<Permission> getOptions() {
        return options;
    }

    public void setOptions(List<Permission> options) {
        this.options = options;
    }
}
