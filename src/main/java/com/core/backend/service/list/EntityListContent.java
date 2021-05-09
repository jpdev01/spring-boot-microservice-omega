package com.core.backend.service.list;

import java.util.ArrayList;
import java.util.List;

public class EntityListContent {
    private List<Object> cols;
    private List<Row> rows;
    private boolean inputRadioInRows;

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

    public boolean isInputRadioInRows() {
        return inputRadioInRows;
    }

    public void setInputRadioInRows(boolean inputRadioInRows) {
        this.inputRadioInRows = inputRadioInRows;
    }
}
