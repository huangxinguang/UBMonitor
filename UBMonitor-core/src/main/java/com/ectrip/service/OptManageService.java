package com.ectrip.service;

import com.ectrip.model.OptRecord;
import com.ectrip.utils.Page;
import com.ectrip.vo.OptRecordAndEnvVO;

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
     * 查询
     * @param pageNo
     * @param userId
     * @param sysCode
     * @param channelCode
     * @param terminalName
     * @param sessionId
     * @param reqUrl
     * @param sceneNo
     * @return
     */
    Page<OptRecordAndEnvVO> findOptRecordAndEnvListPage(Integer pageNo, String userId, String sysCode, String channelCode, String terminalName, String sessionId, String reqUrl, String sceneNo);
}
