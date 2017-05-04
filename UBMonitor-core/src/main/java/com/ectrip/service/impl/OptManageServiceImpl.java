package com.ectrip.service.impl;

import com.ectrip.dao.OptEnvironmentDAO;
import com.ectrip.dao.OptRecordAndEnvDAO;
import com.ectrip.dao.OptRecordDAO;
import com.ectrip.javaenum.ChannelEnum;
import com.ectrip.model.OptEnvironment;
import com.ectrip.model.OptRecord;
import com.ectrip.mq.service.OptProducerService;
import com.ectrip.service.OptManageService;
import com.ectrip.utils.DateUtil;
import com.ectrip.utils.MyUserAgentUtil;
import com.ectrip.vo.OptRecordAndEnvVO;
import com.github.pagehelper.PageInfo;
import eu.bitwalker.useragentutils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
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

    @Autowired
    private OptProducerService optProducerService;



    public void saveOptAndEnv(final HttpServletRequest request,final String remoteUser,final String remoteIp,final String sessionId,final String userAgent, final String reqUrl,
                                final String reqAction,final String reqParams,final String sceneNo,final String userId,final String sysCode,final String channelCode,final String optBrief,final String optDesc) {
        threadPoolTaskExecutor.execute(new Runnable() {
            public void run() {
                /** 解析userAgent*/
                UserAgent userAgentInfo = UserAgent.parseUserAgentString(userAgent);
                Browser browser = userAgentInfo.getBrowser();//拿到浏览器信息
                BrowserType browserType = userAgentInfo.getBrowser().getBrowserType();//浏览类型
                Version version = userAgentInfo.getBrowserVersion();//浏览器版本信息
                OperatingSystem operatingSystem = userAgentInfo.getOperatingSystem();//操作系统信息

                /**组装envionment*/
                OptEnvironment env = new OptEnvironment();
                env.setIp(request.getRemoteAddr());
                env.setClientIp((remoteIp));
                env.setComputerName(operatingSystem.getDeviceType().getName());
                env.setOperators(remoteUser);
                env.setBrowser(browser.getName());
                if(version != null) {
                    env.setBrowserVersion(version.getVersion());
                }
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

                OptRecord optRecord = new OptRecord();
                try {
                    logger.info("操作环境:{}",env.toString());
                    optEnvironmentDAO.save(env);

                    /**组装用户操作记录*/
                    optRecord.setSessionId(sessionId);
                    optRecord.setEnvId(env.getId());
                    optRecord.setOptTime(DateUtil.getDateTime(new Date()));
                    optRecord.setTerminalName(operatingSystem.getName());
                    optRecord.setChannelCode(channelCode);
                    optRecord.setChannelName(ChannelEnum.forCode(channelCode).getName());
                    optRecord.setSysCode(sysCode);
                    optRecord.setOptBrief(optBrief);
                    optRecord.setOptDescription(optDesc);
                    optRecord.setReqMethodName(reqAction);
                    optRecord.setUserId(userId);
                    optRecord.setReqParams(reqParams);
                    optRecord.setReqUrl(reqUrl);
                    optRecord.setSceneNo(sceneNo);

                    logger.info("操作数据:{}",optRecord.toString());
                    optRecordDAO.save(optRecord);
                    //发送消息
                    optProducerService.sendMessage(optRecord.getId()+"");

                } catch (Exception e) {
                    logger.info(" 保存记录异常,操作环境：{}, 操作数据:{}",env.toString(),optRecord.toString(),e);
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public PageInfo<OptRecordAndEnvVO> findOptRecordAndEnvListPage(Integer pageNo, Integer pageSize, String userId, String sysCode, String channelCode,String channelName, String terminalName, String sessionId, String reqUrl, String sceneNo) {
        List<OptRecordAndEnvVO> list = optRecordAndEnvDAO.findOptRecordListPage(pageNo,pageSize,userId,sysCode,channelCode,channelName,terminalName,sessionId,reqUrl,sceneNo);
        return new PageInfo<>(list);
    }

    @Override
    public OptRecordAndEnvVO getOptDetail(Integer optId) {
        return optRecordAndEnvDAO.getOptDetail(optId);
    }
}
