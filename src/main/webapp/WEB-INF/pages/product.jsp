<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="/css/index.css" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"/>

<div class="container">
    <div class="main_text">
        <button class="btn btn-success btn_register_shop" data-toggle="modal" data-target="#regist_modal">신규 Product
            등록
        </button>

        <table class="table" style="margin-top: 15px">
            <tr>
                <td>No</td>
                <td>사진</td>
                <td>카테고리</td>
                <td>상품명</td>
                <td>등록일시</td>
                <td>가격</td>
                <td>재고</td>
            </tr>
            <c:forEach var="item" items="${productList}">
                <tr>
                    <td>${item.productNo}</td>
                    <td><img src="${item.imageUrl}" width="150px" height="100px"></td>
                    <td>${item.productCategory}</td>
                    <td>${item.productNameKr}</td>
                    <td>${item.registYmdt}</td>
                    <td>${item.price}</td>
                    <td>${item.stock}</td>
                </tr>
            </c:forEach>
        </table>

    </div>

    <!-- Product 등록 Modal -->
    <div id="regist_modal" class="modal fade" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">신규 상품 등록</h4>
                </div>
                <div class="modal-body">
                    <form id="register_product_form" enctype="multipart/form-data">
                        <div class="form-group">
                            <form>
                                <%--<div class="form-group">--%>
                                <%--<label for="selectShop">SHOP</label>--%>
                                <%--<select id="selectShop" class="form-control">--%>
                                <%--<option value="-1">SHOP 선택</option>--%>
                                <%--<c:forEach items="${shopList}" var="shop">--%>
                                <%--<option value="${shop.shopNo}">${shop.shopName}</option>--%>
                                <%--</c:forEach>--%>
                                <%--</select>--%>
                                <%--</div>--%>
                                <div class="form-group">
                                    <label for="category">카테고리</label>
                                    <select id="category" class="form-control">
                                        <option value="-1">카테고리</option>
                                        <c:forEach items="${categoryList}" var="category">
                                            <option value="${category}">${category.nameKr}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label class="control-label" for="name">상품명</label>
                                    <input type="text" class="form-control" id="name" placeholder="상품명">
                                </div>
                                <div class="form-group">
                                    <label for="nameKr">상품명(한글)</label>
                                    <input type="text" class="form-control" id="nameKr">
                                </div>
                                <div class="form-group">
                                    <label for="imageFileInput">상품 사진 (215x215 최적화)</label>
                                    <input type="file" id="imageFileInput">
                                    <p id="status" class="help-block">상품 이미지 파일을 업로드 해주세요.</p>
                                    <img src="" width="215px", height="215px" id="preview_image">
                                </div>
                                <div>
                                    <label for="stock">재고</label>
                                    <input type="text" id="stock">
                                </div>
                                <div>
                                    <label for="price">가격</label>
                                    <input type="text" id="price">
                                </div>
                                <div>
                                    <label for="desc">상품 설명</label>
                                    <textarea id="desc" class="form-control" rows="3"></textarea>
                                </div>
                            </form>
                        </div>

                    </form>
                </div>
                <div class="modal-footer">
                    <button type="submit" form="register_product_form" class="btn btn-default">추가</button>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="/js/jquery-1.12.2.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/loginFB.js"></script>
<script src="https://sdk.amazonaws.com/js/aws-sdk-2.3.11.min.js"></script>

<script type="text/javascript">
    if(isNotLogin()) {
        alert('로그인이 필요합니다.');

        location.href='/admin';
    }

    sImageUrl = '';
    var appId = '652364014913917';
    var roleArn = 'arn:aws:iam::764006455036:role/adminLoginROle';
    var token = getFacebookTocken();
    var fbUserId;

    AWS.config.region = 'ap-northeast-2';
    AWS.config.credentials = new AWS.WebIdentityCredentials({
        ProviderId: 'graph.facebook.com',
        RoleArn: roleArn,
        WebIdentityToken: token
    });
    var bucket = new AWS.S3({
        params: {
            Bucket: 'dicos3'
        }
    });

    $('.dropdown-toggle').dropdown();

    $(function () {
        $('#imageFileInput').on('change', function() {
            readURL(this);
            var file = this.files[0];
            var result = document.getElementById('status');
            if (file) {
                debugger;
                result.innerHTML = "";
                var date = new Date();
                //TODO : 추후에 추가될 상품 ID로 변경 검토
                var fileSufix = date.getYear() + "_" +
                        date.getMonth() + "_" +
                        date.getDay() + "_" +
                        date.getHours() + "_" +
                        date.getSeconds() + "_" +
                        date.getMilliseconds();
                var objKey = 'product-img-' + fileSufix; // 중복 피하기 위해
                var params = {
                    Key: objKey, ContentType: file.type, Body: file, ACL: "public-read"
                };
                bucket.putObject(params, function (err, data) {
                    if (err) {
                        result.innerHTML = 'ERROR: ' + err;
                    } else {
                        // upload success
                        sImageUrl = bucket.endpoint.href + 'dicos3' + '/' + objKey;
                        result.innerHTML = '이미지 업로드 성공, ' + sImageUrl;
                    }
                });
            } else {
                results.innerHTML = 'Nothing to upload..';
            }
        });
    });

    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('#preview_image').attr('src', e.target.result);
            }

            reader.readAsDataURL(input.files[0]);
        }
    }

    $('#register_product_form').submit(function (e) {
        e.preventDefault();

        var data = {

            productName: $('#name').val(),
            productNameKr: $('#nameKr').val(),
            productCategory: $('#category').val(),
            imageUrl: sImageUrl,
            stock: $('#stock').val(),
            price: $('#price').val(),
            descText: $('#desc').val()
        }

        $.ajax({
            url: "/product",
            type: "POST",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                alert("등록 되었습니다.");
                //추가된 항목을 리스트에 추가하기 위해 reload
                location.reload(true);
            },
            error: function (request, status, error) {
                alert("fail. code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
            }
        });
    });

</script>
</body>
</html>
