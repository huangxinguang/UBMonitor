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
    $(function() {
        // bootstrap table初始化
        $table.bootstrapTable({
            method:"get",
            url: '${basePath}/optManage/findOptRecordList',
            striped: true,
            search: true,
            showRefresh: true,
            showColumns: true,
            minimumCountColumns: 2,
            clickToSelect: true,
            detailView: true,
            detailFormatter: 'detailFormatter',
            pagination: true,
            paginationLoop: false,
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
                {field: 'sessionId', title: '终端'},
                {field: 'reqParams', title: '终端'},
                {field: 'reqUrl', title: '终端'},
                {field: 'userId', title: '终端'},
                {field: 'sceneNo', title: '终端'},
                {field: 'reqMethodName', title: '终端'},
                {field: 'optBrief', title: '终端'},
                {field: 'optTime', title: '终端'},
                {field: 'optDescription', title: '终端'},
                {field: 'ip', title: '终端'},
                {field: 'clientIp', title: '终端'}
            ]
        });
    });
</script>