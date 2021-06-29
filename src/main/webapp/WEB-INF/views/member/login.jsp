<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>로그인</title>

    <!-- Bootstrap Core CSS -->
    <link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/resources/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

</head>

<body>

    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">로그인</h3>
                    </div>
                    <div class="panel-body">
                        <form action="/member/login" method="post">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="아이디" id="id" name="id" type="text" autofocus>
                                </div>
                                <div>
                                	<div class="loginfail"></div>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="비밀번호" id="password" name="password" type="password" value="">
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input name="remember" type="checkbox" value="Remember Me">로그인 유지
                                    </label>
                                </div>
                                <!-- Change this to a button or input when using this as a form -->
                               	<button type="submit" class="btn btn-lg btn-success btn-block" id="submit">로그인</button>
                                <hr>
                                <p>SNS 로그인</p>
                                <a href="/home" class="btn btn-lg btn-success btn-block">Sign in with GitHub</a>
                                <a href="/home" class="btn btn-lg btn-success btn-block">Sign in with Google</a>
                                <a href="/home" class="btn btn-lg btn-success btn-block">Sign in with Facebook</a>
                                <a href="/home" class="btn btn-lg btn-success btn-block">Sign in with Kakao</a>
                                <a href="/home" class="btn btn-lg btn-success btn-block">Sign in with Naver</a>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

	<script src="/resources/js/jquery-3.5.1.js"></script>
	<script type="text/javascript" src="/resources/js/member/login.js"></script>

    <!-- jQuery -->
    <script src="/resources/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="/resources/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="/resources/js/sb-admin-2.js"></script>

</body>
</html>