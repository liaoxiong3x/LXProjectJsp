<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登入界面</title>
<script type="text/javascript">
	function bt(){
		var string = "";
	}
</script>

</head>
<body>
	
	<h3>用户登入</h3>
	<%
	String username = "";
	String pwd = "";
	String check = "";
	Cookie[] cookies = request.getCookies();
	if(cookies!=null){
	for(int i=0;i<cookies.length;i++ ){
	Cookie cookie = cookies[i];
		if("username".equals(cookie.getName())){
				username = URLDecoder.decode(cookie.getValue(), "utf-8");
// 				username=cookie.getValue();
				check="checked";
			}
		if("pwd".equals(cookie.getName())){
				pwd=cookie.getValue();
			}
		}
	}
	 %>
	
	<form action="/LXProject/servlet/LoginServlet" >
	用户名:<input type="text" name="username" id="username" value="<%=username %>"/>
	<br/>
	密码:<input type="password" name="pwd" id="pwd" value="<%=pwd %>"/>
	<br/>
	记住密码<input type="checkbox" name="remember" id="check1" value="yes" <%=check %> ><br/>
	<input type="submit" name="bt" id="btid" value="登入"/>
	<input type="buttom" name="zx" id="zxid" value="注销" onclick=""/>
	</form>
</body>
</html>