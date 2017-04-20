package com.ectrip.service;

import com.ectrip.model.OptRecord;

/**
 * Created by huangxinguang on 2017/4/20 下午2:18.
 * </p>
 * Desc:
 */
public interface OptManageService {
    /**
     * 保存用户操作，和操作环境
     * @param hostName
     * @param userAgent
     * @param accept
     * @param acceptLanguage
     * @param acceptEncoding
     * @param keepAlive
     * @param cookies
     * @param sessionId
     * @param optRecord
     */
    void saveOptAndEnv(String hostName, String userAgent, String accept, String acceptLanguage, String acceptEncoding, String keepAlive, String cookies, String sessionId, OptRecord optRecord);
}
