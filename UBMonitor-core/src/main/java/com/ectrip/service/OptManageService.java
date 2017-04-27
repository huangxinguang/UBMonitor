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
     * 保存用户操作，和操作环境
     * @param optRecord
     */
    void saveOptAndEnv(HttpServletRequest request,OptRecord optRecord);

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
