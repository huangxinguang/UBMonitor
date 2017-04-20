package com.ectrip;

import nl.bitwalker.useragentutils.UserAgent;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by huangxinguang on 2017/4/20 下午3:58.
 * </p>
 * Desc:
 */
public class UserAgentUtilsTest {

    @Test
    public void testMobile() {

        String userAgent = "Huawei U8800    Android 2.3.3   Baidu 2.3   Mozilla/5.0 (Linux; U; Android 2.3.5; zh-cn; U8800 Build/HuaweiU8800) AppleWebKit/530.17 (KHTML, like Gecko)";
        UserAgent userAgentInfo = UserAgent.parseUserAgentString(userAgent);

    }

    @Test
    public void testMobileType() {
        Pattern pattern = Pattern.compile(";\\s?(\\S*?\\s?\\S*?)\\s?(Build)?/");
        //String userAgent = "Huawei U8800    Android 2.3.3   UC 8.7  Mozilla/5.0 (Linux; U; Android 2.3.5; zh-cn; U8800 Build/HuaweiU8800) UC AppleWebKit/534.31 (KHTML, like Gecko) Mobile Safari/534.31";
        String userAgent = "Mozilla/5.0 (Linux; U; Android 4.3; zh-cn; R8007 Build/JLS36C) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
        Matcher matcher = pattern.matcher(userAgent);
        String model = null;
        if (matcher.find()) {
            model = matcher.group(1).trim();
            //log.debug("通过userAgent解析出机型：" + model);
        }
    }
}
