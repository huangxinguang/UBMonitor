package com.ectrip.controller;

import com.ectrip.common.BaseResult;
import com.ectrip.common.SearchResult;
import com.ectrip.service.OptManageService;
import com.ectrip.service.SearchService;
import com.ectrip.vo.OptRecordAndEnvVO;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

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

    @Autowired
    private SearchService searchService;

    @ApiOperation(value = "插入操作记录",notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "remoteUser", value = "系统用户", required = true, dataType = "String"),
            @ApiImplicitParam(name = "remoteIp", value = "IP", required = true, dataType = "String"),
            @ApiImplicitParam(name = "sessionId", value = "会话ID", required = true,dataType = "String"),
            @ApiImplicitParam(name = "userAgent", value = "userAgent",required = true, dataType = "String"),
            @ApiImplicitParam(name = "reqUrl", value = "请求URL", required = true, dataType = "String"),
            @ApiImplicitParam(name = "reqAction", value = "请求动作名称",  required = true,dataType = "String"),
            @ApiImplicitParam(name = "reqParams", value = "请求参数",  dataType = "String"),
            @ApiImplicitParam(name = "sceneNo", value = "场景编号", dataType = "String"),
            @ApiImplicitParam(name = "userId", value = "登陆用户", dataType = "String"),
            @ApiImplicitParam(name = "sysCode", value = "系统编号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "channelCode", value = "渠道编号",  dataType = "String"),
            @ApiImplicitParam(name = "optBrief", value = "操作简介", required = true, dataType = "String"),
            @ApiImplicitParam(name = "optDesc", value = "操作详情", required = true, dataType = "String")
    })
    @ResponseBody
    @RequestMapping(value = "/doOperate",method = RequestMethod.GET)
    public Object doOperate(HttpServletRequest request,String remoteUser,String remoteIp,String sessionId,String userAgent, String reqUrl,
                                        String reqAction,String reqParams,String sceneNo,String userId,String sysCode,String channelCode,String optBrief,String optDesc) {
        try {
            optManageService.saveOptAndEnv(request, remoteUser, remoteIp, sessionId, userAgent, reqUrl, reqAction, reqParams, sceneNo, userId, sysCode, channelCode, optBrief, optDesc);
            return new BaseResult().ok();
        }catch (Exception e) {
            e.printStackTrace();
        }

        return  new BaseResult().notOk();
    }


    @ApiOperation(value="监控记录页面",notes = "跳转到操作监控记录页面")
    @RequestMapping(value = "/optRecordPage",method = RequestMethod.GET)
    public ModelAndView optRecordPage() {
        ModelAndView mav = getModelAndView();
        mav.setViewName("record/optList");
        return mav;
    }

/*    @ApiOperation(value="查询监控记录JSon",notes = "返回查询结果的json的分页结果")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "offset", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "limit", value = "页面大小", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "userId", value = "用户ID", dataType = "String"),
            @ApiImplicitParam(name = "sysCode", value = "系统ID",  dataType = "String"),
            @ApiImplicitParam(name = "channelCode", value = "渠道编号",dataType = "String"),
            @ApiImplicitParam(name = "terminalName", value = "终端名称",  dataType = "String"),
            @ApiImplicitParam(name = "sessionId", value = "回话ID", dataType = "String"),
            @ApiImplicitParam(name = "reqUrl", value = "请求URL",  dataType = "String"),
            @ApiImplicitParam(name = "sceneNo", value = "场景编号",  dataType = "String")
    })
    @ResponseBody
    @RequestMapping(value = "/findOptRecordList",method = RequestMethod.GET)
    public Object findOptRecordList(Integer offset,Integer limit,String userId,String sysCode,String channelCode,String channelName,String terminalName,String sessionId,String reqUrl,String sceneNo) {
        int pageNo = 1;
        if(offset != null) {
            pageNo = (offset/limit +1);
        }

        PageInfo<OptRecordAndEnvVO> pageInfo = optManageService.findOptRecordAndEnvListPage(pageNo,limit,userId,sysCode,channelCode,channelName,terminalName,sessionId,reqUrl,sceneNo);
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("rows",pageInfo.getList());
        resultMap.put("total",pageInfo.getTotal());
        return resultMap;
    }*/

    @ApiOperation(value="查询监控记录JSon",notes = "返回查询结果的json的分页结果")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "offset", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "limit", value = "页面大小", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "userId", value = "用户ID", dataType = "String"),
            @ApiImplicitParam(name = "sysCode", value = "系统ID",  dataType = "String"),
            @ApiImplicitParam(name = "channelCode", value = "渠道编号",dataType = "String"),
            @ApiImplicitParam(name = "terminalName", value = "终端名称",  dataType = "String"),
            @ApiImplicitParam(name = "sessionId", value = "回话ID", dataType = "String"),
            @ApiImplicitParam(name = "reqUrl", value = "请求URL",  dataType = "String"),
            @ApiImplicitParam(name = "sceneNo", value = "场景编号",  dataType = "String")
    })
    @ResponseBody
    @RequestMapping(value = "/findOptRecordList",method = RequestMethod.GET)
    public Object findOptRecordList(Integer offset,Integer limit,String userId,String sysCode,String channelCode,String channelName,String terminalName,String sessionId,String reqUrl,String sceneNo) {
        SearchResult searchResult = searchService.searchOptRecordList(offset,limit,userId,sysCode,channelCode,channelName,terminalName,sessionId,reqUrl,sceneNo);
        return searchResult;
    }

}
