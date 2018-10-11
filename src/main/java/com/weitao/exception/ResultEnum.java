package com.weitao.exception;

/**
 * Created by lzr on 2018/9/5.
 */
public enum ResultEnum {
    UNKNOW_ERROR("-1","未知错误"),
    SUCCESS("0","成功"),
    USER_LOGIN_FAIL("100","登陆失败"),
    USERNAME_EXIST("101","用户名已存在"),
    USER_NOT_EXIST("102","用户名不存在"),

    USER_NOT_FAIL("103","查询用户失败"),

    ITEMS_EXSIT("201","库存小于0"),
    ITEMS_INSERT_FAIL("202","商品添加失败"),
    ITEMS_DELETE_FAIL("203","商品上架失败"),

    USER_GET_FAIL("103","查询用户失败"),
    USER_RSVISE_FAIL("104","用户信息修改失败"),
    USER_PASSWROD_FAIL("105","用户密码错误"),
    USER_REGISTER_FAIL("106","用户注册失败"),
    USER_REVISE_PASSWROD_FAIL("107","用户修改密码错误"),
    USER_PHONE_FAIL("108","用户电话输入错误"),
    USER_LOCK("109","用户被锁定"),
    USER_LOCK_FAIL("110","封号失败"),
    USER_UNLOCK_FAIL("111","解封失败"),
    USER_NORMAL("112","用户状态正常"),


    ORDER_USER_FAIL("301","订单查询错误"),
    ORDER_CONFIRM_FAIL("302","订单确认错误"),
    ORDER_REFUND_FAIL("303","订单退款错误"),
    ORDER_CANCEL_FAIL("304","订单取消错误"),
    ORDER_SEND_FAIL("304","订单发货错误"),

    DETAIL_USER_FAIL("401","订单明细查询错误"),

    EVALUATE_FAIL("501","评论失败"),
    EVALUATE_SELECT_FAIL("502","查询商品评论失败"),
    EVALUATE_NOT_FOUND_EVALUATION("503","没有相关任何评论"),

    STORE_NOT_FOUND("701","没有符合该查询条件的店铺"),
    STORE_INSERT_FAIL("702","店铺添加失败"),
    STORE_CHANGE_FAIL("703","修改店铺信息失败"),

    MANAGE_INSERT_FAIL("901","添加管理员失败"),
    MANAGE_INSERT_GO("902","添加管理员失败"),
    MANAGE_INSERT_NOPOWER("903","无权限添加管理员")

    ;
    private String code;
    private String msg;

    ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
