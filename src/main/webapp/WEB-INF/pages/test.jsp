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
        <h2>실험실 : 주문하기 시나리오</h2>
        <br>
        주문하기 테스트 ( 카트 넣기 + 주문 )
        <br>
        1. 상품 리스트 보여줌 (상품 탭에서 등록 가능)
        <br>
        2. 상품 카트에 담음
        <br>
        3. 카트에 담긴거 보여줌 (사용자 아이디 : admin)
        <br>
        4. 주문 하기
        <br>
        5. 주문 탭에서 확인
    </div>

    <div>
        <c:forEach items="${productList}" var="item">
            <div style="float:left; margin-left:20px;">
                ${item.productNameKr}
                <br>
                <img src="${item.imageUrl}" width="215px" height="215px"/><br>
                가격 : <p style="width:120px" class="form-control" disabled="">${item.price}</p>원
                <textarea style="width:215px" disabled class="form-control" rows="3">${item.descText}</textarea>
                <br>
                수량 선택 : <input id="amount_${item.productNo}" class="form-control" value="0">
                <br>
                <button class="btn btn-info" onclick="carting(${item.productNo})">카트에 담기</button>
            </div>
        </c:forEach>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script type="text/javascript">
    function carting(productNo) {
        var userId = 'admin';
        var tagId = '#amount_' + productNo;
        var amount = $(tagId).val();


        if(amount <= 0) {
            alert('수량을 1개 이상 입력해주세요.');
        }

        var ajaxRequestUrl = "/api/cart/" + userId;
        var data = {
            'userId' : userId,
            'productNo' : productNo,
            'amount' : amount
        }

        console.log(userId + '사용자 , ' + productNo + '번 상품,' + amount + '개 카트 담기 시도.');


//        $.ajax({
//            url: ajaxRequestUrl,
//            type: 'POST',
//            data: JSON.stringify(data),
//            contentType: "application/json; charset=utf-8",
//            success: function (data) {
//                alert("등록 되었습니다.");
//                //추가된 항목을 리스트에 추가하기 위해 reload
//                location.reload(true);
//            },
//            error: function (request, status, error) {
//                alert("fail. code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
//            }
//        });
    }
</script>
</body>
</html>


