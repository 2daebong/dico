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
            <h1>DICO ADMIN</h1>
            <br>
            <p><strong>페이스북 ID로 로그인하여 시작하세요!</strong></p>
            <fb:login-button scope="public_profile,email" size="xlarge" onlogin="checkLoginState();">
            </fb:login-button>

            <div id="status">
            </div>
        </div>
    </div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/loginFB.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
        $.ajaxSetup({ cache: true });
        $.getScript('//connect.facebook.net/en_US/sdk.js', function(){
            FB.init({
                appId      : '652364014913917',
                xfbml      : true,
                version    : 'v2.6'
            });
        });$.ajaxSetup({ cache: true });
    });

    function statusChangeCallback(response) {
        console.log('statusChangeCallback');
        console.log(response);
        // The response object is returned with a status field that lets the
        // app know the current login status of the person.
        // Full docs on the response object can be found in the documentation
        // for FB.getLoginStatus().
        if (response.status === 'connected') {
            // Logged into your app and Facebook.
            testAPI();
            saveLogin(response.authResponse.accessTocken);
        } else if (response.status === 'not_authorized') {
            // The person is logged into Facebook, but not your app.
            document.getElementById('status').innerHTML = 'Please log ' +
                    'into this app.';
        } else {
            // The person is not logged into Facebook, so we're not sure if
            // they are logged into this app or not.
            document.getElementById('status').innerHTML = 'Please log ' +
                    'into Facebook.';
        }
    }

    function checkLoginState() {
        FB.getLoginStatus(function(response) {
            statusChangeCallback(response);
        });
    }

    function testAPI() {
        console.log('Welcome!  Fetching your information.... ');
        FB.api('/me', function(response) {
            console.log('Successful login for: ' + response.name);
            document.getElementById('status').innerHTML =
                    'Thanks for logging in, ' + response.name + '!';
        });
    }
</script>


</body>
</html>
