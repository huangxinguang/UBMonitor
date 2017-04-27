package com.ectrip.controller;

import com.ectrip.model.OptRecord;
import com.ectrip.service.OptManageService;
import com.ectrip.vo.OptRecordAndEnvVO;
import com.github.pagehelper.Page;
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

    @ApiOperation(value = "插入操作记录",notes = "")
    @ApiImplicitParam(name = "optRecord", value = "用户记录", required = true, dataType = "OptRecord",paramType = "OptRecord")
    @RequestMapping(value = "/doOperate",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView doOperate(HttpServletRequest request, OptRecord optRecord) {
        ModelAndView mav = getModelAndView();
        optManageService.saveOptAndEnv(request,optRecord);
        return  mav;
    }


    @ApiOperation(value="监控记录页面",notes = "跳转到操作监控记录页面")
    @RequestMapping(value = "/findOptList",method = RequestMethod.GET)
    public ModelAndView optRecordPage() {
        ModelAndView mav = getModelAndView();
        mav.setViewName("record/optList");
        return mav;
    }

    @ApiOperation(value="查询监控记录JSon",notes = "返回查询结果的json的分页结果")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "offset", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "limit", value = "页面大小", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "userId", value = "用户ID", required = false, dataType = "String"),
            @ApiImplicitParam(name = "sysCode", value = "系统ID", required = false, dataType = "String"),
            @ApiImplicitParam(name = "channelCode", value = "渠道编号", required = false, dataType = "String"),
            @ApiImplicitParam(name = "terminalName", value = "终端名称", required = false, dataType = "String"),
            @ApiImplicitParam(name = "sessionId", value = "回话ID", required = false, dataType = "String"),
            @ApiImplicitParam(name = "reqUrl", value = "请求URL", required = false, dataType = "String"),
            @ApiImplicitParam(name = "sceneNo", value = "场景编号", required = false, dataType = "String")
    })
    @ResponseBody
    @RequestMapping(value = "/findOptRecordList",method = RequestMethod.GET)
    public Object findOptRecordList(Integer offset,Integer limit,String order,String userId,String sysCode,String channelCode,String channelName,String terminalName,String sessionId,String reqUrl,String sceneNo) {
        int pageNo = 1;
        if(offset != null) {
            pageNo = (offset/limit +1);
        }
        PageInfo<OptRecordAndEnvVO> pageInfo = optManageService.findOptRecordAndEnvListPage(pageNo,limit,userId,sysCode,channelCode,channelName,terminalName,sessionId,sceneNo);
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("rows",pageInfo.getList());
        resultMap.put("total",pageInfo.getTotal());
        return resultMap;
    }

}
