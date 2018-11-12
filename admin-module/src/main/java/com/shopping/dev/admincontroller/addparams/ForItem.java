package com.shopping.dev.admincontroller.addparams;

import com.shopping.dev.entity.Item;

import java.util.List;

public class ForItem {
    private List<Item> items;
    private int total;

    public ForItem() {
    }

    public ForItem(List<Item> items, int total) {
        this.items = items;
        this.total = total;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
