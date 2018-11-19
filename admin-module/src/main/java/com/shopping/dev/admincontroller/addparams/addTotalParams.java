package com.shopping.dev.admincontroller.addparams;

import java.util.List;

public class addTotalParams<T> {
    private List<T> rows;
    private int total;

    public addTotalParams(List<T> rows, int total) {
        this.rows = rows;
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
