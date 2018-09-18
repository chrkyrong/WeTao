package com.weitao.vo;

import com.weitao.bean.Evaluate;

/**
 * @Author:Cc
 * @Date:2018/9/17
 * @program: weitao
 * @description: ${description}
 * @create: 2018-09-17 19:03
 */
public class EvaluateVo extends Evaluate{
    private Evaluate evaluate;
    private String uIcon;
    private String uUserName;

//    会不会还缺了一个商品简介，商品名字

    public Evaluate getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(Evaluate evaluate) {
        this.evaluate = evaluate;
    }

    public String getuIcon() {
        return uIcon;
    }

    public void setuIcon(String uIcon) {
        this.uIcon = uIcon;
    }

    public String getuUserName() {
        return uUserName;
    }

    public void setuUserName(String uUserName) {
        this.uUserName = uUserName;
    }

    @Override
    public String toString() {
        return "EvaluateVo{" +
                "evaluate=" + super.toString() +
                ", uIcon='" + uIcon + '\'' +
                ", uUserName='" + uUserName + '\'' +
                '}';
    }
}
