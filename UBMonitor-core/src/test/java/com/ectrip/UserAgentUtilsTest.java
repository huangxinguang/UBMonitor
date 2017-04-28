package com.ectrip;

import com.ectrip.utils.MyUserAgentUtil;
import com.ectrip.utils.WebUtil;
import eu.bitwalker.useragentutils.UserAgent;
import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by huangxinguang on 2017/4/20 下午3:58.
 * </p>
 * Desc:
 */
public class UserAgentUtilsTest {

    /**
     * 测试解析userAgent
     */
    @Test
    public void testUserAgentUtils() {
        String userAgent = "Huawei U8800    Android 2.3.3   Baidu 2.3   Mozilla/5.0 (Linux; U; Android 2.3.5; zh-cn; U8800 Build/HuaweiU8800) AppleWebKit/530.17 (KHTML, like Gecko)";
        UserAgent userAgentInfo = UserAgent.parseUserAgentString(userAgent);
        Assert.assertNotNull(userAgentInfo);
    }

    /**
     * 测试获取手机类型
     */
    @Test
    public void testPhone() {
        String userAgent = "Huawei U8800    Android 2.3.3   Baidu 2.3   Mozilla/5.0 (Linux; U; Android 2.3.5; zh-cn; U8800 Build/HuaweiU8800) AppleWebKit/530.17 (KHTML, like Gecko)";
        String phoneType = MyUserAgentUtil.getPhone(userAgent);
        Assert.assertEquals("Android",phoneType);
    }


}
