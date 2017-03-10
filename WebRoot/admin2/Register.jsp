<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>注册</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  	<h1>注册信息</h1>
  	<form action="/LXProject/servlet/RegisterServlet">
  	  <table>
    	<tr>
    		<td>帐号</td>	
    		<td><input type="text"  name="userId"><span name="userIdSpan"></span></td>
    	</tr>
    	<tr>
    		<td>密码</td>
    		<td><input type="password"  name="pwd"><span name="pwdSpan"></span></td>
    	</tr>
    	<tr>
    		<td>确认密码</td>
    		<td><input type="password"  name="t-pwd"><span name="t-pwdSpan"></span></td>
    	</tr>
    	<tr>
    		<td>真实姓名</td>
    		<td><input type="name"  name="name"><span name="nameSpan"></span></td>
    	</tr>
    	<tr>
    		<td>年龄</td>
    		<td><input type="text"  name="age"><span name="ageSpan"></span></td>
    	</tr>
    	<tr>
    		<td>邮箱</td>
    		<td><input type="text"  name="email"><span name="emailSpan"></span></td>
    	</tr>
    	<tr>
    		<td>手机号码</td>
    		<td><input type="text"  name="phone"><span name="phoneSpan"></span></td>
    	</tr>
    	<tr>
    		<td>爱好</td>
    		<td><input type="checkbox"  name="hobby" value="sports">运动
    		<td><input type="checkbox"  name="hobby" value="music">音乐
    		<td><input type="checkbox"  name="hobby" value="drawing">美术
    		<td><input type="checkbox"  name="hobby" value="read">阅读
    		<td><input type="checkbox"  name="hobby" value="sleep">谁觉
    		<span name="hobbySpan"></span></td>
    	</tr>
    	<tr>
    		<td colspan="2"><input type="submit"  name="submit"><input type="button"  name="reset"><span name="submitSpan"></span></td>
    	</tr>
    	</table>
  	</form>
  </body>
</html>
