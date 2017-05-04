package com.ectrip.service.impl;

import com.ectrip.common.SearchResult;
import com.ectrip.service.SearchService;
import com.ectrip.vo.OptRecordAndEnvVO;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.ModifiableSolrParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangxinguang on 2017/4/28 下午3:00.
 */
@Service
public class SearchServiceImpl implements SearchService {

    private Logger logger = LoggerFactory.getLogger(SearchServiceImpl.class);

    @Autowired
    private HttpSolrServer httpSolrServer;

    public SearchResult searchOptRecordList(Integer offset, Integer limit, String userId, String sysCode, String channelCode, String channelName, String terminalName, String sessionId, String reqUrl, String sceneNo) {
        //组装查询条件
        ModifiableSolrParams solrParams = new ModifiableSolrParams();
        //默认查询所有
        solrParams.add("q", "*:*");

        //设置查询开始和结束
        solrParams.add("start", offset.toString());
        solrParams.add("rows", limit.toString());

        if(!StringUtils.isEmpty(sysCode)) {
            solrParams.add("fq", "sysCode:"+sysCode);
        }
        if(!StringUtils.isEmpty(userId)) {
           solrParams.add("fq", "userId:*"+userId+"*");
        }
        if(!StringUtils.isEmpty(userId)) {
            solrParams.add("fq", "channelCode:"+channelCode);
        }
        if(!StringUtils.isEmpty(channelName)) {
            solrParams.add("fq", "channelName:*"+channelName+"*");
        }
        if(!StringUtils.isEmpty(terminalName)) {
            solrParams.add("fq", "terminalName:*"+terminalName+"*");
        }
        if(!StringUtils.isEmpty(sessionId)) {
            solrParams.add("fq", "sessionId:*"+sessionId+"*");
        }
        if(!StringUtils.isEmpty(reqUrl)) {
            solrParams.add("fq", "reqUrl:*"+reqUrl+"*");
        }
        if(!StringUtils.isEmpty(sceneNo)) {
            solrParams.add("fq", "sceneNo:*"+sceneNo+"*");
        }

        solrParams.add("sort","optTime desc");


        List<OptRecordAndEnvVO> optRecordAndEnvVOList = new ArrayList<OptRecordAndEnvVO>();
        SearchResult searchResult = new SearchResult();

        try {
            QueryResponse response = httpSolrServer.query(solrParams);
            SolrDocumentList results = response.getResults();

            //组装查询结果
            OptRecordAndEnvVO optRecordAndEnvVO = null;
            for (SolrDocument result : results) {
                optRecordAndEnvVO = new OptRecordAndEnvVO();
                optRecordAndEnvVO.setId(Integer.valueOf(result.getFieldValue("id").toString()));
                optRecordAndEnvVO.setSysCode((String)result.getFieldValue("sysCode"));
                optRecordAndEnvVO.setChannelCode((String)result.getFieldValue("channelCode"));
                optRecordAndEnvVO.setChannelName((String)result.getFieldValue("channelName"));
                optRecordAndEnvVO.setTerminalName((String)result.getFieldValue("terminalName"));
                optRecordAndEnvVO.setSessionId((String)result.getFieldValue("sessionId"));
                optRecordAndEnvVO.setReqParams((String)result.getFieldValue("reqParams"));
                optRecordAndEnvVO.setReqUrl((String)result.getFieldValue("reqUrl"));
                optRecordAndEnvVO.setUserId((String)result.getFieldValue("userId"));
                optRecordAndEnvVO.setSceneNo((String)result.getFieldValue("sceneNo"));
                optRecordAndEnvVO.setReqMethodName((String)result.getFieldValue("reqMethodName"));
                optRecordAndEnvVO.setOptBrief((String)result.getFieldValue("optBrief"));
                optRecordAndEnvVO.setOptTime((String)result.getFieldValue("optTime"));
                optRecordAndEnvVO.setIp((String)result.getFieldValue("ip"));
                optRecordAndEnvVO.setClientIp((String)result.getFieldValue("clientIp"));
                optRecordAndEnvVO.setMac((String)result.getFieldValue("mac"));
                optRecordAndEnvVO.setImei((String)result.getFieldValue("imei"));
                optRecordAndEnvVO.setOperators((String)result.getFieldValue("operators"));
                optRecordAndEnvVO.setManufacturer((String)result.getFieldValue("manufacturer"));
                optRecordAndEnvVO.setPhoneModel((String)result.getFieldValue("phoneModel"));
                optRecordAndEnvVO.setComputerName((String)result.getFieldValue("computerName"));
                optRecordAndEnvVO.setOs((String)result.getFieldValue("os"));
                optRecordAndEnvVO.setOsVersion((String)result.getFieldValue("osVersion"));
                optRecordAndEnvVO.setResolution((String)result.getFieldValue("resolution"));
                optRecordAndEnvVO.setFont((String)result.getFieldValue("font"));
                optRecordAndEnvVO.setFontSize((String)result.getFieldValue("fontSize"));
                optRecordAndEnvVO.setBrowser((String)result.getFieldValue("browser"));
                optRecordAndEnvVO.setBrowserVersion((String)result.getFieldValue("browserVersion"));
                optRecordAndEnvVO.setAppName((String)result.getFieldValue("appName"));
                optRecordAndEnvVO.setAppType((String)result.getFieldValue("appType"));
                optRecordAndEnvVO.setAppVersion((String)result.getFieldValue("appVersion"));
                optRecordAndEnvVO.setLongitude((String)result.getFieldValue("longitude"));
                optRecordAndEnvVO.setLatitude((String)result.getFieldValue("latitude"));
                optRecordAndEnvVO.setInternetType((String)result.getFieldValue("internetType"));
                optRecordAndEnvVO.setIsEmulator((String)result.getFieldValue("isEmulator"));
                optRecordAndEnvVO.setDeviceId((String)result.getFieldValue("deviceId"));
                optRecordAndEnvVOList.add(optRecordAndEnvVO);
            }
            searchResult.setTotal(results.getNumFound());
            searchResult.setRows(optRecordAndEnvVOList);
        }catch (Exception e) {
            logger.info("查询失败");
            e.printStackTrace();
        }
        return searchResult;
    }
}
