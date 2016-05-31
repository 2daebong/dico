<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="/css/header.css" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"/>

<div class="container">
    <div class="main_text">

        <table class="table table-hover" style="margin-top: 30px">
            <tr>
                <td>주문번호</td>
                <td>사용자ID</td>
                <td>주문시간</td>
                <td>주소</td>
                <td>전화번호</td>
                <td>금액</td>
                <td>배송상태 (수단)</td>
                <td> </td>
            </tr>
            <c:forEach items="${orderList}" var="order">
            <tr>
                <td>${order.orderNo}</td>
                <td>${order.userId}</td>
                <td>${order.registYmdt}</td>
                <td>준비 중 ^^;</td>
                <td>준비 중 ^^;</td>
                <td>${order.totalPrice}</td>
                <td>${order.status.nameKr} (${order.deliveryType.nameKr})</td>
                <td> </td>
            </tr>
            </c:forEach>
        </table>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
</body>
</html>
