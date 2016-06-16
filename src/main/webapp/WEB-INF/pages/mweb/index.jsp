<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link href="/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="/css/mweb/header.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</head>
<body>
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no" />
    <nav class="navbar navbar-default navbar-static-top">
        <div class="container">
            <div class="headerbar navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/mweb/home">야채사요</a>
                <a href="#" class="btn_basket">
                    <span>장바구니</span>
                </a>
            </div>
            <div id="navbar" class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="/mweb/home">Home</a></li>
                    <li><a href="#">로그인</a></li>
                    <li><a href="#">내정보</a></li>
                    <li><a href="#">주문정보</a></li>
                    <li><a href="#">야채사요에 대하여</a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </div>
    </nav>
    <script type="text/javascript">
        $('.nav li').click(function(e) {
            $('.active').removeClass('active');
            $(this).addClass('active');
        });
    </script>

    <div class="container">
        <ul>
            <c:forEach items="${productList}" var="product" varStatus="status">
            <li <c:if test="${status.index eq 0}" >class="fir"</c:if>>
                <a href="<%--/shop/detail.php?hash=G02DA--%>" class="p_subject_item">
                    <div class="thumb">
                        <img src="${product.imageUrl}" alt="${product.productName}">
                    </div>
                    <dl class="p_info">
                        <dt class="p_name">${product.productNameKr}</dt>
                        <dd class="p_desc">${product.descText}</dd>
                        <dd class="p_price">
                            <span class="n_price">8,300</span>
                            <strong class="p_price_txt">${product.price}<span class="p_price_unit">원</span></strong>
                        </dd>
                        <dd class="badge_area">
                            <span class="badge best">베스트</span>
                            <c:if test="${status.index eq 2}">
                                <span class="badge event">이벤트특가</span>
                            </c:if>
                        </dd>
                    </dl>
                </a>
            </li>
            </c:forEach>
        </ul>
    </div>

<script src="/js/bootstrap.min.js"></script>
<script type="text/javascript">
    <%--var l = ${productList};--%>
//    console.log(l.length);
</script>
</body>
</html>
