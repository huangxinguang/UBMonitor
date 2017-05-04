package com.ectrip.common.utils;

/**
 * Created by huangxinguang on 2017/4/21 上午9:51.
 * </p>
 * Desc:
 */
public class MyUserAgentUtil {
    public static String android="Android";
    public static String iphone="iPhone";
    public static String ipad="iPad";
    //获取用户操作系统
    public static String getOS(String userAgent){
        if (userAgent.contains(android)) {
            return android;
        }else if (userAgent.contains(iphone)){
            return iphone;
        }else if (userAgent.contains(ipad)){
            return ipad;
        }else {
            return "others";
        }
    }
    //获取用户手机型号
    public static String getPhone(String userAgent){
        String OS=MyUserAgentUtil.getOS(userAgent);
        String phoneStr="不知名的手机";
        if (OS.equals(android)) {
            String rex="[()]+";
            String[] str=userAgent.split(rex);
            str = str[1].split("[;]");
            String[] res=str[str.length-1].split("Build/");
            return res[0];
        }else if (OS.equals(iphone)) {
            String[] str=userAgent.split("[()]+");
            String res="iphone"+str[1].split("OS")[1].split("like")[0];
            return res;
        }else if (OS.equals(ipad)) {
            return ipad;
        }else {
            return "";
        }
    }
}
