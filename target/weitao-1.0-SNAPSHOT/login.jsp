<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/1
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login"/>
用户名：<input type="text" name="username"/>
密码：<input type="password" name="password"/>
<input type="submit" value="登陆"/>
</body>
</html>
