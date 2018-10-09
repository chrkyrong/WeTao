package com.weitao.vo;

import com.weitao.bean.Items;
import com.weitao.bean.Store;

public class DataVo {
    private Items items;
    private Store store;

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    @Override
    public String toString() {
        return "DataVo{" +
                "items=" + items +
                ", store=" + store +
                '}';
    }
}
