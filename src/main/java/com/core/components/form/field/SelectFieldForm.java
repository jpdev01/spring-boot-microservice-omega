package com.core.components.form.field;

import com.core.custom.Permission;

import java.util.HashMap;
import java.util.List;

public class SelectFieldForm extends FieldForm{
    public SelectFieldForm(String id, String label, List<String> options, String group)
    {
        super(id, label, group);
        this.options = options;
    }

//    public SelectFieldForm(Class options)
//    {
//        System.out.println(options);
//        //this.options = options;
//    }
    private List<String> options;
}
