package com.ectrip.controller;

import com.ectrip.dao.OptRecordAndEnvDAO;
import com.ectrip.model.OptRecord;
import com.ectrip.service.OptManageService;
import com.ectrip.utils.NetUtil;
import com.ectrip.utils.Page;
import com.ectrip.vo.OptRecordAndEnvVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @RequestMapping(value = "/findOptList")
    public ModelAndView findOptRecordAndEnvList(Integer pageNo,String userId,String sysCode,String channelCode,String terminalName,String sessionId,String reqUrl,String sceneNo) {
        Page<OptRecordAndEnvVO> optPage = optManageService.findOptRecordAndEnvListPage(pageNo,userId,sysCode,channelCode,terminalName,sessionId,reqUrl,sceneNo);
        ModelAndView mav = getModelAndView();
        mav.addObject("optPage",optPage);
        mav.addObject("userId",userId);
        mav.addObject("sysCode",sysCode);
        mav.addObject("channelCode",channelCode);
        mav.addObject("terminalName",terminalName);
        mav.addObject("sessionId",sessionId);
        mav.addObject("reqUrl",reqUrl);
        mav.addObject("sceneNo",sceneNo);
        mav.setViewName("optList");
        return mav;
    }

}
