<%--
  Created by IntelliJ IDEA.
  User: makar
  Date: 17.12.2019
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<jstl:if test="${not empty requestScope.doesNotExist}">
    <p>This user does not exist</p>
</jstl:if>
<jstl:if test="${not empty requestScope.wrongPassword}">
    <p>Wrong user's password</p>
</jstl:if>
<form method="post" action="controller?action=login">
    <p><input type="text" name="login" size="10"/></p>
    <p><input type="password" name="password" size="10" /></p>
    <p><input type="submit" value="Login" /></p>
    <p></p>
</form>
</body>
</html>
