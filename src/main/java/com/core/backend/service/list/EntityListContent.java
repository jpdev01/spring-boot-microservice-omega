package com.core.backend.service.list;

import java.util.List;

public class EntityListContent {
    private List<String> cols;
    private List<List<Object>> rows;

    public EntityListContent(){}

    public EntityListContent(List<String> cols, List<List<Object>> rows) {
        this.cols = cols;
        this.rows = rows;
    }

    public List<String> getCols() {
        return cols;
    }

    public void setCols(List<String> cols) {
        this.cols = cols;
    }

    public List<List<Object>> getRows() {
        return rows;
    }

    public void setRows(List<List<Object>> rows) {
        this.rows = rows;
    }
}
