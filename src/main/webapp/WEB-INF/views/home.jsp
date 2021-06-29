<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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

<!-- Bootstrap Core CSS -->
<link href="/resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="/resources/vendor/metisMenu/metisMenu.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="/resources/css/sb-admin-2.css" rel="stylesheet">

<!-- Morris Charts CSS -->
<link href="/resources/vendor/morrisjs/morris.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="/resources/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

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
									<td><a href="/member/login"></i>로그인</a></td>
									<td><span class="verticalBar"> ㅣ </span></td>
									<td><a href="/member/member"></i>회원가입</a></td>
								</tr>
							</table>
						</c:if>

						<!-- 로그인 상태일때 -->
						<c:if test="${loginMember.nickname != null}">
							<form action="/member/logout" method="post" class="memberForm">
								<table>
									<tr>
										<td><a href="${loginMember.id }" class="memberModify">${loginMember.nickname }님 반갑습니다</a></td>
										<td><span class="verticalBar"> ㅣ </span></td>
										<td><input type="submit" id="logoutBtn" value="로그아웃">
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
							<form method=get action="http://www.google.co.kr/search"
								target="_blank">
								<div class="input-group custom-search-form">
									<input type="text" class="form-control" placeholder="Google 검색..."> <span class="input-group-btn">
										<button class="btn btn-default" type="submit">
											<i class="fa fa-search"></i>
										</button>
									</span>
							</form>
				</div>
				<!-- /input-group -->
				</li>
				<li class="dropdown"><c:if test="${loginMember.nickname == null}">
						<table>
							<tr>
								<td>&emsp;<a href="/member/login"> 로그인 </a>
								</td>
								<td><span class="verticalBar"> ㅣ </span></td>
								<td><a href="/member/member"> 회원가입 </a></td>
							</tr>
						</table>
					</c:if> <!-- 로그인 상태일때 --> <c:if test="${loginMember.nickname != null}">
						<form action="/member/logout" method="post" class="memberForm">
							<table>
								<tr>
									<td><a href="${loginMember.id }" class="memberModify">${loginMember.nickname }님 반갑습니다</a></td>
									<td><span class="verticalBar"> ㅣ </span></td>
									<td><input type="submit" id="logoutBtn" value="로그아웃">
									</td>
								</tr>
							</table>
						</form>
					</c:if>
				<li><a href="#"><i class="fa fa-comments-o fa-fw"></i> 커뮤니티<span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="/board/list">입장하기</a></li>
					</ul></li>
				<li><a href="#"><i class="fa fa-question fa-fw"></i> Q&A<span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="/question/list">입장하기</a></li>
					</ul></li>
				<li class="dropdown"><a href="https://github.com/hgu0125/portfolio/" class="dropdown-toggle">
						<i class="fa fa-github fa-fw"></i> Github
				</a>
				<li>
					</ul>
			</div>
			<!-- /.sidebar-collapse -->
	</div>
	<!-- /.navbar-static-side -->
	</nav>
	<div id="page-wrapper">
		<div class="row">
			<hr>
		</div>
		<div>
			<img src="resources/image/main.png" width="1590" height="500">
		</div>
		&emsp;
            <div class="row"></div>
            <div class="row">
                <div class="col-lg-8">

                    <!-- /.panel -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                        	<a href="/board/list">
                            <i class="fa fa-comments-o fa-fw"></i> 커뮤니티 게시판</a>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="list-group">
                            <c:forEach items="${list1}" var="board">
                                <a href="/board/list" class="list-group-item">
                                    <i class="fa fa-comments-o fa-fw"></i> <c:out value="${board.title }"/>
                                    <span class="pull-right text-muted small"><c:out value="${board.writer }"/></span>
                                </a>
                            </c:forEach>
                            </div>
                            <!-- /.list-group -->
                            <form id="actionForm" action="/board/list" method="get"></form>
                        </div>
                        <!-- /.panel-body -->  
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-8 -->
                <div class="col-lg-4">

                    <!-- /.panel -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                      		<a href="/question/list">
                            <i class="fa fa-question"></i> 질문답변 게시판</a>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="list-group">
                                <c:forEach items="${list2}" var="question">
                                <a href="/question/list" class="list-group-item">
                                    <i class="fa fa-comments-o fa-fw"></i> <c:out value="${question.title }"/>
                                    <span class="pull-right text-muted small"><c:out value="${question.writer }"/></span>
                                </a>
                            </c:forEach>
                            </div>
                            <form id="actionForm" action="/question/list" method="get"></form>
                        </div>
                        <!-- /.panel-body -->  
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    </div>
                </div>

	<script src="/resources/js/jquery-3.5.1.js"></script>
	<script type="text/javascript" src="/resources/js/home.js"></script>

	<!-- jQuery -->
	<script src="/resources/vendor/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="/resources/vendor/metisMenu/metisMenu.min.js"></script>

	<!-- Morris Charts JavaScript -->
	<script src="/resources/vendor/raphael/raphael.min.js"></script>
	<script src="/resources/vendor/morrisjs/morris.min.js"></script>
	<script src="/resources/data/morris-data.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="/resources/js/sb-admin-2.js"></script>

	<footer>
		<div class="footer">
			<hr>
			<a href="#">웹개발 커뮤니티 |</a><a href="#"> 개인정보보호 |</a><a href="#">
				광고문의 |</a><a href="#"> Contact |</a><a href="#"> Facebook |</a><a
				href="#"> GitHub |</a>
			<hr>
			상호명: 홍코딩 | 대표명: 나는야대빵 | 사업자등록번호: 111-22-33333 | 문의: <a href="#">hgu0125@gmail.com</a><br>
			<a href="#"> Copyfightⓒ2021 by HongCoding Inc ALL RIGHTS RESERVED</a><br>
			<br>
		</div>
	</footer>
</body>
</html>
