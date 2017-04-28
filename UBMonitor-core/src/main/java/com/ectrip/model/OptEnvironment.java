package com.ectrip.model;

import java.util.List;

/**
 * Created by huangxinguang on 2017/4/20 上午9:14.
 * </p>
 * Desc:用户环境信息实体类
 */
public class OptEnvironment {
    private Integer id;             //自增主键
    private String ip;              //用户IP
    private String clientIp;        //客户端ip
    private String mac;             //mac地址
    private String imei;            //
    private String operators;       //操作用户
    private String manufacturer;    //运营商
    private String phoneModel;      //手机型号
    private String computerName;    //电脑名称
    private String os;              //操作系统
    private String osVersion;       //操作系统版本
    private String resolution;      //布局
    private String font;            //字体
    private String fontSize;        //字体大小
    private String browser;         //浏览器
    private String browserVersion;  //浏览器版本
    private String appName;         //APP名称
    private String appType;         //APP类型
    private String appVersion;      //APP版本
    private String longitude;       //经度
    private String latitude;        //纬度
    private String internetType;    //网络类型
    private String isEmulator;      //是否虚拟机
    private String deviceId;        //设备ID

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getOperators() {
        return operators;
    }

    public void setOperators(String operators) {
        this.operators = operators;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getPhoneModel() {
        return phoneModel;
    }

    public void setPhoneModel(String phoneModel) {
        this.phoneModel = phoneModel;
    }

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public String getFontSize() {
        return fontSize;
    }

    public void setFontSize(String fontSize) {
        this.fontSize = fontSize;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getBrowserVersion() {
        return browserVersion;
    }

    public void setBrowserVersion(String browserVersion) {
        this.browserVersion = browserVersion;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getInternetType() {
        return internetType;
    }

    public void setInternetType(String internetType) {
        this.internetType = internetType;
    }

    public String getIsEmulator() {
        return isEmulator;
    }

    public void setIsEmulator(String isEmulator) {
        this.isEmulator = isEmulator;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public String toString() {
        return "OptEnvironment{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", clientIp='" + clientIp + '\'' +
                ", mac='" + mac + '\'' +
                ", imei='" + imei + '\'' +
                ", operators='" + operators + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", phoneModel='" + phoneModel + '\'' +
                ", computerName='" + computerName + '\'' +
                ", os='" + os + '\'' +
                ", osVersion='" + osVersion + '\'' +
                ", resolution='" + resolution + '\'' +
                ", font='" + font + '\'' +
                ", fontSize='" + fontSize + '\'' +
                ", browser='" + browser + '\'' +
                ", browserVersion='" + browserVersion + '\'' +
                ", appName='" + appName + '\'' +
                ", appType='" + appType + '\'' +
                ", appVersion='" + appVersion + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", internetType='" + internetType + '\'' +
                ", isEmulator='" + isEmulator + '\'' +
                ", deviceId='" + deviceId + '\'' +
                '}';
    }
}
