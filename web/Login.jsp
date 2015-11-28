<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015-11-10
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<br><br><br><br><br><br><br><br><br><br>
<h1 align="center">登&nbsp;录</h1>
<h4 align="center" style="color:red">${errorMsg}</h4>

<form action="<c:url value='/doLogin'/>" method="post">
    <div align="center">
        用户名：<input type="text" name="uname" value="${users.uname }"/><br>
        密&nbsp;码：<input type="password" name="password" /><br><br>
        <%--<input type="hidden" name="method" value="login"/>--%>
        <input type="submit" value="登&nbsp;录"/>&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="<c:url value='/Regist'/>">
            <input type="button"  value="注&nbsp;册"/></a>
    </div>
</form>
</body>
</html>
