<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta charset="utf-8" />
    <title>${pd.SYSNAME}</title>
    <meta name="description" content="" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
    <!-- bootstrap & fontawesome -->
    <link rel="stylesheet" href="static/ace/css/bootstrap.min.css" />
    <link rel="stylesheet" href="static/ace/css/font-awesome.css" />
    <!-- page specific plugin styles -->
    <!-- text fonts -->
    <link rel="stylesheet" href="static/ace/css/ace-fonts.css" />
    <!-- ace styles -->
    <link rel="stylesheet" href="static/ace/css/ace.css" class="ace-main-stylesheet" id="main-ace-style" />
    <!--[if lte IE 9]>
    <link rel="stylesheet" href="static/ace/css/ace-part2.css" class="ace-main-stylesheet" />
    <![endif]-->
    <!--[if lte IE 9]>
    <link rel="stylesheet" href="static/ace/css/ace-ie.css" />
    <![endif]-->
    <!-- inline styles related to this page -->
    <!-- ace settings handler -->
    <script src="static/ace/js/ace-extra.js"></script>
    <!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->
    <!--[if lte IE 8]>
    <script src="static/ace/js/html5shiv.js"></script>
    <script src="static/ace/js/respond.js"></script>
    <script src="static/js/common/page.js"></script>
    <![endif]-->
    <!--查看图片插件 -->
    <link rel="stylesheet" media="screen" type="text/css" href="plugins/zoomimage/css/zoomimage.css" />
    <link rel="stylesheet" media="screen" type="text/css" href="plugins/zoomimage/css/custom.css" />
    <script type="text/javascript" src="plugins/zoomimage/js/jquery.js"></script>
    <script type="text/javascript" src="plugins/zoomimage/js/eye.js"></script>
    <script type="text/javascript" src="plugins/zoomimage/js/utils.js"></script>
    <script type="text/javascript" src="plugins/zoomimage/js/zoomimage.js"></script>
    <script type="text/javascript" src="plugins/zoomimage/js/layout.js"></script>
    <!--查看图片插件 -->
