package com.ectrip.javaenum;

/**
 * Created by huangxinguang on 2017/4/28 上午9:37.
 */
public enum ChannelEnum {
    qingdu("502","青都"),jiuwang("602","九网");

    private String code;
    private String name;

    ChannelEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static ChannelEnum forCode(String code) {
        for(ChannelEnum ce:ChannelEnum.values()) {
            if(ce.getCode().equals(code)) {
                return ce;
            }
        }
        return null;
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
