package com.ectrip;

import com.ectrip.service.SearchService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by huangxinguang on 2017/4/28 下午3:20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:/spring/ApplicationContext*.xml","classpath:mybatis-config.xml"})
public class SearchTest {

    @Autowired
    private SearchService searchService;

    @Test
    public void testSearchOptList() {
        searchService.searchOptRecordList(0,10,null,"pms",null,null,null,null,null,null);
    }

}