</head>
<body class="no-skin">

    <!-- /section:basics/sidebar -->
    <form action="/optManage/findOptList" name="optForm" id="optForm" method="post">

    <div class="main-content">
        <div class="main-content-inner">
                <table style="margin-top:5px;">
                    <tr>
                        <td>
                            <div class="nav-search">
                                <span class="input-icon">
                                    <input class="nav-search-input" autocomplete="off" id="nav-search-input" type="text" name="userId" value="${userId }" placeholder="这里输入用户编号" />
                                    <i class="ace-icon fa fa-search nav-search-icon"></i>
                                </span>
                            </div>
                        </td>
                        <td>
                            <div class="nav-search">
                                <span class="input-icon">
                                    <input class="nav-search-input" autocomplete="off" id="nav-search-input1" type="text" name="sysCode" value="${sysCode }" placeholder="这里输入系统编号" />
                                    <i class="ace-icon fa fa-search nav-search-icon"></i>
                                </span>
                            </div>
                        </td>
                        <td>
                            <div class="nav-search">
                                <span class="input-icon">
                                    <input class="nav-search-input" autocomplete="off" id="nav-search-input2" type="text" name="channelCode" value="${channelCode }" placeholder="这里输入渠道编号" />
                                    <i class="ace-icon fa fa-search nav-search-icon"></i>
                                </span>
                            </div>
                        </td>
                        <td>
                            <div class="nav-search">
                                <span class="input-icon">
                                    <input class="nav-search-input" autoco  mplete="off" id="nav-search-input3" type="text" name="terminalName" value="${terminalName }" placeholder="这里输入终端" />
                                    <i class="ace-icon fa fa-search nav-search-icon"></i>
                                </span>
                            </div>
                        </td>
                        <td>
                            <div class="nav-search">
                                <span class="input-icon">
                                    <input class="nav-search-input" autocomplete="off" id="nav-search-input4" type="text" name="sessionId" value="${sessionId }" placeholder="这里输入sessionID" />
                                    <i class="ace-icon fa fa-search nav-search-icon"></i>
                                </span>
                            </div>
                        </td>
                        <td>
                            <div class="nav-search">
                                <span class="input-icon">
                                    <input class="nav-search-input" autocomplete="off" id="nav-search-input5" type="text" name="reqUrl" value="${reqUrl }" placeholder="这里输入请求路径" />
                                    <i class="ace-icon fa fa-search nav-search-icon"></i>
                                </span>
                            </div>
                        </td>
                        <td>
                            <div class="nav-search">
                                <span class="input-icon">
                                    <input class="nav-search-input" autocomplete="off" id="nav-search-input6" type="text" name="sceneNo" value="${sceneNo }" placeholder="这里输入场景号" />
                                    <i class="ace-icon fa fa-search nav-search-icon"></i>
                                </span>
                            </div>
                        </td>

                        <td style="vertical-align:top;padding-left:2px;"><a class="btn btn-light btn-xs" onclick="searchs();"  title="查询"><i id="nav-search-icon" class="ace-icon fa fa-search bigger-110 nav-search-icon blue"></i></a></td>
                    </tr>

                    <%-- 隐藏的回车触发提交 --%>
                    <input name="tj" type="submit" style="display: none"/>

                </table>
                <!-- 检索  -->
                <table id="simple-table" class="table table-striped table-bordered table-hover"  style="margin-top:0px;">
                    <thead>
                    <tr>
                        <th class="center" style="width:50px;">编号</th>
                        <th class="center" style="width:50px;">用户名</th>
                        <th class="center" >系统编号</th>
                        <th class="center" >渠道名称</th>
                        <th class="center" >终端</th>
                        <th class="center" >会话ID</th>
                        <th class="center" >请求路径</th>
                        <th class="center" >动作名称</th>
                        <th class="center">场景号</th>
                        <th class="center">请求描述</th>
                        <th class='center'>请求时间</th>
                        <th class='center'>用户IP</th>
                        <th class='center'>操作用户</th>
                        <th class='center'>运营商</th>
                        <th class='center'>电脑名称</th>
                        <th class='center'>操作系统</th>
                        <th class='center'>操作系统版本</th>
                        <th class='center'>浏览器</th>
                        <th class='center'>浏览器版本</th>
                        <th class='center'>设备ID</th>
                    </tr>
                    </thead>
                    <tbody>
                    <!-- 开始循环 -->
                    <c:choose>
                        <c:when test="${not empty optPage}">
                            <c:forEach items="${optPage.dataList}" var="optRecord" varStatus="vs">
                                <tr>
                                    <td class='center'>${optRecord.id}</td>
                                    <td class='center'>${optRecord.userId }</td>
                                    <td class='center'>
                                        <c:if test="${optRecord.sysCode == '0' }">
                                            畅游通
                                        </c:if>
                                        <c:if test="${optRecord.sysCode != '0' }">
                                            PMS
                                        </c:if>
                                    </td>
                                    <td class='center'>${optRecord.channelName }</td>
                                    <td class='center'>${optRecord.terminalName }</td>
                                    <td class='center'>${optRecord.sessionId }</td>
                                    <td class='center'>${optRecord.reqUrl }</td>
                                    <td class='center'>${optRecord.reqMethodName }</td>
                                    <td class='center'>${optRecord.sceneNo }</td>
                                    <td class='center'>${optRecord.optBrief }</td>
                                    <td class='center'>${optRecord.optTime }</td>
                                    <td class='center'>${optRecord.ip }</td>
                                    <td class='center'>${optRecord.operators }</td>
                                    <td class='center'>${optRecord.manufacturer }</td>
                                    <td class='center'>${optRecord.computerName }</td>
                                    <td class='center'>${optRecord.os }</td>
                                    <td class='center'>${optRecord.osVersion }</td>
                                    <td class='center'>${optRecord.browser }</td>
                                    <td class='center'>${optRecord.browserVersion }</td>
                                    <td class='center'>${optRecord.deviceId }</td>
                                </tr>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <tr>
                                <td colspan="100" class='center'>没有相关数据</td>
                            </tr>
                        </c:otherwise>
                    </c:choose>
                    </tbody>
                </table>
                <div class="page-header position-relative">
                    <table style="width:100%;">
                        <tr>
                            <td style="vertical-align:top;"><div class="pagination" style="float: right;padding-top: 0px;margin-top: 0px;">${optPage.pageStr}</div></td>
                        </tr>
                    </table>
                </div>
            <!-- /.page-content -->
        </div>
    </div>
    </form>
    <!-- /.main-content -->
    <!-- 返回顶部 -->
    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
        <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
    </a>
</div>
<!-- /.main-container -->
<!-- basic scripts -->
<!-- 页面底部js¨ -->
<%@ include file="index/foot.jsp"%>
<!-- ace scripts -->
<script src="static/ace/js/ace/ace.js"></script>
<script type="text/javascript" src="static/js/common/common.js"></script>
<script type="text/javascript" src="static/js/common/page.js"></script>
<script type="text/javascript" src="static/js/common/index.js"></script>
<script type="text/javascript" src="static/js/common/head.js"></script>
</body>
<script type="text/javascript">
    $(top.hangge());
    //检索
    function searchs(){
        top.jzts();
        $("#optForm").submit();
    }
</script>
<style type="text/css">
    li {list-style-type:none;}
</style>
<ul class="navigationTabs">
    <li><a></a></li>
    <li></li>
</ul>
</html>

