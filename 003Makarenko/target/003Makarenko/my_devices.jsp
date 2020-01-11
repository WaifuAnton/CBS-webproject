<%--
  Created by IntelliJ IDEA.
  User: makar
  Date: 10.01.2020
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>My devices</title>
</head>
<body>
    <table border="1">
        <tr>
            <td>Type</td>
            <td>Name</td>
        </tr>
        <jstl:forEach items="${requestScope.allMyItems}" var="item">
            <tr>
                <td>${item.type}</td>
                <td>${item.name}</td>
                <td>
                    <form method="post" action="controller?action=return_device">
                        <input type="hidden" name="device_id" value="${item.id}"/>
                        <input type="hidden" name="device_type" value="${item.type}"/>
                        <input type="hidden" name="device_name" value="${item.name}"/>
                        <input type="submit" value="Return"/>
                    </form>
                </td>
            </tr>
        </jstl:forEach>
    </table>
</body>
</html>
