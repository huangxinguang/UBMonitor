package com.ectrip.service.impl;

import com.ectrip.dao.OptEnvironmentDAO;
import com.ectrip.dao.OptRecordAndEnvDAO;
import com.ectrip.dao.OptRecordDAO;
import com.ectrip.model.OptEnvironment;
import com.ectrip.model.OptRecord;
import com.ectrip.service.OptManageService;
import com.ectrip.utils.MyUserAgentUtil;
import com.ectrip.utils.NetUtil;
import com.ectrip.utils.Page;
import com.ectrip.vo.OptRecordAndEnvVO;
import com.github.pagehelper.PageInfo;
import eu.bitwalker.useragentutils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by huangxinguang on 2017/4/20 下午2:24.
 * </p>
 * Desc:
 */
@Service
public class OptManageServiceImpl implements OptManageService {

    private Logger logger = LoggerFactory.getLogger(OptManageServiceImpl.class);

    @Autowired
    private OptEnvironmentDAO optEnvironmentDAO;

    @Autowired
    private OptRecordAndEnvDAO optRecordAndEnvDAO;

    @Autowired
    private OptRecordDAO optRecordDAO;

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;


    public void saveOptAndEnv(final HttpServletRequest request, final OptRecord optRecord) {
        threadPoolTaskExecutor.execute(new Runnable() {
            public void run() {
                String sessionId = request.getRequestedSessionId();
                String operators = request.getRemoteUser();
                String ip = request.getRemoteAddr();
                //String clientIp = NetUtil.getIpAddr(request);
                String queryParams = request.getQueryString();
                //String mac = NetUtil.getMACAddress(ip);

                //解析user-agent
                String userAgent = request.getHeader("User-Agent");
                UserAgent userAgentInfo = UserAgent.parseUserAgentString(userAgent);
                Browser browser = userAgentInfo.getBrowser();//拿到浏览器信息
                BrowserType browserType = userAgentInfo.getBrowser().getBrowserType();
                Version version = userAgentInfo.getBrowserVersion();//浏览器版本信息
                OperatingSystem operatingSystem = userAgentInfo.getOperatingSystem();//操作系统信息

                //组装envionment
                OptEnvironment env = new OptEnvironment();
                env.setIp(ip);
                //env.setClientIp(clientIp);
                //env.setMac(mac);
                env.setComputerName(operatingSystem.getDeviceType().getName());
                env.setOperators(operators);
                env.setBrowser(browser.getName());
                env.setBrowserVersion(version.getVersion());
                env.setOs(operatingSystem.getName());
                env.setOsVersion(operatingSystem.getDeviceType().getName());
                env.setManufacturer(operatingSystem.getManufacturer().getName());
                env.setPhoneModel(MyUserAgentUtil.getPhone(userAgent));
                env.setDeviceId(operatingSystem.getId()+"");

                //app
                if(BrowserType.APP.getName().equals(browserType.getName())) {
                    env.setAppName(browserType.getName());
                    env.setAppType(operatingSystem.getDeviceType().getName());
                    env.setAppVersion(userAgentInfo.getBrowserVersion().getVersion());
                }
                try {
                    optEnvironmentDAO.save(env);

                    //组装用户操作
                    optRecord.setSessionId(sessionId);
                    optRecord.setEnvId(env.getId());
                    optRecord.setTerminalName(operatingSystem.getName());
                    optRecordDAO.save(optRecord);

                } catch (Exception e) {
                    logger.info("保存记录异常",e);
                    e.printStackTrace();
                }
            }
        });
    }

    public Page<OptRecordAndEnvVO> findOptRecordAndEnvListPage(Integer pageNo,String userId, String sysCode, String channelCode, String terminalName, String sessionId, String reqUrl, String sceneNo) {
        Page page = new Page();
        if(pageNo != null) {
            page.setCurrentPage(pageNo);
        }
        try {
            List<OptRecordAndEnvVO> optRecordAndEnvVOList = optRecordAndEnvDAO.findOptRecordListPage(page, userId, sysCode, channelCode, terminalName, sessionId, reqUrl, sceneNo);
            page.setDataList(optRecordAndEnvVOList);
        }catch (Exception e) {
            logger.info("查询记录异常",e);
            e.printStackTrace();
        }
        return page;
    }

    @Override
    public PageInfo<OptRecordAndEnvVO> findOptRecordAndEnvListPage(Integer pageNo, Integer pageSize, String userId, String sysCode, String channelCode, String terminalName, String sessionId, String reqUrl, String sceneNo) {
        List<OptRecordAndEnvVO> list = optRecordAndEnvDAO.findOptRecordListPage(pageNo,pageSize,userId,sysCode,channelCode,terminalName,sessionId,reqUrl,sceneNo);
        return new PageInfo<>(list);
    }
}
