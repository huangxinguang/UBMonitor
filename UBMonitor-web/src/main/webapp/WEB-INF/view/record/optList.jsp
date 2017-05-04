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
    <div class="form-group">
        <label for="sysCode">系统编号：</label>
        <select name="sysCode" id="sysCode" class="form-control">
           <option value="">所有</option>
           <option value="pms">PMS</option>
           <option value="cyt">畅游通</option>
        </select>&nbsp;&nbsp;&nbsp;&nbsp;

        <label for="channelCode">渠道名称：</label>
        <select name="channelCode" id="channelCode" class="form-control">
           <option value="">所有</option>
           <option value="602">九网</option>
           <option value="502">青都</option>
        </select><br><br>

        <%--用户ID：--%>
        <input type="text" name="userId" id="userId"class="abc input-default" placeholder="这里输入用户编号">&nbsp;&nbsp;&nbsp;&nbsp;

        <%--请求路径：--%>
        <input type="text" name="reqUrl" id="reqUrl"class="abc input-default" placeholder="这里输入请求路径">&nbsp;&nbsp;&nbsp;&nbsp;

        <%--会话ID：--%>
        <input type="text" name="sessionId" id="sessionId"class="abc input-default" placeholder="这里输入会话ID">&nbsp;&nbsp;&nbsp;&nbsp;

        <button type="button" onclick="reloadTable()" class="btn btn-primary">查询</button>
    </div>
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
                showPaginationSwitch:false,
                minimumCountColumns: 2,
                clickToSelect: true,
                detailView: true,
               // detailFormatter:'detailFormatter',
               detailFormatter: dataformatobj,
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
                    {field: 'ip', title: 'IP',align:'center',visible: false},
                    {field: 'clientIp', title: 'clientIP',align:'center'},
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
                channelCode: $("#channelCode").val(),
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


        var dataformatobj = function(index, row) {
            var html = '';
            $.each(row, function(key, val){
                var name = null;
                switch(key) {
                    case "id":
                        name="编号";break;
                    case "sysCode":
                        name="系统编号";break;
                    case "channelCode":
                        name="渠道编号";break;
                    case "channelName":
                        name="渠道名称";break;
                    case "terminalName":
                        name="终端名称";break;
                    case "sessionId":
                        name="回话id";break;
                    case "reqParams":
                        name="请求参数";break;
                    case "reqUrl":
                        name="请求路径";break;
                    case "userId":
                        name="用户编号";break;
                    case "sceneNo":
                        name="场景编号";break;
                    case "reqMethodName":
                        name="请求动作";break;
                    case "optBrief":
                        name="操作简介";
                    case "optTime":
                        name="操作时间";break;
                    case "id":
                        name="编号";break;
                    case "optDescription":
                        name="操作描述";break;
                    case "ip":
                        name="IP地址";break;
                    case "mac":
                        name="物理地址";break;
                    case "clientIp":
                        name="请求ip";break;
                    case "imei":
                        name="imei";break;
                    case "operators":
                        name="系统用户";break;
                    case "manufacturer":
                        name="提供商";break;
                    case "phoneModel":
                        name="手机类型";break;
                    case "computerName":
                        name="电脑名称";break;
                    case "os":
                        name="操作系统";break;
                    case "osVersion":
                        name="操作系统版本";break;
                    case "resolution":
                        name="布局";break;
                    case "font":
                        name="字体";break;
                    case "fontSize":
                        name="字体大小";break;
                    case "browser":
                        name="浏览器";break;
                    case "browserVersion":
                        name="浏览器版本";break;
                    case "appName":
                        name="app名称";break;
                    case "appVersion":
                        name="app版本";break;
                    case "longitude":
                        name="经度";break;
                    case "latitude":
                        name="纬度";break;
                    case "internetType":
                        name="网络类型";break;
                    case "isEmulator":
                        name="是否是虚拟机";break;
                    case "deviceId":
                        name="设备ID";break;
                }

                html += "<span class='text-info'>" + name + ":" + val +"</span> "
                html += "<br>";
            });
            return html;
        }

</script>
