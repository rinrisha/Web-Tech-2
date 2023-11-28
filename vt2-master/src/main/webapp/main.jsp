<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<c:set var="lang" value="${sessionScope.language ? sessionScope.language : 'ru'}"--%>
<%--       scope="session"/>--%>
<%--<c:out value="${sessionScope.language}"/>--%>
<c:set var="jumb" value="${sessionScope.jumbotron}" scope="session"/>
<c:set var="brkfst" value="${sessionScope.breakfast}" scope="session"/>
<c:set var="strf" value="${sessionScope.streetfood}" scope="session"/>
<c:set var="soup" value="${sessionScope.soup}" scope="session"/>
<c:set var="deserts" value="${sessionScope.deserts}" scope="session"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="text"/>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;900&display=swap" rel="stylesheet">
    <title>Site</title>
</head>
<style>
    *{
        padding: 0;
        margin: 0;
        box-sizing: border-box;
        text-decoration: none;
        list-style: none;
        color: black;
        font-size: 16px;
        font-family: Verdana, Tahoma, sans-serif;
    }
    body{
        background-color: maroon;
    }

    header{
        background-color: #f6b319;
        margin-bottom: 50px;
    }
    .lang{
        display: flex;
        height: 30px;
        align-items: center;
        justify-content: end;
    }
    .lang input{
        border: none;
        outline: none;
        height: 30px;
        padding: 5px;
        background-color: #f6b319;
    }
    .ru-lang{
        border-top-left-radius: 7px;
        border-bottom-left-radius: 7px;
        border-right: 1px solid black;
        margin-right: 2px;
    }
    .en-lang{
        border-top-right-radius: 7px;
        border-bottom-right-radius: 7px;
        border-left: 1px solid black;
    }
    .lang input.active{
        border: 3px solid green;
        text-align: center;
        padding-top: 2px;
    }
    .lang input:hover{
        background-color: #fac444;
        cursor: pointer;
    }
    .container{
        width: 90%;
        margin: 0 auto;
    }
    .brand a{
        color: #557c3e;
        font-size: 28px;
    }
    .navigation-bar{
        display: flex;
        align-items: center;
        justify-content: space-between;
        height: 80px;
    }

    .logform{
        width: auto;
        height: auto;
    }
    .loginbtn{
        color: #f6b319 !important;
        border-radius: 15px;
        padding: 10px;
        font-weight: bold;
        background-color: #61122f;
        margin-left: 5px;
        border: none;
    }
    .loginbtn:hover{
        background-color: #4b061f;
    }
    #tel{
        font-weight: bold;
        background-color: #61122f;
        border-radius: 15px;
        padding: 10px;
        color: #f6b319;
    }
    #tel:hover{
        background-color: #4b061f;
    }

    .telephone{
        display: none;
        font-weight: bold;
        background-color: #61122f;
        border-radius: 15px;
        padding: 10px;
        color: #f6b319;
        width: 100%;
        text-align: center;
    }
    .navigation-list a{
        margin-left: 20px;
        transition: 0.3s;
        color:maroon;
    }

    .navigation-list a:hover{
        text-shadow: rgb(112, 11, 11) 1px 1px 2px;
        color: #61122f;
    }

    .navigation-list{
        display: flex;
        align-items: center;
    }

    .main-screen-img{
        background-image: url("${jumb}");
        height: 90vh;
        margin: 20px 0;
        background-size: cover;
        border: 1px solid white;
    }

    .menu{
        display: flex;
        justify-content: space-around;
    }
    .menu-a{
        transition: 0.3s;
    }
    .menu-a:hover{
        transform: scale(1.05);
        box-shadow: 0px 0px 7px 4px rgb(107, 107, 107);
    }
    /*
    .menu-item{
        width: 300px;
        height: 200px;
        position: relative;
    } */

    .menu-item-category{
        position: absolute;
        background-color: #434343a7;
        color: white;
        width: 100%;
        line-height: 1.5em;
        text-align: center;
        vertical-align: middle;
        border-radius: 5px 5px 0 0;
        bottom: 0;
        right: 0;
    }
    .main-menu{
        margin: 50px 0;
    }

    #special{
        /*background-image: url("img/specials-tile.jpg");*/
        background-size: cover;
    }


    .menu-categories{
        margin: 50px 0;
    }
    .menu-items{
        display: flex;
        justify-content: space-around;
        flex-wrap: wrap;
    }
    .menu-categories-title{
        color: #fff;
        text-align: center;
        margin-bottom: 30px;
        font-size: 24px;
    }

    .menu-item{
        width:25%;
    }
    menu-category-btn{
        border: 0px;
    }
    .menu-category-img{
        width: 200px;
        height: 200px;
        border: 1px solid black;
        position: relative;
        margin: 0 auto;
    }
    #breakfast{
        background-image: url(${brkfst});
        background-position: center;
    }
    #soup{
        background-image: url("${soup}");
        background-position: center;
        background-size: cover;
    }
    #street-food{
        background-image: url("${strf}");
    }
    #deserts{
        background-image: url("${deserts}");
    }
    .menu-category-img:hover{
        box-shadow: 0px 0px 5px 2px #ffffffdc;
    }
    .menu-category-title {
        position: absolute;
        bottom: 0;
        left: 0;
        background-color: #1b1b1be4;
        color: white;
        width: 100%;
        text-transform: uppercase;
        text-align: center;
        line-height: 1.5em;
        border-radius: 5px 5px 0 0;
    }

    footer{
        background-color: #363636;
        padding-top: 20px;
        padding-bottom: 50px;
    }
    .footer-title{
        color: #fff;
        text-align: center;
        margin-bottom: 20px;
    }
    .map{
        width: 85%;
        margin: 0 auto;
    }
    .map-item{
        position: relative;
    }

    iframe{
        width: 100%;
        height: 350px;
    }
    /* footer .container{
        display: flex;
        align-items: center;
        justify-content: center;
    } */
    .map-title{
        position: absolute;
        bottom: 2.5px;
        left: 0;
        color: #fff;
        background-color:  #1b1b1be4;
        text-align: center;
        text-transform: uppercase;
        width: 100%;
        line-height: 1.4em;
        border-radius: 5px 5px 0 0;
    }
    .copyright{
        color: #fff;
        text-align: center;
        margin-top: 30px;
    }

    @media (max-width: 992px) {
        .menu-item{
            width: 30%;
            /* text-align: center; */
        }
        .main-screen-img{
            /*background-image: url("../img/jumbotron_992.jpg");*/
        }
    }

    @media (max-width: 768px) {
        .menu-item{
            width: 40%;
        }
        #tel{
            display: none;
        }
        .telephone{
            display: block;
            margin-bottom: 50px;
        }
        header{
            margin-bottom: 10px;
        }
        .main-screen-img{
            /*background-image: url("../img/petshop.jpg");*/
        }
    }

    @media (max-width: 576px) {
        .menu-item{
            width: 350px;
            height: 250px;
            margin: 0 auto;
            margin-bottom: 20px;
        }
        .menu-items{
            display: block;
        }
        iframe{
            height: 250px;
        }
        .container{
            width: 95%;
        }
    }
    @media (max-width: 480px){
        .navigation-list{
            display: block;
            /* padding-top: 30px; */
        }
        .navigation-list-item{
            margin-bottom: 5px;
        }
        .telephone{
            margin-bottom: 30px;
        }
    }
