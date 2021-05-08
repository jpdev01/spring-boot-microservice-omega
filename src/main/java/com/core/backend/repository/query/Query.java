package com.core.backend.repository.query;

import java.util.ArrayList;

public class Query {
    private String comparator;
    private StringBuilder sb = new StringBuilder();
    private ArrayList<String> colParams = new ArrayList<>();
    private Class from;

    public Query() {
    }

    public Query(String comparator, Class from)
    {
        this.comparator = comparator;
        this.from = from;
    }

    public Query(Class from)
    {
        this.comparator = comparator;
        this.from = from;
        this.sb.append("FROM " + from.getSimpleName());
    }

    public Query(String comparator) {
        this.comparator = comparator;
    }

    public String getComparator() {
        return comparator;
    }

    public void setComparator(String comparator) {
        this.comparator = comparator;
    }

    public StringBuilder getSb() {
        return sb;
    }

    public void setSb(StringBuilder sb) {
        this.sb = sb;
    }

    public void addFilter() {

    }

    public Class getFrom() {
        return from;
    }

    public void setFrom(Class from) {
        this.from = from;
    }

    public void addSelect(String objects) {
        this.sb.append("SELECT ");
        this.sb.append(objects);
        this.sb.append(" FROM " + this.from.getSimpleName());
    }

    public void addSelect(ArrayList<String> objects) {
        this.colParams = objects;
        this.sb.append("SELECT ");
        this.selectBuild();
        this.sb.append(" FROM " + this.from.getSimpleName());
    }

    private void selectBuild() {
        ///this.sb.append("SELECT ");
        if (this.colParams != null) {
            int last = this.colParams.size() - 1;
            for (int i = 0; i < this.colParams.size(); i++) {
                String field = this.colParams.get(i);
                sb.append(field);

                boolean isLast = field.equals(this.colParams.get(last));
                if (!isLast) {
                    sb.append(",");
                }
                sb.append(" ");
            }
        }
    }

    public ArrayList<String> getColParams() {
        return colParams;
    }

    public void setColParams(ArrayList<String> colParams) {
        this.colParams = colParams;
    }

}
