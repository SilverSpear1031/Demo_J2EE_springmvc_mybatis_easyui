<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015-11-10
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>regist</title>
</head>
<body>
<h1 align="center">注&nbsp;册</h1>
<h4 align="center" style="color:red">${errorMsg }</h4>

<form action="<c:url value='/doRegist'/>" method="post">
    <div align="center">
        用户名：<input type="text" name="uname" value="${users.uname }"/><br>
        密&nbsp;码：<input type="password" name="password" value="${users.password }"/><br>
        性&nbsp;别：<input type="radio" name="gender" value="男" checked="checked"/>男
        <input type="radio" name="gender" value="女"/>女<br>
        电&nbsp;话：<input type="text" name="cellphone" value="${users.cellphone }"/><br>
        邮&nbsp;箱：<input type="text" name="email" value="${users.email }"/><br><br>
        <%--<input type="hidden" name="method" value="regist"/>--%>
        <input type="submit" value="注&nbsp;册"/>&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="reset" value="重&nbsp;置"/>

    </div>
</form>
</body>
</html>
