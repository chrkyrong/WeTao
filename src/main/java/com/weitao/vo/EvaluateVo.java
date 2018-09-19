package com.weitao.vo;

import com.weitao.bean.Evaluate;
import com.weitao.bean.Items;
import com.weitao.bean.User;

/**
 * @Author:Cc
 * @Date:2018/9/17
 * @program: weitao
 * @description: ${description}
 * @create: 2018-09-17 19:03
 */
public class EvaluateVo extends Evaluate{
    private Evaluate evaluate;
    private User user;
    private Items items;

    public Evaluate getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(Evaluate evaluate) {
        this.evaluate = evaluate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "EvaluateVo{" +
                "evaluate=" + evaluate +
                ", user=" + user +
                ", items=" + items +
                '}';
    }
}
