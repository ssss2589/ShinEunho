<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, project.*" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="/wepapp/boot/css/bootstrap.min.css" rel="stylesheet">
<link href="/boot/css/bootstrap-responsive.css" rel="stylesheet">
<link href="/boot/css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" href="/wepapp/boot/css/E.css">
</head>
<body>
    <div class="container">
		<div class="masthead">
			<div class="navbar">
					<div class="navbar-inner">
						<div class="container">
							<ul class="nav">
								<li>
    <a href="/wepapp/NonageServlet2?command=adminMain">자유게시판 관리</a>
  </li>
  <li>
  <a href="/wepapp/NonageServlet2?command=admin_inquiry">1:1 고객센터 관리</a>
  </li>
  <li>
  <a href="/wepapp/NonageServlet2?command=admin_Member">회원관리</a>
  </li>
   <li>
  <a href="/wepapp/NonageServlet2?command=IndexAdmin">메인관리</a>
  </li>
							</ul>
					</div>
				</div>
			</div>
		</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>