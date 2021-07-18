package com.core.components;

import java.util.List;

public class TreeComponent<T> {
    private String name;
    private List<T> fields;
    private String urlRest;

    public TreeComponent(){

    }

    public TreeComponent(String name, List<T> fields) {
        this.name = name;
        this.fields = fields;
    }

    public TreeComponent(String urlRest){
        this.urlRest = urlRest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<T> getFields() {
        return fields;
    }

    public void setFields(List<T> fields) {
        this.fields = fields;
    }

    public String getUrlRest() {
        return urlRest;
    }

    public void setUrlRest(String urlRest) {
        this.urlRest = urlRest;
    }
}
