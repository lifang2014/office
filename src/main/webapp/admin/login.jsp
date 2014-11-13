<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EDGE">
<title>用户登录</title>

<link href="<%=request.getContextPath() %>/resources/back/css/login/login.css" rel="stylesheet" type="text/css"/>

</head>

<script type="text/javascript">
if (window != top) {
	top.location.href = location.href;
}
</script>

<shiro:authenticated>
<%
	response.sendRedirect(request.getContextPath()+"/admin/common/main.html");
%>
</shiro:authenticated>

<%
	String loginFailure = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
	System.out.println(loginFailure);
 %>

<body onselectstart="return false" style="-moz-user-select:none;">
	<div class="main_r">
		<form action="login.jsp" method="post" id="loginform" name="loginform">
			<img class="i_com" src="<%=request.getContextPath() %>/resources/back/images/login/i_home.png">
			<img class="i_name" src="<%=request.getContextPath() %>/resources/back/images/login/i_name.png">
			<img class="i_pass" src="<%=request.getContextPath() %>/resources/back/images/login/i_pass.png">
			<input name="companyname" id="companyname" maxlength="13" type="text" class="input" placeholder="公司名" />
			<input rows="1" name="username" value="admin" id="username" type="text"  class="input" maxlength="13"  placeholder="用户名" autocomplete="off" />
			<input name="password" type="password" value="123456" class="input" placeholder="密码" autocomplete="off"  /> 
			<input type="submit" value="登录" class="btn" />
		</form>
	</div>
</body>
</html>

