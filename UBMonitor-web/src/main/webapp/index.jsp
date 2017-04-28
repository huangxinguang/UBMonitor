<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE HTML>
<html>
<head>
    <title>用户行为监控系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="assets/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="assets/css/main-min.css" rel="stylesheet" type="text/css" />
</head>
<body>

<%--头部--%>
<div class="header">
    <div class="dl-title">
        <!--<img src="/chinapost/Public/assets/img/top.png">-->
    </div>
    <div class="dl-log">
        欢迎您，<span class="dl-log-user">root</span>
        <a href="/chinapost/index.php?m=Public&a=logout" title="退出系统" class="dl-log-quit">[退出]</a>
    </div>
</div>


<%--主菜单--%>
<div class="content">
    <div class="dl-main-nav">
        <div class="dl-inform"><div class="dl-inform-title"><s class="dl-inform-icon dl-up"></s></div></div>
        <ul id="J_Nav"  class="nav-list ks-clear">
            <li class="nav-item dl-selected"><div class="nav-item-inner nav-home">系统管理</div></li>
            <%--<li class="nav-item dl-selected"><div class="nav-item-inner nav-order">业务管理</div></li>--%>
        </ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten"></ul>
</div>


<script type="text/javascript" src="assets/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="assets/js/bui-min.js"></script>
<script type="text/javascript" src="assets/js/common/main-min.js"></script>
<script type="text/javascript" src="assets/js/config-min.js"></script>

<%--左侧菜单--%>
<script>
    BUI.use('common/main',function(){
        var config = [{id:'1',menu:[{text:'系统管理',
                                        items:[{id:'12',text:'监控记录  ',href:'optManage/optRecordPage'},{id:'11',text:'sql监控  ',href:'druid/index.html'}]
        }]}];
        new PageUtil.MainPage({
            modulesConfig : config
        });
    });
</script>


<%--中间内容展示--%>
<div style="text-align:center;"></div>


</body>
</html>