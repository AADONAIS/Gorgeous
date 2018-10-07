<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css"/>
</head>
<body>
	<div class="m1Div">
		<form action="${pageContext.request.contextPath}/LoginServlet" method="post">
			用户名:&nbsp;&nbsp;<input type="text" name="username" /><br />
			<hr/>
			密 码:&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" name="userpwd" /><br />
			<hr/>
			<select>
				<option>请选择权限:</option>
				<option>普通用户</option>
				<option>管理员</option>
			</select>
			<br/>
			<hr/>
			<div id="input_div">
			<input type="submit" value="登录" /> &nbsp;&nbsp; <input type="reset"
				value="重置" />
				</div>
		</form>
	</div>
</body>
</html>