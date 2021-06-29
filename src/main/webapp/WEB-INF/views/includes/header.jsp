<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>웹개발 커뮤니티</title>
	
	<!-- Home CSS -->
	<link href="/resources/css/home.css" rel="stylesheet">
	<link href="/resources/css/textarea.css" rel="stylesheet">
	
    <!-- Bootstrap Core CSS -->
    <link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/resources/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="/resources/vendor/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

</head>

<body>

    <div id="wrapper">
        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/">웹개발 커뮤니티</a>
            </div>
            <!-- /.navbar-header -->

           <ul class="nav navbar-top-links navbar-right">        
            <div id="headerTop">
			<div id="memberInfo">
				<!-- 로그아웃 상태일때만 노출 -->
				<c:if test="${loginMember.nickname == null}">
					<table>
						<tr>
							<td>
								<a href="/member/login"></i>로그인</a>
							</td>
							<td>
								<span class="verticalBar">
									ㅣ
								</span>
							</td>
							<td>
								<a href="/member/member"></i>회원가입</a>
							</td>
						</tr>
					</table>
				</c:if>
				
				<!-- 로그인 상태일때 -->
				<c:if test="${loginMember.nickname != null}">
				<form action="/member/logout" method="post" class="memberForm">
					<table>
						<tr>
							<td>
								<a href="${loginMember.id }" class="memberModify">${loginMember.nickname }님 반갑습니다</a>
							</td>
							<td>
								<span class="verticalBar">
									ㅣ
								</span>
							</td>
							<td>
								<input type="submit" id="logoutBtn" value="로그아웃">
							</td>
						</tr>
					</table>
				</form>
				</c:if>
			</div>
		</div>
		</ul>
        <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="검색...">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                            </div>
                            <!-- /input-group -->
                        </li>
                        <li class="dropdown">
                   			<c:if test="${loginMember.nickname == null}">
					<table>
						<tr>
							<td>
								&emsp;<a href="/member/login">
									로그인
								</a>
							</td>
							<td>
								<span class="verticalBar">
									ㅣ
								</span>
							</td>
							<td>
								<a href="/member/member">
									회원가입
								</a>
							</td>
						</tr>
					</table>
				</c:if>
				
				<!-- 로그인 상태일때 -->
				<c:if test="${loginMember.nickname != null}">
				<form action="/member/logout" method="post" class="memberForm">
					<table>
						<tr>
							<td>
								<a href="${loginMember.id }" class="memberModify">${loginMember.nickname }님 반갑습니다</a>
							</td>
							<td>
								<span class="verticalBar">
									ㅣ
								</span>
							</td>
							<td>
								<input type="submit" id="logoutBtn" value="로그아웃">
							</td>
						</tr>
					</table>
				</form>
				</c:if>
						<li>
                            <a href="#"><i class="fa fa-comments-o fa-fw"></i> 커뮤니티<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="/board/list">입장하기</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-question fa-fw"></i> Q&A<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="/question/list">입장하기</a>
                                </li>
                            </ul>
                        </li>
                        <li class="dropdown">
                   			<a href="https://github.com/hgu0125/portfolio" class="dropdown-toggle">
                       	 	<i class="fa fa-github fa-fw"></i> Github</a>
                        <li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <div id="page-wrapper">
        
<script src="/resources/vendor/jquery/jquery.min.js"></script>