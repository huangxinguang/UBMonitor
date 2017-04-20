package com.ectrip.model;

/**
 * Created by huangxinguang on 2017/4/19 下午3:32.
 * </p>
 * Desc:
 */
public class OptRecord {
    private Integer id;
    private String sysCode;
    private String channelCode;
    private String channelName;
    private String terminalName;
    private String sessionId;
    private String reqParams;
    private String reqUrl;
    private String userId;
    private String sceneNo;
    private String reqMethodName;
    private String optBrief;
    private String optTime;
    private String optDescription;
    private Integer envId;

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
}
