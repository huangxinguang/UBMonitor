package com.ectrip.model;

/**
 * Created by huangxinguang on 2017/4/19 下午3:32.
 * </p>
 * Desc:用户行为操作记录实体类
 */
public class OptRecord {
    private Integer id;             //自增主键
    private String sysCode;         //系统编号
    private String channelCode;     //渠道编号
    private String channelName;     //渠道名称
    private String terminalName;    //终端
    private String sessionId;       //会话ID
    private String reqParams;       //请求参数
    private String reqUrl;          //请求路径
    private String userId;          //用户编号
    private String sceneNo;         //场景号
    private String reqMethodName;   //请求路径中文名称
    private String optBrief;        //操作简介
    private String optTime;         //操作时间
    private String optDescription;  //操作详情
    private Integer envId;          //操作环境编号

    private OptEnvironment optEnvironment;//用户操作环境对象

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getTerminalName() {
        return terminalName;
    }

    public void setTerminalName(String terminalName) {
        this.terminalName = terminalName;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getReqParams() {
        return reqParams;
    }

    public void setReqParams(String reqParams) {
        this.reqParams = reqParams;
    }

    public String getReqUrl() {
        return reqUrl;
    }

    public void setReqUrl(String reqUrl) {
        this.reqUrl = reqUrl;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSceneNo() {
        return sceneNo;
    }

    public void setSceneNo(String sceneNo) {
        this.sceneNo = sceneNo;
    }

    public String getReqMethodName() {
        return reqMethodName;
    }

    public void setReqMethodName(String reqMethodName) {
        this.reqMethodName = reqMethodName;
    }

    public String getOptBrief() {
        return optBrief;
    }

    public void setOptBrief(String optBrief) {
        this.optBrief = optBrief;
    }

    public String getOptTime() {
        return optTime;
    }

    public void setOptTime(String optTime) {
        this.optTime = optTime;
    }

    public String getOptDescription() {
        return optDescription;
    }

    public void setOptDescription(String optDescription) {
        this.optDescription = optDescription;
    }

    public Integer getEnvId() {
        return envId;
    }

    public void setEnvId(Integer envId) {
        this.envId = envId;
    }

    public OptEnvironment getOptEnvironment() {
        return optEnvironment;
    }

    public void setOptEnvironment(OptEnvironment optEnvironment) {
        this.optEnvironment = optEnvironment;
    }


}
