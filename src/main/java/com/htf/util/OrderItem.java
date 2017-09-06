package com.htf.util;

/**
 * Created by PC-FENG on 2017/9/6.
 */
public class OrderItem {
    private String columnName;
    private boolean asc;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public boolean isAsc() {
        return asc;
    }

    public void setAsc(boolean asc) {
        this.asc = asc;
    }
}
