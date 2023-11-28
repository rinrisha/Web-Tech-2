<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%--<c:set var="lang" value="${sessionScope.language ? sessionScope.language : 'ru'}"--%>
<%--       scope="session"/>--%>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="text"/>
<html>
<head>
    <title>Registration</title>
</head>
<style>
    *{
        padding: 0;
        margin: 0;
        box-sizing: border-box;
        text-decoration: none;
        list-style: none;
        font-size: 16px;
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
        text-align: center;
        position: absolute;
        left: 0;
        top: 0;
        right: 0;
        bottom: 0;
        margin: auto;
        border-radius: 20px;
        width: 450px;
        height: 300px;
        background-color: #f6b319;
        padding: 50px 40px 0px 40px;
        display: inline-block;
    }
    .title{
        font-size: 22px;
        margin-bottom: 20px;

    }
    form{
        display: inline-block;
    }
    .input-wrap{
        width: 330px;

        margin-bottom: 10px;
        display: flex;
        justify-content: space-between;
    }
    .loginbtn{
        color: #f6b319;
        border-radius: 15px;
        padding: 10px;
        font-weight: bold;
        background-color: #C1E1C1;
        margin-left: 5px;
        border: none;
        font-size: 18px;
        width: 325px;
        margin-bottom: 10px;
    }
    .loginbtn:hover{
        background-color: #013220;
    }
    label{
        font-weight: 600;
    }
    .input{
        border-radius: 5px;
        border: 2px solid #1e4b06;
        outline: none;
    }
    .input:focus{
        border: 2px solid #68c433;
        box-shadow: 0px 0px 5px 2px rgb(104, 196, 51);
    }
    .regbtn{
        color: #476534;
        font-size: 14px;
        font-weight: bold;
        text-decoration: none;
    }
    .regbtn:hover{
        color: #557c3e;
        cursor: pointer;
    }
</style>
<body>
<div class="wrapper">
    <h1 class="title"><fmt:message key="authorize.title"/></h1>
    <form method="POST" >
        <div class="input-wrap">
            <label><fmt:message key="authorize.login"/></label>
            <input class="input" type="text" name="username" id="username" autocomplete="off">
        </div>
        <div class="input-wrap">
            <label><fmt:message key="authorize.pass"/></label>
            <input class="input" type="password" name="password" id="password" >
        </div>
        <div class="input-wrap">
            <label>Почта:</label>
            <input class="input" type="email" name="email" id="email" >
        </div>
        <input type="hidden" name="command" value="REGISTRATE" />
        <div class="buttons">
            <input class="loginbtn" type="submit" name="register" value="<fmt:message key="authorize.signUp"/>">
        </div>
        <a class="regbtn" href="login"><fmt:message key="authorize.signIn"/></a>
    </form>
</div>
</body>
</html>
