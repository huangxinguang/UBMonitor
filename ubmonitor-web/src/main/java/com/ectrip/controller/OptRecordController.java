package com.ectrip.controller;

import com.ectrip.dao.OptRecordAndEnvDAO;
import com.ectrip.model.OptRecord;
import com.ectrip.service.OptManageService;
import com.ectrip.utils.NetUtil;
import com.ectrip.utils.Page;
import com.ectrip.vo.OptRecordAndEnvVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @ApiOperation(value = "插入操作记录",notes = "")
    @ApiImplicitParam(name = "optRecord", value = "用户记录", required = true, dataType = "OptRecord")
    @RequestMapping(value = "/doOperate",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView doOperate(HttpServletRequest request, OptRecord optRecord) {
        ModelAndView mav = getModelAndView();
        optManageService.saveOptAndEnv(request,optRecord);
        return  mav;
    }


    @ApiOperation(value="查询监控记录",notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "userId", value = "用户ID", required = false, dataType = "String"),
            @ApiImplicitParam(name = "sysCode", value = "用户ID", required = false, dataType = "String"),
            @ApiImplicitParam(name = "channelCode", value = "渠道编号", required = false, dataType = "String"),
            @ApiImplicitParam(name = "terminalName", value = "终端名称", required = false, dataType = "String"),
            @ApiImplicitParam(name = "sessionId", value = "回话ID", required = false, dataType = "String"),
            @ApiImplicitParam(name = "reqUrl", value = "请求URL", required = false, dataType = "String"),
            @ApiImplicitParam(name = "sceneNo", value = "场景编号", required = false, dataType = "String")
    })
    @RequestMapping(value = "/findOptList",method = RequestMethod.POST)
    public ModelAndView findOptRecordAndEnvList(Integer currentPage,String userId,String sysCode,String channelCode,String terminalName,String sessionId,String reqUrl,String sceneNo) {
        Page<OptRecordAndEnvVO> optPage = optManageService.findOptRecordAndEnvListPage(currentPage,userId,sysCode,channelCode,terminalName,sessionId,reqUrl,sceneNo);
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
