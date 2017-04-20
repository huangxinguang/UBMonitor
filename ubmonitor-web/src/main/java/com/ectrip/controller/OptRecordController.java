package com.ectrip.controller;

import com.ectrip.model.OptRecord;
import com.ectrip.service.OptManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by huangxinguang on 2017/4/20 上午10:08.
 * </p>
 * Desc:
 */
@Controller
@RequestMapping("/optManage")
public class OptRecordController extends BaseController {

    @Autowired
    private OptManageService optManageService;

    @RequestMapping(value = "/doOperate")
    public ModelAndView doOperate(@RequestHeader("host") String hostName,
                                  @RequestHeader("User-Agent") String userAgent,
                                  @RequestHeader("Accept") String accept,
                                  @RequestHeader("Accept-Language") String acceptLanguage,
                                  @RequestHeader("Accept-Encoding") String acceptEncoding,
                                  @RequestHeader("Keep-Alive") String keepAlive,
                                  @RequestHeader("Cookie") String cookies,
                                  @CookieValue("JSESSIONID") String sessionId,
                                  OptRecord optRecord
                                  ) {
        ModelAndView mav = getModelAndView();
        optManageService.saveOptAndEnv(hostName,userAgent,accept,acceptLanguage,acceptEncoding,keepAlive,cookies,sessionId,optRecord);
        return  mav;
    }

}
