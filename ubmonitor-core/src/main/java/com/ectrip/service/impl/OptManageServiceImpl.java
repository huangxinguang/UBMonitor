package com.ectrip.service.impl;

import com.ectrip.dao.OptEnvironmentDAO;
import com.ectrip.dao.OptRecordDAO;
import com.ectrip.model.OptRecord;
import com.ectrip.service.OptManageService;
import com.ectrip.utils.UserAgentUtil;
import cz.mallat.uasparser.UserAgentInfo;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by huangxinguang on 2017/4/20 下午2:24.
 * </p>
 * Desc:
 */
public class OptManageServiceImpl implements OptManageService {

    @Autowired
    private OptEnvironmentDAO optEnvironmentDAO;

    @Autowired
    private OptRecordDAO optRecordDAO;

    @Override
    public void saveOptAndEnv(String hostName, String userAgent, String accept, String acceptLanguage, String acceptEncoding, String keepAlive, String cookies, String sessionId, OptRecord optRecord) {
        UserAgentInfo userAgentInfo = UserAgentUtil.parse(userAgent);

    }
}
