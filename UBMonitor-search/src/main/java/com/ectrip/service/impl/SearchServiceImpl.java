package com.ectrip.service.impl;

import com.ectrip.service.SearchService;
import com.ectrip.vo.OptRecordAndEnvVO;
import com.github.pagehelper.PageInfo;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by huangxinguang on 2017/4/28 下午3:00.
 */
@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private HttpSolrServer httpSolrServer;

    public PageInfo<OptRecordAndEnvVO> searchOptRecordList(Integer offset, Integer limit, String userId, String sysCode, String channelCode, String channelName, String terminalName, String sessionId, String reqUrl, String sceneNo) {
        String queryString = "sysCode:"+sysCode;

        //创建查询条件
        SolrQuery query = new SolrQuery();

        //设置查询条件
        query.setQuery(queryString);

        //设置分页
        query.setStart(offset);

        query.setRows(limit);

        QueryResponse response = null;

        try {

            response = httpSolrServer.query(query);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
