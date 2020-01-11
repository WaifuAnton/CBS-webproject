<%--
  Created by IntelliJ IDEA.
  User: makar
  Date: 18.12.2019
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Main</title>
</head>
<body>
    <jstl:choose>
        <jstl:when test="${not empty sessionScope.user}">
            <p>${sessionScope.user.login}</p>
            <p><a href="controller?action=my_devices">My devices</a></p>
            <p>${sessionScope.user.balance}</p>
            <p><a href="add_money.jsp">Add money</a></p>
            <p><a href="controller?action=logout">Logout</a></p>
            <p>Available devices</p>
            <table border="1">
                <tr>
                    <td>Type</td>
                    <td>Name</td>
                    <td>Total cost</td>
                </tr>
                <jstl:forEach items="${requestScope.items}" var="item">
                    <jstl:if test="${not empty requestScope.notEnoughMoney}">You don't have enough money</jstl:if>
                    <jstl:if test="${item.usedBy.equals('none')}">
                        <tr>
                            <td>${item.type}</td>
                            <td>${item.name}</td>
                            <td>${item.rentCost}</td>
                            <td>
                                <form method="post" action="controller?action=rent_device">
                                    <input type="hidden" name="device_id" value="${item.id}"/>
                                    <input type="hidden" name="device_type" value="${item.type}"/>
                                    <input type="hidden" name="device_name" value="${item.name}"/>
                                    <input type="hidden" name="device_price" value="${item.rentCost}"/>
                                    <input type="submit" value="Rent"/>
                                </form>
                            </td>
                        </tr>
                    </jstl:if>
                </jstl:forEach>
            </table>
        </jstl:when>
        <jstl:otherwise>
            <p><a href="register.jsp">Register</a></p>
            <p><a href="login.jsp">Login</a></p>
        </jstl:otherwise>
    </jstl:choose>
</body>
</html>
