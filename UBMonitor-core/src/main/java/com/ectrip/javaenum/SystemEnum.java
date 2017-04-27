package com.ectrip.javaenum;

/**
 * Created by huangxinguang on 2017/4/27 上午9:35.
 */
public enum SystemEnum {

    PMS("pms","PMS"),CYT("cyt","畅游通");

    private String code;
    private String name;

    SystemEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