</style>
<body>
<header>
<div class="container">
    <div class="navigation-bar">
        <div class="brand">
            <h1><a href="/demo1_war">Baloven</a></h1>
        </div>
        <nav class="navigation">
            <ul class="navigation-list">
                <li class="navigation-list-item"><a href="/demo1_war"><fmt:message key="nav.main"/></a></li>
                <li class="navigation-list-item"><a href="/demo1_war/#menu"><fmt:message key="nav.menu"/></a></li>
                <li class="navigation-list-item"><a href="basket"><fmt:message key="nav.basket"/></a></li>
                <li class="navigation-list-item"><a id="tel" href="tel:+375331112233">+375(33)111-22-33</a></li>
                <c:if test="${sessionScope.Authorized}">
                    <li class="navigation-list-item">
                        <form method="POST">
                            <input type="hidden" name="command" value="LOG_OUT" />
                            <input type="submit" class="loginbtn" value="<fmt:message key="nav.logout"/>"/>
                        </form>

                    </li>
                </c:if>
                <c:if test="${!sessionScope.Authorized}">
                    <li class="navigation-list-item">
                        <a href="login" class="loginbtn"><fmt:message key="nav.login"/></a>
                    </li>
                </c:if>
            </ul>
        </nav>
    </div>
</div>
</header>
<div class="container">
    <a class="telephone" href="tel:+375331112233">+375(33)111-22-33</a>
