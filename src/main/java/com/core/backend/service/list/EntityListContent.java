package com.core.backend.service.list;

import java.util.List;

public class EntityListContent {
    private List<String> cols;
    private List<Row> rows;

    public EntityListContent(){}

    public EntityListContent(List<String> cols, List<Row> rows) {
        this.cols = cols;
        this.rows = rows;

    }

    public List<String> getCols() {
        return cols;
    }

    public void setCols(List<String> cols) {
        this.cols = cols;
    }

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

}
