package com.ectrip.mq.listener;

import com.ectrip.service.OptManageService;
import com.ectrip.vo.OptRecordAndEnvVO;
import org.apache.solr.client.solrj.impl.HttpSolrServer;

import org.apache.solr.common.SolrInputDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import javax.jms.*;

/**
 * Created by huangxinguang on 2017/5/3 下午6:22.
 */
public class OptConsumerListener implements MessageListener {

    private Logger logger = LoggerFactory.getLogger(OptConsumerListener.class);

    @Autowired
    private OptManageService optManageService;

    @Autowired
    private HttpSolrServer httpSolrServer;

    @Override
    public void onMessage(Message message) {
        TextMessage tm = (TextMessage) message;
        try {
            logger.info("接受到JMS消息，消息为:" + tm.getText());

            // 休眠1秒 等待事务提交
            Thread.sleep(1000);

            Integer id = Integer.valueOf(tm.getText());
            OptRecordAndEnvVO optRecordAndEnvVO = optManageService.getOptDetail(id);
            SolrInputDocument document = new SolrInputDocument();

            document.addField("id", id);
            document.addField("appName", optRecordAndEnvVO.getAppName());
            document.addField("appType", optRecordAndEnvVO.getAppType());
            document.addField("appVersion", optRecordAndEnvVO.getAppVersion());
            document.addField("sysCode", optRecordAndEnvVO.getSysCode());
            document.addField("channelCode", optRecordAndEnvVO.getChannelCode());
            document.addField("channelName", optRecordAndEnvVO.getChannelName());
            document.addField("terminalName", optRecordAndEnvVO.getTerminalName());
            document.addField("sessionId", optRecordAndEnvVO.getSessionId());
            document.addField("reqParams", optRecordAndEnvVO.getReqParams());
            document.addField("reqUrl", optRecordAndEnvVO.getReqUrl());
            document.addField("userId", optRecordAndEnvVO.getUserId());
            document.addField("sceneNo", optRecordAndEnvVO.getSceneNo());
            document.addField("reqMethodName", optRecordAndEnvVO.getReqMethodName());
            document.addField("optBrief", optRecordAndEnvVO.getOptBrief());
            document.addField("optTime", optRecordAndEnvVO.getOptTime());
            document.addField("optDescription", optRecordAndEnvVO.getOptDescription());
            document.addField("ip", optRecordAndEnvVO.getIp());
            document.addField("clientIp", optRecordAndEnvVO.getClientIp());
            document.addField("mac", optRecordAndEnvVO.getMac());
            document.addField("imei", optRecordAndEnvVO.getImei());
            document.addField("operators", optRecordAndEnvVO.getOperators());
            document.addField("manufacturer", optRecordAndEnvVO.getManufacturer());
            document.addField("phoneModel", optRecordAndEnvVO.getPhoneModel());
            document.addField("computerName", optRecordAndEnvVO.getComputerName());
            document.addField("os", optRecordAndEnvVO.getOs());
            document.addField("osVersion", optRecordAndEnvVO.getOsVersion());
            document.addField("resolution", optRecordAndEnvVO.getResolution());
            document.addField("font", optRecordAndEnvVO.getFont());
            document.addField("fontSize", optRecordAndEnvVO.getFontSize());
            document.addField("browser", optRecordAndEnvVO.getBrowser());
            document.addField("browserVersion", optRecordAndEnvVO.getBrowserVersion());
            document.addField("longitude", optRecordAndEnvVO.getLongitude());
            document.addField("latitude", optRecordAndEnvVO.getLatitude());
            document.addField("internetType", optRecordAndEnvVO.getInternetType());
            document.addField("isEmulator", optRecordAndEnvVO.getIsEmulator());
            document.addField("deviceId", optRecordAndEnvVO.getDeviceId());

            httpSolrServer.add(document);
            httpSolrServer.commit();

            logger.info("添加索引成功记录id:" + id);

        } catch (Exception e) {
            logger.error("添加索引失败", e);
        }
    }
}
