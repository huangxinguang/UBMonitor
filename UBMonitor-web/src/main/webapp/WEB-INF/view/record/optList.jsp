<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${basePath}/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="${basePath}/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="${basePath}/Css/style.css" />
    <link rel="stylesheet" type="text/css" href="${basePath}/Css/bootstrap-table.min.css" />
    <script type="text/javascript" src="${basePath}/Js/jquery.js"></script>
    <script type="text/javascript" src="${basePath}/Js/bootstrap.js"></script>
    <script type="text/javascript" src="${basePath}/Js/ckform.js"></script>
    <script type="text/javascript" src="${basePath}/Js/bootstrap-table.min.js"></script>
    <script type="text/javascript" src="${basePath}/Js/bootstrap-table-zh-CN.min.js"></script>
    <script type="text/javascript" src="${basePath}/Js/common.js"></script>
    <script type="text/javascript" src="${basePath}/Js/common.js"></script>


    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }


    </style>
</head>
<body>
<form class="form-inline definewidth m20" action="index.html" method="get">
    用户名称：
    <input type="text" name="username" id="username"class="abc input-default" placeholder="" value="">&nbsp;&nbsp;
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp; <button type="button" class="btn btn-success" id="addnew">新增用户</button>
</form>
<table id="table"></table>
</body>
</html>
<script>
    var $table = $('#table');
    $(function() {
        // bootstrap table初始化
        $table.bootstrapTable({
            method:"get",
            url: '${basePath}/optManage/findOptRecordList', //请求后台的URL（*）
            //data:'${basePath}/data.json',
            striped: true, //是否显示行间隔色
            search: false,//是否启用搜索
            cache:false,
            dataType:'json',
            showRefresh: true,//是否显示刷新
            showColumns: true,//显示下拉框勾选要显示的列
            showToggle:true,
            showPaginationSwitch:true,
            minimumCountColumns: 2,//最少允许的列数
            clickToSelect: true,
            detailView: true,//是否显示父子表
        /*    detailFormatter: 'detailFormatter',*/
            pagination: true,//是否显示分页
            pageNumber:1,
            pageSize:10,
            paginationLoop: false,
            pageList: [10, 25, 50, 100],
            sidePagination: 'server',
            silentSort: false,
            smartDisplay: false,
            escape: true,
            idField: 'id',
        /*    sortName: 'channelName',
            sortOrder: 'desc',*/
            maintainSelected: true,
            toolbar: '#toolbar',
            columns: [
                {field: 'id', title:'编号'},
                {field: 'sysCode', title: '系统编号'},
                {field: 'channelCode', title: '渠道编号'},
                {field: 'channelName', title: '渠道编号'},
                {field: 'terminalName', title: '渠道编号'},
                {field: 'sessionId', title: '回话id'},
                {field: 'reqParams', title: '终端'},
                {field: 'reqUrl', title: '请求URL'},
                {field: 'userId', title: '用户编号'},
                {field: 'sceneNo', title: '场景号'},
                {field: 'reqMethodName', title: '请求动作'},
                {field: 'optBrief', title: '操作简介'},
                {field: 'optTime', title: '操作时间'},
                {field: 'optDescription', title: '操作描述'},
                {field: 'ip', title: 'IP'},
                {field: 'clientIp', title: 'clientIP'},
                {field: 'mac', title: '物理地址'},
                {field: 'imei', title: 'imei'},
                {field: 'operators', title: '操作用户'},
                {field: 'manufacturer', title: '提供商'},
                {field: 'phoneModel', title: '手机类型'},
                {field: 'computerName', title: '电脑名称'},
                {field: 'os', title: '操作系统'},
                {field: 'osVersion', title: '操作系统版本'},
                {field: 'resolution', title: '布局'},
                {field: 'font', title: '字体'},
                {field: 'fontSize', title: '字体大小'},
                {field: 'browser', title: '浏览器'},
                {field: 'browserVersion', title: '浏览器版本'},
                {field: 'appName', title: 'app名称'},
                {field: 'appType', title: 'app类型'},
                {field: 'appVersion', title: 'app版本'},
                {field: 'longitude', title: '经度'},
                {field: 'latitude', title: '纬度'},
                {field: 'internetType', title: '网络类型'},
                {field: 'isEmulator', title: '是否支持虚拟机'},
                {field: 'deviceId', title: '设备编号'}
            ]
        });
    });
</script>