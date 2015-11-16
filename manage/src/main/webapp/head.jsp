<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<title>stone</title>
<base href="<%=basePath%>">
<link href="resource/css/global.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript"src="resource/js/jquery-1.7.2.min.js"></script>
<div style="width:100%;height:20;text-align: center; padding-top:5;">
<!-- <div style="background-image:url('resource/img/wfbh.png');width:150;height:40;float:left;"></div> -->
<div style="height:40;text-align: center;">
<a href="index.jsp">本系统首页</a>
<a href="/portal/index.jsp">门户首页</a>
<a href="/portal/modules.jsp">各子系统</a>
<a href="/user/login.jsp">登录</a>
<a href="/user/register.jsp">注册</a>
</div>
</div>
<hr/>
