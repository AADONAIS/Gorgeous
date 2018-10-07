<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../javascript/add_user.js"></script>
</head>
<body>
<form action="${pageContext.request.contextPath}/AddUserServlet" method="post">
   姓名:<input type="text" name="uname"/><br/>
   密码:<input type="password" name="password"/><br/>
   性别:<select name="ugender"><option>男</option><option>女</option></select><br/>
   年龄:<input type="text" name="uage"/><br/>
   电话:<input type="text" name="uphone"/><br/>
   地址:<input type="text" name="uaddress"/><br/>
  用户权限:<select name="uauth"><option>普通员工</option><option>管理员</option></select><br/>
   <input type="submit" value="添加"/>
   <input type="button" value="取消" onclick="cancel()"/>
</form>
</body>
</html>