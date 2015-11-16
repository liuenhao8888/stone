<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link href="resource/css/global.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript">
	$(document).ready(function() {
		$("#reloadVerifyCode").click(function(){
			$("#submitCode").attr("src", "<%=request.getContextPath()%>/getVerifyCodeImage.do?t="+Math.random()); 
		});
	});
</script>
</head>
</head>
<body>
 <center>
 <h3>
会员登录授权
 </h3>
  <FORM METHOD=POST ACTION="login_redirect4shiro.do">
	<table border="1">
		<tr>
			<td>账号</td>
			<td><INPUT TYPE="text" NAME="username" value=""></td>
		</tr>
		<tr>
			<td>密码</td>
			<td><INPUT TYPE="password" NAME="password" value=""></td>
		</tr>
		<tr>
			<td>验证码</td>
			<td>
			<INPUT TYPE="text" NAME="submitCode" value="">
			<img id="submitCode" src="<%=request.getContextPath()%>/getVerifyCodeImage.do"/>
			<a href="javascript:void();" id="reloadVerifyCode">看不清</a>
			</td>
		</tr>
	</table>
	<input type="hidden" name="url" value="${url}"/>
	<input type="hidden" name="type" value="1"/>
 <br>
 <p><INPUT TYPE="submit" value="登录"><font color="red">${msg}</font><a href="register.jsp">注册</a></p>
  </FORM>
 </center>
 </body>
 
 