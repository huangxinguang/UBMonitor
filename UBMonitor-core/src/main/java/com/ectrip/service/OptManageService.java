package com.ectrip.service;

import com.ectrip.model.OptRecord;
import com.ectrip.vo.OptRecordAndEnvVO;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by huangxinguang on 2017/4/20 下午2:18.
 * </p>
 * Desc:
 */
public interface OptManageService {
    /**
     * 保存操作记录和操作环境
     * @param request 请求request
     * @param remoteUser 远程系统用户
     * @param remoteIp  clientIP
     * @param sessionId 回话id
     * @param userAgent userAgent
     * @param reqUrl  请求URL
     * @param reqAction 请求动作
     * @param reqParams 请求参数
     * @param sceneNo 场景号
     * @param userId 系统登陆用户
     * @param sysCode 系统编号
     * @param channelCode 渠道号
     * @param optBrief 操作简介
     * @param optDesc 操作详情
     */
    void saveOptAndEnv(HttpServletRequest request,String remoteUser,String remoteIp,String sessionId,String userAgent, String reqUrl,
                                        String reqAction,String reqParams,String sceneNo,String userId,String sysCode,String channelCode,String optBrief,String optDesc);

    /**
     * 通过Id查询记录
     * @param optId 操作id
     * @return
     */
    OptRecordAndEnvVO getOptDetail(Integer optId);


    /**
     * 按条件查询操作记录和环境
     * @param pageNo 当前页号
     * @param pageSize 页面大小
     * @param userId  用户ID
     * @param sysCode 系统编号
     * @param channelCode 渠道编号
     * @param terminalName 终端名称
     * @param sessionId 回话id
     * @param reqUrl 请求url
     * @param sceneNo 场景编号
     * @return
     */
    PageInfo<OptRecordAndEnvVO> findOptRecordAndEnvListPage(Integer pageNo, Integer pageSize,String userId, String sysCode, String channelCode,String channelName, String terminalName, String sessionId, String reqUrl, String sceneNo);
}