</div>
<div class="container">
    <div class="lang">
        <form method="get" action="/demo1_war">
            <input type="hidden" name="lang" value="ru">
<%--            <a href="single-category">--%>
                <input type="submit" value="ru" class="ru-lang ${sessionScope.language == "ru" ? "active" : ""}">
<%--            </a>--%>

        </form>
        <form method="get" action="/demo1_war">
            <input type="hidden" name="lang" value="en">
            <input type="submit" value="en" class="en-lang ${sessionScope.language == "en" ? "active" : ""}">
        </form>
    </div>
</div>
<section class="main-screen">
    <div class="container">
        <div class="main-screen-img">
<%--            <img src="${jumb}" alt="Jumbotron">--%>
        </div>
    </div>
</section>
<section id="menu" class="menu-categories">
    <div class="container">
        <h2 class="menu-categories-title"><fmt:message key="menu.our"/></h2>
        <div class="menu-items">

            <form method="get" action="single-category">
                <input type="hidden" name="category_id" id="category_id" value="1">
<%--                <a href="single-category">--%>
                    <button type="submit" class="menu-category-btn">
                        <div class="menu-item">
                            <a class="menu-category col-3" href="single-category">
                                <div class="menu-category-img" id="breakfast">
                                    <span class="menu-category-title"><fmt:message key="menu.breakfat"/></span>
                                </div>
                            </a>
                        </div>
                    </button>
<%--                </a>--%>

            </form>

            <form method="get" action="single-category">
                <input type="hidden" name="category_id" value="2">
                <button type="submit" class="menu-category-btn">
                    <div class="menu-item">
                        <a class="menu-category" href="single-category">
                            <div class="menu-category-img" id="soup">
                                <span class="menu-category-title"><fmt:message key="menu.soup"/></span>
                            </div>
                        </a>
                    </div>
                </button>
            </form>

            <form method="get" action="single-category">
                <input type="hidden" name="category_id" value="3">
                <button type="submit" class="menu-category-btn">
                    <div class="menu-item">
                        <a class="menu-category" href="single-category">
                            <div class="menu-category-img" id="deserts">
                                <span class="menu-category-title"><fmt:message key="menu.deserts"/></span>
                            </div>
                        </a>
                    </div>
                </button>
            </form>

            <form action="single-category">
                <input type="hidden" name="category_id" value="4">
                <button type="submit" class="menu-category-btn">
                    <div class="menu-item">
                        <a class="menu-category" href="single-category">
                            <div class="menu-category-img" id="street-food">
                                <span class="menu-category-title"><fmt:message key="menu.streetFood"/></span>
                            </div>
                        </a>
                    </div>
                </button>
            </form>
        </div>
    </div>
</section>
<footer>
    <div class="container">
        <h3 class="footer-title"><fmt:message key="location.our"/></h3>
        <div class="map">
            <a class="map-link" href="https://goo.gl/maps/JMnpTyQd8CUJm8pz7" target="_blank">
                <div class="map-item">
                    <iframe width="100%" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2350.1197435668223!2d27.59273715106426!3d53.911848039805776!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x46dbcfaefc7ace77%3A0x108d2d965ec4df2f!2z0YPQuy4g0JPQuNC60LDQu9C-IDksINCc0LjQvdGB0Lo!5e0!3m2!1sru!2sby!4v1677136102096!5m2!1sru!2sby" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade">
                    </iframe>
                    <span class="map-title">map</span>
                </div>
            </a>
        </div>
        <div class="copyright">
            All rights are reserved &#169;
        </div>
    </div>
</footer>
</body>
</html>
