<%@page import="com.ado.solitu.entity.UserBean"%>
<%@page import="com.ado.solitu.service.UserService"%>
<%@page import="com.ado.solitu.object.factory.ObjectFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/update_user.js"></script>
</head>
<body>
<%
   int id=Integer.valueOf(request.getParameter("userId"));
   UserService userservice=(UserService)ObjectFactory.getObject("UserService");
   UserBean userBean=new UserBean();
   userBean=userservice.queryById(id);
   
%>
<form action="${pageContext.request.contextPath}/UpdateUserServlet?userId=<%=id%>"  method="post">
  姓名:<input type="text" name="uname" value=<%=userBean.getU_name()%> /><br/>
  年龄:<input type="text" name="uage" value=<%=userBean.getU_age()%>/><br/>
  地址:<input type="text" name="uaddress" value=<%=userBean.getU_address()%>/><br/>
  <input type="submit" value="修改"/>  &nbsp;&nbsp;
  <input type="button" value="取消" onclick="cancel()"/>
</form>
</body>
</html>