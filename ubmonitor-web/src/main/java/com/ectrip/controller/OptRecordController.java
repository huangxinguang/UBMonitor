package com.ectrip.controller;

import com.ectrip.model.OptRecord;
import com.ectrip.service.OptManageService;
import com.ectrip.utils.NetUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

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
    public ModelAndView doOperate(HttpServletRequest request, OptRecord optRecord) {
        ModelAndView mav = getModelAndView();

        optManageService.saveOptAndEnv(request,optRecord);
        return  mav;
    }

    @RequestMapping(value = "/findOptRecordInfo")
    public String findOptRecordInfo(OptRecord optRecord){
        optManageService.findOptRecordInfo(optRecord);
        return "OptRecordList";
    }

}
