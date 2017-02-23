package com.wy.common.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/2/23.
 */
public class Pager4EasyUI<T> {
    private int total;
    private List<T> rows;

    public Pager4EasyUI() {

    }

    public Pager4EasyUI(int total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "Pager4EasyUI{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
