package com.core.backend.service.list;

import com.core.components.form.field.FieldFormType;

import java.util.ArrayList;
import java.util.List;

public class EntityListContent {
    private List<Object> cols;
    private List<Row> rows;
    private FieldFormType input;

    public EntityListContent(){}

    public EntityListContent(List<Object> cols, List<Row> rows) {
        this.cols = cols;
        this.rows = rows;
    }

    public List<Object> getCols() {
        return cols;
    }

    public void setCols(List<Object> cols) {
        this.cols = cols;
    }

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    public void addCol(String col)
    {
        if (this.cols == null)
        {
            this.cols = new ArrayList<>();
        }
        this.cols.add(col);
    }

    public FieldFormType getInput() {
        return input;
    }

    public void setInput(FieldFormType input) {
        this.input = input;
    }
}
