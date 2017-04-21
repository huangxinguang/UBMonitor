package com.ectrip.service;

import com.ectrip.model.OptRecord;
import com.ectrip.utils.Page;
import com.ectrip.vo.OptRecordAndEnvVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by huangxinguang on 2017/4/20 下午2:18.
 * </p>
 * Desc:
 */
public interface OptManageService {

    /**
     * 根据指定条件查询用户操作记录以及操作时的用户环境
     * @param optRecord
     */
    OptRecord findOptRecordInfo(OptRecord optRecord);

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
    Page<OptRecordAndEnvVO> findOptRecordAndEnvListPage(int pageNo, String userId, String sysCode, String channelCode, String terminalName, String sessionId, String reqUrl, String sceneNo);
}
