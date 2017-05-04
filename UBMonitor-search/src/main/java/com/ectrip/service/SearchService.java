package com.ectrip.service;

import com.ectrip.common.SearchResult;

/**
 * Created by huangxinguang on 2017/4/28 下午3:00.
 */
public interface SearchService {
    /**
     * 搜索
     * @param offset 开始记录
     * @param limit  页面大小
     * @param userId 用户id
     * @param sysCode 系统编号
     * @param channelCode 渠道编号
     * @param channelName 渠道名称
     * @param terminalName 终端名称
     * @param sessionId 回话id
     * @param reqUrl 请求url
     * @param sceneNo 场景编号
     * @return
     */
    SearchResult searchOptRecordList(Integer offset, Integer limit, String userId, String sysCode, String channelCode, String channelName, String terminalName, String sessionId, String reqUrl, String sceneNo);
}
