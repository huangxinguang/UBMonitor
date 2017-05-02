package com.ectrip;

import com.ectrip.service.OptManageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by huangxinguang on 2017/5/2 上午11:30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:/spring/ApplicationContext*.xml","classpath:mybatis-config.xml"})
public class SaveRecordTest {
    @Autowired
    private OptManageService optManageService;

    @Test
    public void testSave() {
        optManageService.saveOptAndEnv(null,"admin",
                "192.168.1.23",
                "E417B49056D7BEF58C31941F6C82F967",
                "Huawei U8800    Android 2.3.3   Baidu 2.3   Mozilla/5.0 (Linux; U; Android 2.3.5; zh-cn; U8800 Build/HuaweiU8800) AppleWebKit/530.17 (KHTML, like Gecko)",
                "http://192.168.1.23/doLogin.action",
                "登陆",
                "username=test&password=12345678",
                null,
                "test",
                "pms",
                "502",
                "用户登陆",
                "用户登陆");
    }
}
