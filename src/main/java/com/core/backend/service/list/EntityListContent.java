package com.core.backend.service.list;

import java.util.List;

public class EntityListContent {
    private List<String> cols;
    private List<List<String>> rows;

    public EntityListContent(){}

    public EntityListContent(List<String> cols, List<List<String>> rows) {
        this.cols = cols;
        this.rows = rows;
    }

    public List<String> getCols() {
        return cols;
    }

    public void setCols(List<String> cols) {
        this.cols = cols;
    }

    public List<List<String>> getRows() {
        return rows;
    }

    public void setRows(List<List<String>> rows) {
        this.rows = rows;
    }
}
