package com.core.backend.service.list;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private Integer key;
    private List<Object> value = new ArrayList<>();

    public Row(){}

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public List<Object> getValue() {
        return value;
    }

    public void setValue(List<Object> value) {
        this.value = value;
    }
}
