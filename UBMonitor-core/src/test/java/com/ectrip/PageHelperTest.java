package com.ectrip;

import com.ectrip.dao.OptRecordAndEnvDAO;
import com.ectrip.vo.OptRecordAndEnvVO;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by huangxinguang on 2017/4/26 下午2:12.
 * desc:测试PageHelper插件
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:/spring/ApplicationContext*.xml","classpath:mybatis-config.xml"})
public class PageHelperTest {
    @Autowired
    private OptRecordAndEnvDAO optRecordAndEnvDAO;

    /**
     * 测试分页 PageHelper
     */
    @Test
    public void testQueryPage() {
        List<OptRecordAndEnvVO> list = optRecordAndEnvDAO.findOptRecordListPage(1,10,null,null,null,null,null,null,null,null);
        PageInfo<OptRecordAndEnvVO> pageInfo = new PageInfo<OptRecordAndEnvVO>(list);
    }
}
