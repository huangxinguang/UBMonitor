package com.ectrip.utils;

import cz.mallat.uasparser.OnlineUpdater;
import cz.mallat.uasparser.UASparser;
import cz.mallat.uasparser.UserAgentInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by huangxinguang on 2017/4/20 下午2:08.
 * </p>
 * Desc:userAgent解析工具
 */
public class UserAgentUtil {
    private static Logger logger = LoggerFactory.getLogger(UserAgentUtil.class);
    private static UASparser uasParser = null;

    static {
        try {
            if(uasParser == null) {
                uasParser = new UASparser(OnlineUpdater.getVendoredInputStream());
            }
            // 用jdk1.6测试时会报以上错，需要jdk1.7以上版本支持
        } catch (IOException e) {
            logger.info("创建uasParser对象异常！");
            e.printStackTrace();
        }
    }

    public static UserAgentInfo  parse(String userAgentStr){
        UserAgentInfo userAgentInfo = null;
        try {
            userAgentInfo = uasParser.parse(userAgentStr);
        }catch (Exception e) {
            logger.info("解析userAgent异常！");
            e.printStackTrace();
        }
        return userAgentInfo;
    }
}
