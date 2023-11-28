<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="lang" value="${sessionScope.language ? sessionScope.language : 'ru'}"
       scope="session"/>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="text"/>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Basket</title>
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
    background-color: #C1E1C1;
  }

  header{
    background-color: #f6b319;
    margin-bottom: 50px;
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

  .loginbtn{
    color: #f6b319 !important;
    border-radius: 15px;
    padding: 10px;
    font-weight: bold;
    background-color: #C1E1C1;
    margin-left: 5px;
    border: none;
  }
  .loginbtn:hover{
    background-color: #013220;
  }
  #tel{
    font-weight: bold;
    background-color: #C1E1C1;
    border-radius: 15px;
    padding: 10px;
    color: #f6b319;
  }
  #tel:hover{
    background-color: #013220;
  }

  .telephone{
    display: none;
    font-weight: bold;
    background-color: #C1E1C1;
    border-radius: 15px;
    padding: 10px;
    color: #f6b319;
    width: 100%;
    text-align: center;
  }
  .navigation-list a{
    margin-left: 20px;
    transition: 0.3s;
    color: #C1E1C1;
  }

  .navigation-list a:hover{
    text-shadow: #013220 1px 1px 2px;
    color: #C1E1C1;
  }

  .navigation-list{
    display: flex;
    align-items: center;
  }
  .container{
    width: 90%;
    margin: 0 auto;
  }
  .basket {
    margin: 50px 0;
  }
  .basket-item {
    display: flex;
    justify-content: space-between;
    align-items: start;
    margin-top: 20px;
    padding: 10px;
  }
  .basket-item-container{
    display: flex;
  }
  .basket-item-img {
    /*background-image: url("../img/menu-tile.jpg");*/
    background-size: cover;
    background-position: center;
    width: 200px;
    height: 150px;
  }
  .basket-item-img img{
    width: 100%;
  }
  .basket-item-info {
    margin-left: 10px;
    display:flex;
    flex-direction: column;
    justify-content: space-between;
  }
  .basket-item-title {
  }

  .basket-item-amount {
    font-size: 16px;
    margin-top: 10px;
    display: flex;
    align-items: center;
    height: 25px;
  }
  .amount-input{
    width: 35px;
    padding: 0 5px;
    outline: none;
    font-size: 1em;
    margin: 0;
    border: none;
    text-align: center;
    background-color: #ffffff;
    z-index: -1;
  }
  .amount-input::-webkit-outer-spin-button,
  .amount-input::-webkit-inner-spin-button{
    display: none;
  }
  .amount-input::-moz-focus-inner,
  .amount-input::-moz-focus-outer{
    display: none;
  }
  .inc {
    width: 25px;
    font-size: 1em;
    text-align: center;
    border: none;
    border-top-left-radius: 7px;
    border-bottom-left-radius: 7px;
    background-color: #b2b2b2;
  }
  .dec {
    width: 25px;
    text-align: center;
    font-size: 1em;
    border: none;
    border-top-right-radius: 7px;
    border-bottom-right-radius: 7px;
    background-color: #b2b2b2;
  }
  .inc:hover, .dec:hover{
    cursor: pointer;
    background-color: #8b8b8b;
  }
  .line{
    border: none;
    background-color: #ffffffb2;
    height: 1px;
    width: 80%;
    margin: 0 auto;
    margin-top: 20px;
  }
  .input-container{
    text-align: left;
    width: 220px;
    margin: 0 auto;
  }
  .input{
    padding: 3px 5px 5px 5px;
    /*border: 2px solid #005d00;*/
    border:none;
    border-radius: 5px;
    margin-top: 5px;
  }
  input:focus{
    outline: 2px solid #005d00;
    border: none;
  }
  .form-wrap{
    text-align: center;
  }
  .order-btn{
    margin: 5px auto;
    width: 220px;
    padding: 3px 5px 5px 5px;
    color: #C1E1C1 !important;
    border: none;
    border-radius: 5px;
    background-color: #f6b319;
    display: block;
  }
  .order-btn:hover{
    background: #c59015;
  }
  .empty-basket{
    text-align: center;
    font-size: 20px;
    color: white;
  }
  .order-info{
    border-radius: 15px;
    padding: 10px;
    width: 220px;
    background-color: #557c3e;
    margin-bottom: 20px;
  }
  .order-info p{
    color: white;
    font-size: 16px;
  }
  #information{
    display: none;
  }
  .footer-title{
    font-size: 22px;
    margin: 30px 0 10px 0;
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

<section class="basket">
  <div class="container">
    <c:if test="${sessionScope.Authorized}">
      <c:if test="${basketArrSize == 0}">
        <p class='empty-basket'><fmt:message key="basket.empty"/></p>
      </c:if>
      <c:forEach var="dish" items="${basketArr}">
        <div class='basket-item'>
          <div class='basket-item-container'>
            <div class='basket-item-img' >
              <img src="${dish.image}" alt="">
            </div>
            <div class='basket-item-info'>
              <h3 class='basket-item-title'>${dish.dishName}</h3>
              <div class='basket-item-price-wrap'>
                <p class='basket-item-price'><fmt:message key="basket.price"/> <span>${dish.price*dish.amount}</span> <fmt:message key="basket.currency"/></p>
                <div class='basket-item-amount'>
                  <form method="post" action="basket">
                    <input type="hidden" name="command" value="INCREMENT">
                    <input type="hidden" name="dishId" value="${dish.id}">
                    <button type="submit" class="inc">+</button>
                  </form>
                  <input type="number" name="amount" id="amount" class="amount-input" value="${dish.amount}">
                  <form method="post" action="basket">
                    <input type="hidden" name="command" value="DECREMENT">
                    <input type="hidden" name="dishId" value="${dish.id}">
                    <button type="submit" class="dec">-</button>
                  </form>

                </div>
              </div>
            </div>
          </div>
        </div>
        <hr class='line'>
      </c:forEach>
    </c:if>

    <c:if test="${!sessionScope.Authorized}">
      <p class='empty-basket'><fmt:message key="basket.ifNotAuth"/></p>
    </c:if>
  </div>
</section>
<section class="order">
  <div class="container">
    <form method="post">
      <div class="form-wrap">
        <div class="input-container">
          <label for="name"><fmt:message key="order.name"/></label><br>
          <input class="input" type="text" name="name" id="name" required>
        </div>
        <div class="input-container">
          <label for="surname"><fmt:message key="order.surname"/></label><br>
          <input class="input" type="text" name="surname" id="surname" required>
        </div>
        <div class="input-container">
          <label for="street"><fmt:message key="order.street"/></label><br>
          <input class="input" type="text" name="street" id="street" required>
        </div>
        <div class="input-container">
          <label for="home"><fmt:message key="order.home"/></label><br>
          <input class="input" type="text" name="home" id="home" required>
        </div>
        <div class="input-container">
          <label for="flat"><fmt:message key="order.flat"/></label><br>
          <input class="input" type="text" name="flat" id="flat"required>
        </div>
        <button class="order-btn" type="submit" ><fmt:message key="order.action"/></button>
        <div id="information" class="order-info">
          <p><fmt:message key="order.success"/></p>
        </div>
      </div>
    </form>
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
