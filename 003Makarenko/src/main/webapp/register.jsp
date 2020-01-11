<%--
  Created by IntelliJ IDEA.
  User: makar
  Date: 16.12.2019
  Time: 23:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <jstl:if test="">${not empty requestScope.notAdd}>User already exists</jstl:if>
    <form method="post" action="controller?action=register">
        <p><input type="text" name="login" size="10"/></p>
        <p><input type="password" name="password" size="10" /></p>
        <p><input type="submit" value="Register" /></p>
        <p></p>
    </form>
</body>
</html>
