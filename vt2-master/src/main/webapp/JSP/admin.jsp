<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<c:set var="lang" value="${sessionScope.language ? sessionScope.language : 'ru'}"--%>
<%--       scope="session"/>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="text"/>
<html>
<head>
    <title>Панель администратора</title>
</head>
<style>
    *{
        font-family: Verdana, Tahoma, sans-serif;
        color: #476534;
    }
    label, input{
        font-size: 20px;
    }
    body{
        background: #C1E1C1;
    }
    .wrapper{
        /*text-align: center;*/
        margin: auto;
        border-radius: 20px;
        min-width: 450px;
        min-height: 300px;
        background-color: #f6b319;
        padding: 40px 50px 40px 50px;
        display: table;
        margin-top: 30px;
    }
    label{
        font-weight: 600;
    }

    table, td, th{
        color: black;
        border: 2px solid black;
        border-collapse: collapse;
        margin: 0px auto;
    }
    td, th{
        padding: 5px;
        min-width: 100px;
    }
</style>
<body>
<div class="wrapper">
    <h1>Статистика</h1>
    <ol>
        <c:forEach var="user" items="${users}" varStatus="counter">
            <li>
                <br>
                <ul>
                    <li>Логин: ${user.login}</li>
                    <li >Email: ${user.email}</li>
                    <li>Password: ${user.password}</li>
<%--                    <li>Товаров в корзине:--%>
<%--                        <ul>--%>
<%--                            <c:forEach var="dish" items="${dishes}" varStatus="counter2">--%>
<%--                                <c:if test="${counter == counter2}">--%>
<%--                                    <c:forEach var="dishItem" items="${dishes}" >--%>
<%--                                        <li>${dishItem.dishName}(${dishItem.amount}шт)</li>--%>
<%--                                    </c:forEach>--%>
<%--                                </c:if>--%>

<%--                            </c:forEach>--%>
<%--                        </ul>--%>
<%--                    </li>--%>
                </ul>
            </li>
        </c:forEach>
    </ol>
</div>
</body>
</html>
