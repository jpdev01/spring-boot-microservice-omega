package com.core.components.form.field;

import com.core.custom.Permission;

import java.util.HashMap;
import java.util.List;

public class SelectFieldForm extends FieldForm{
    private List<Object> options;
    public SelectFieldForm(String id, String label, List<Object> options, Integer group)
    {
        super(id, label, group, FieldFormType.SELECT);
        this.options = options;
    }

//    public SelectFieldForm(Class options)
//    {
//        System.out.println(options);
//        //this.options = options;
//

    public List<Object> getOptions() {
        return options;
    }

    public void setOptions(List<Object> options) {
        this.options = options;
    }
}
