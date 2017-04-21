package com.ectrip;

import com.ectrip.utils.MyUserAgentUtil;
import com.ectrip.utils.NetUtil;
import eu.bitwalker.useragentutils.UserAgent;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by huangxinguang on 2017/4/20 下午3:58.
 * </p>
 * Desc:
 */
public class UserAgentUtilsTest {

    public String getFromRegrex(String str,String pattern,int index){
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(str);
        while(matcher.find())
            str = matcher.group(index);
        return str;
    }
    public String parse(String userAgent){
        String pattern1 = "(.*) AppleWebKit";
        String pattern2 = ".* ";
        String str = getFromRegrex(userAgent,pattern1,1);
        String params[] = str.split(";");
        return getFromRegrex(params[params.length-1],pattern2,0).trim();
    }

    @Test
    public void testMobile() {
        String userAgent = "Huawei U8800    Android 2.3.3   Baidu 2.3   Mozilla/5.0 (Linux; U; Android 2.3.5; zh-cn; U8800 Build/HuaweiU8800) AppleWebKit/530.17 (KHTML, like Gecko)";
        UserAgent userAgentInfo = UserAgent.parseUserAgentString(userAgent);
    }

    @Test
    public void testMobileType() {
        //String userAgent = "Huawei U8800    Android 2.3.3   UC 8.7  Mozilla/5.0 (Linux; U; Android 2.3.5; zh-cn; U8800 Build/HuaweiU8800) UC AppleWebKit/534.31 (KHTML, like Gecko) Mobile Safari/534.31";
        String userAgent = "Mozilla/5.0 (Linux; Android 7.0; FRD-AL00 Build/HUAWEIFRD-AL00) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.132 Mobile Safari/537.36";
       // String userAgent = "Mozilla/5.0 (iPhone; U; CPU like Mac OS X; en) AppleWebKit/420+ (KHTML, like Gecko) Version/3.0 Mobile/1C28 Safari/419.3";
        //String phone = MyUserAgentUtil.getPhone(userAgent);
        String phone = this.parse(userAgent);
    }
}
