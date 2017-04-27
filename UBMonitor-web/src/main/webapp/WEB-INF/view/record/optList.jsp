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
<form class="form-inline definewidth m20" action="" method="get">
    系统编号：
    <select name="sysCode" id="sysCode">
       <option>所有</option>
       <option>PMS</option>
       <option>畅游通</option>
    </select>&nbsp;&nbsp;&nbsp;&nbsp;

    渠道名称：
    <select name="channelName" id="channelName">
       <option>所有</option>
       <option>九寨沟</option>
       <option>都江堰</option>
    </select><br><br>

    <%--用户ID：--%>
    <input type="text" name="userId" id="userId"class="abc input-default" placeholder="这里输入用户编号">&nbsp;&nbsp;&nbsp;&nbsp;

    <%--请求路径：--%>
    <input type="text" name="reqUrl" id="reqUrl"class="abc input-default" placeholder="这里输入请求路径">&nbsp;&nbsp;&nbsp;&nbsp;

    <%--会话ID：--%>
    <input type="text" name="sessionId" id="sessionId"class="abc input-default" placeholder="这里输入会话ID">&nbsp;&nbsp;&nbsp;&nbsp;

    <button type="button" onclick="reloadTable()" class="btn btn-primary">查询</button>
</form>
<table id="table"></table>
</body>
</html>
<script>
        var oTableInit = new Object();
        var $table = $('#table');
        oTableInit.Init = $(function() {
            // bootstrap table初始化
            $table.bootstrapTable({
                method:"get",
                url: '${basePath}/optManage/findOptRecordList',
                //data:'${basePath}/data.json',
                queryParams:oTableInit.queryParams,
                striped: true,
                search: false,
                cache:false,
                dataType:'json',
                showRefresh: true,
                showColumns: true,
                showToggle:true,
                showPaginationSwitch:true,
                minimumCountColumns: 2,
                clickToSelect: true,
                detailView: true,
                detailFormatter: function(index, row, element) {
                    var html = '';
                    $.each(row, function(key, val){
                        html += "<p>" + key + ":" + val +  "</p>"
                    });
                    return html;
                },
                pagination: true,
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
                    {field: 'id', title:'编号',align:'center'},
                    {field: 'sysCode', title: '系统编号',align:'center'},
                    {field: 'channelCode', title: '渠道编号',visible: false,align:'center'},
                    {field: 'channelName', title: '渠道名称',align:'center'},
                    {field: 'terminalName', title: '终端',align:'center'},
                    {field: 'sessionId', title: '会话id',align:'center'},
                    {field: 'reqParams', title: '请求参数',align:'center'},
                    {field: 'reqUrl', title: '请求URL',align:'center'},
                    {field: 'userId', title: '用户编号',align:'center'},
                    {field: 'sceneNo', title: '场景号',visible: false,align:'center'},
                    {field: 'reqMethodName', title: '请求动作',align:'center'},
                    {field: 'optBrief', title: '操作简介',align:'center'},
                    {field: 'optTime', title: '操作时间',align:'center'},
                    {field: 'optDescription', title: '操作描述',visible: false,align:'center'},
                    {field: 'ip', title: 'IP',align:'center'},
                    {field: 'clientIp', title: 'clientIP',visible: false,align:'center'},
                    {field: 'mac', title: '物理地址',visible: false,align:'center'},
                    {field: 'imei', title: 'imei',visible: false,align:'center'},
                    {field: 'operators', title: '操作用户',visible: false,align:'center'},
                    {field: 'manufacturer', title: '提供商',visible: false,align:'center'},
                    {field: 'phoneModel', title: '手机类型',align:'center'},
                    {field: 'computerName', title: '电脑名称',align:'center'},
                    {field: 'os', title: '操作系统',align:'center'},
                    {field: 'osVersion', title: '操作系统版本',align:'center'},
                    {field: 'resolution', title: '布局',visible: false,align:'center'},
                    {field: 'font', title: '字体',visible: false,align:'center'},
                    {field: 'fontSize', title: '字体大小',visible: false,align:'center'},
                    {field: 'browser', title: '浏览器',align:'center'},
                    {field: 'browserVersion', title: '浏览器版本',align:'center'},
                    {field: 'appName', title: 'app名称',visible: false,align:'center'},
                    {field: 'appType', title: 'app类型',visible: false,align:'center'},
                    {field: 'appVersion', title: 'app版本',visible: false,align:'center'},
                    {field: 'longitude', title: '经度',visible: false,align:'center'},
                    {field: 'latitude', title: '纬度',visible: false,align:'center'},
                    {field: 'internetType', title: '网络类型',visible: false,align:'center'},
                    {field: 'isEmulator', title: '是否支持虚拟机',visible: false,align:'center'},
                    {field: 'deviceId', title: '设备编号',visible: false,align:'center'}
                ]
            });
        });
        oTableInit.queryParams = function (params) {
            var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                limit: params.limit,   //页面大小
                offset: params.offset,  //页码
                sysCode: $("#sysCode").val(),
                channelName: $("#channelName").val(),
                //terminalName: $("#terminalName").val(),
                //sceneNo: $("#sceneNo").val(),
                userId: $("#userId").val(),
                sessionId: $("#sessionId").val(),
                reqUrl: $("#reqUrl").val()
            };
            return temp;
        };

        function reloadTable() {
            $table.bootstrapTable('refresh');
        }

</script>
