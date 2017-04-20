package com.ectrip.service.impl;

import com.ectrip.dao.OptEnvironmentDAO;
import com.ectrip.dao.OptRecordDAO;
import com.ectrip.model.OptEnvironment;
import com.ectrip.model.OptRecord;
import com.ectrip.service.OptManageService;
import com.ectrip.utils.NetUtil;
import nl.bitwalker.useragentutils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by huangxinguang on 2017/4/20 下午2:24.
 * </p>
 * Desc:
 */
@Service
public class OptManageServiceImpl implements OptManageService {

    @Autowired
    private OptEnvironmentDAO optEnvironmentDAO;

    @Autowired
    private OptRecordDAO optRecordDAO;

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Override
    public void saveOptAndEnv(final HttpServletRequest request, final OptRecord optRecord) {

        // 使用线程池多线程处理
        threadPoolTaskExecutor.execute(new Runnable() {
            public void run() {
                try {
                    String sessionId = request.getRequestedSessionId();
                    String operators = request.getRemoteUser();
                    String url = request.getRequestURL().toString();
                    String ip = request.getRemoteAddr();
                    String mac = NetUtil.getMACAddress(ip);
                    optRecord.setReqUrl(url);
                    optRecord.setSessionId(sessionId);

                    String userAgent = request.getHeader("User-Agent");


                    UserAgent userAgentInfo = UserAgent.parseUserAgentString(userAgent);
                    Browser browser = userAgentInfo.getBrowser();
                    Version version = userAgentInfo.getBrowserVersion();

                    OperatingSystem operatingSystem = userAgentInfo.getOperatingSystem();


                    OptEnvironment env = new OptEnvironment();
                    env.setIp(ip);
                    env.setMac(mac);
                    env.setComputerName(operatingSystem.getDeviceType().getName());
                    env.setOperators(operators);
                    env.setBrowser(browser.getName());
                    env.setBrowserVersion(version.getVersion());
                    env.setOs(operatingSystem.getName());
                    env.setOsVersion(operatingSystem.getDeviceType().getName());
                    env.setManufacturer(operatingSystem.getManufacturer().getName());
                    env.setPhoneModel(NetUtil.getPhoneModel(userAgent));
                    env.setDeviceId(operatingSystem.getId()+"");

                    optEnvironmentDAO.save(env);


                    optRecord.setEnvId(env.getId());
                    optRecordDAO.save(optRecord);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 根据指定条件查询用户操作记录以及操作时的用户环境
     * @param optRecord
     */
    public OptRecord findOptRecordInfo(OptRecord optRecord){
        return optRecordDAO.findOptRecordInfo(optRecord);
    }

}
