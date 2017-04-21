package com.ectrip.dao;

import com.ectrip.utils.Page;
import com.ectrip.vo.OptRecordAndEnvVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by huangxinguang on 2017/4/21 下午1:39.
 * </p>
 * Desc:
 */
public interface OptRecordAndEnvDAO {
    /**
     * 按条件查询操作记录和环境
     * @param userId
     * @param sysCode
     * @param channelCode
     * @param terminalName
     * @param sessionId
     * @param reqUrl
     * @param sceneNo
     * @return
     */
    List<OptRecordAndEnvVO> findOptRecordListPage(@Param("page") Page page, @Param("userId") String userId, @Param("sysCode") String sysCode, @Param("channelCode") String channelCode,
                                              @Param("terminalName") String terminalName, @Param("sessionId")String sessionId, @Param("reqUrl")String reqUrl, @Param("sceneNo")String sceneNo);
}
