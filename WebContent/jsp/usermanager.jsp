<%@page import="java.util.ArrayList"%>
<%@page import="com.ado.solitu.entity.UserBean"%>
<%@page import="java.util.List"%>
<%@page import="com.ado.solitu.service.UserService"%>
<%@page import="com.ado.solitu.object.factory.ObjectFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>用户管理界面</h3>
	<div>
	  <a href="add_user.jsp" target="right">增加</a>
	</div>
	<div>
		<table border="1px solid black">
			<tr>
			    <td>编号</td>
				<td>姓名</td>
				<td>年龄</td>
				<td>地址</td>
				<td>操作</td>
			</tr>
			<%
				UserService userservice = (UserService) ObjectFactory.getObject("UserService");
				List<UserBean> userlist = new ArrayList<UserBean>();
				userlist = userservice.login();
				for (UserBean userbean : userlist) {
			%>
			<tr>
			    <td><%=userbean.getU_id()%></td>
				<td><%=userbean.getU_name()%></td>
				<td><%=userbean.getU_age()%></td>
				<td><%=userbean.getU_address()%></td>
				<td><a href="update_user.jsp?userId=<%=userbean.getU_id()%>" target="right">修改</a> 
				<a href="${pageContext.request.contextPath}/DeleteUserServlet?userId=<%=userbean.getU_id()%>" target="right">删除</a></td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
</body>
</html>