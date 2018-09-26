package com.weitao.vo;

import com.weitao.bean.Store;

/**
 * @Author:Cc
 * @Date:2018/9/16
 * @program: weitao
 * @description: ${description}
 * @create: 2018-09-16 15:03
 */
public class StoreVo extends Store {
    private Store store;
    private String sAccount;

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public String getsAccount() {
        return sAccount;
    }

    public void setsAccount(String sAccount) {
        this.sAccount = sAccount;
    }

    @Override
    public String toString() {
        return "StoreVo{" +
                "store=" + super.toString() +
                ", sAccount='" + sAccount + '\'' +
                '}';
    }
}
