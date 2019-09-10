<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, project.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<head>
<meta charset="utf-8">
<title>Eun travel</title>
<link href="/wepapp/boot/css/bootstrap.min.css" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="/wepapp/boot/css/bootstrap-responsive.css" rel="stylesheet">
<link rel="stylesheet" href="/wepapp/boot/css/E.css">
<style type="text/css">
body {
	padding-top: 20px;
	padding-bottom: 60px;
}
/* Custom container */
.container {
	margin: 0 auto;
	max-width: 1000px;

}

.container>hr {
	margin: 60px 0;
}

/* Main marketing message and sign up button */
.jumbotron {
	margin: 80px 0;
	text-align: center;
}

.jumbotron h1 {
	font-size: 100px;
	line-height: 1;
}

.jumbotron .lead {
	font-size: 24px;
	line-height: 1.25;
}

.jumbotron .btn {
	font-size: 21px;
	padding: 14px 24px;
}

/* Supporting marketing content */
.marketing {
	margin: 60px 0;
}

.marketing p+h4 {
	margin-top: 28px;
}

/* Customize the navbar links to be fill the entire space of the .navbar */
.navbar .navbar-inner {
	padding: 0;
}

.navbar .nav {
	margin: 0;
	display: table;
	width: 100%;
}

.navbar .nav li {
	display: table-cell;
	width: 1%;
	float: none;
}

.navbar .nav li a {
	font-weight: bold;
	text-align: center;
	border-left: 1px solid rgba(255, 255, 255, .75);
	border-right: 1px solid rgba(0, 0, 0, .1);
}

.navbar .nav li:first-child a {
	border-left: 0;
	border-radius: 3px 0 0 3px;
}

.navbar .nav li:last-child a {
	border-right: 0;
	border-radius: 0 3px 3px 0;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="masthead">
			<div class="navbar">
				<div id="logo">
					<a href="/wepapp/NonageServlet2?command=index"> <img src="/wepapp/boot/img/eunscanner.JPG" width="180" height="100"
						alt="eun">
					</a>
					<c:choose>
					<c:when test="${empty sessionScope.loginUser}">
					<p class="text-right">
					<a href="/wepapp/NonageServlet2?command=login_Form">로그인</a>
					<a href="/wepapp/NonageServlet2?command=admin_login_Form">(관리자)</a>
					<a href="/wepapp/NonageServlet2?command=join_Form">회원가입</a>
					</p>
					</c:when>
					<c:otherwise>
					<p class="text-right">
					${sessionScope.loginUser.name}(${sessionScope.loginUser.id})님 환영합니다.
					<a href="/wepapp/NonageServlet2?command=mypage">MY PAGE/</a>
					<a href="/wepapp/NonageServlet2?command=mywrite">MY WRITING/</a>
					<a href="/wepapp/NonageServlet2?command=logout">LOGOUT</a>
					</p>
					</c:otherwise>
					</c:choose>
					</div>
					<div class="navbar-inner">
						<div class="container">
							<ul class="nav">
								<li><a href="/wepapp/NonageServlet2?command=busData_Form">고속버스 안내</a></li>
								<li><a href="/wepapp/NonageServlet2?command=visitdata_Form">관광 정보</a></li>
								<li><a href="/wepapp/NonageServlet2?command=freeList">자유게시판</a></li>
								<li><a href="/wepapp/NonageServlet2?command=inquiry">1:1 고객센터</a></li>
							</ul>

					</div>
				</div>
			</div>
		</div>
</body>
</html>