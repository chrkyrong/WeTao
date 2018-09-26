package com.weitao.vo;

import com.weitao.bean.Order;
import com.weitao.bean.Store;

/**
 * @Author:Cc
 * @Date:2018/9/20
 * @program: weitao
 * @description: ${description}
 * @create: 2018-09-20 22:55
 */
public class EvaluateVo2 extends EvaluateVo{
    private EvaluateVo evaluateVo;
    private Store store;
    private Order order;

    public EvaluateVo getEvaluateVo() {
        return evaluateVo;
    }

    public void setEvaluateVo(EvaluateVo evaluateVo) {
        this.evaluateVo = evaluateVo;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "EvaluateVo2{" +
                "evaluateVo=" + evaluateVo +
                ", store=" + store +
                ", order=" + order +
                '}';
    }
}
