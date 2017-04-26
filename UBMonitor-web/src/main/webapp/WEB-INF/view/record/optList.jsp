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
    var params[] = {

    };
    $(function() {
        // bootstrap table初始化
        $table.bootstrapTable({
            method:"get",
            url: '${basePath}/optManage/findOptRecordList', //请求后台的URL（*）
            datalocale:"zh-US",                                //表格汉化
            striped: true,                                      //是否显示行间隔色
            search: false,                                      //是否启用搜索
            showRefresh: true,                                 //是否显示刷新
            showColumns: true,                                 //显示下拉框勾选要显示的列
            minimumCountColumns: 2,                           //最少允许的列数
            clickToSelect: true,                              //是否启用点击选中行
            detailView: true,                                  //是否显示父子表
            detailFormatter: 'detailFormatter',
            pagination: true,                                  //是否显示分页
            paginationLoop: false,
            queryParams:"",                                    //条件参数
            sidePagination: 'server',
            silentSort: false,
            smartDisplay: false,
            escape: true,
            searchOnEnterKey: true,
            idField: 'id',
            sortName: 'channelName',
            sortOrder: 'desc',
            maintainSelected: true,
            toolbar: '#toolbar',
            columns: [
                {field: 'id', checkbox: true},
                {field: 'sysCode', title: '系统编号', sortable: true, align: 'center'},
                {field: 'channelName', title: '渠道编号'},
                {field: 'sessionId', title: '会话ID'},
                {field: 'reqParams', title: '请求参数'},
                {field: 'reqUrl', title: '请求路径'},
                {field: 'userId', title: '用户编号'},
                {field: 'sceneNo', title: '场景号'},
                {field: 'reqMethodName', title: '动作名称'},
                {field: 'optBrief', title: '操作描述'},
                {field: 'optTime', title: '操作时间'},
                {field: 'optDescription', title: '操作详情'},
                {field: 'ip', title: '用户IP'},
                {field: 'clientIp', title: '登录IP'}
            ]
        });
    });
</script>