package com.ssm.bean;

public class Example {
    private Integer id;

    private String what;

    private String is;

    private String love;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what == null ? null : what.trim();
    }

    public String getIs() {
        return is;
    }

    public void setIs(String is) {
        this.is = is == null ? null : is.trim();
    }

    public String getLove() {
        return love;
    }

    public void setLove(String love) {
        this.love = love == null ? null : love.trim();
    }
}