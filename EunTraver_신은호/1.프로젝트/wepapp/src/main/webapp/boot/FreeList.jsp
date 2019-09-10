<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, project.*" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Eun travel</title>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="/wepapp/boot/css/bootstrap.min.css" rel="stylesheet">
<link href="/boot/css/bootstrap-responsive.css" rel="stylesheet">
<link href="/boot/css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" href="/wepapp/boot/css/E.css">
</head>
<body>
<%@ include file="header.jsp" %>
	<form name="formm" method="post">
	<input type="hidden" name="plus" value="0">
	<div class="container">
		<table class="table table-striped">
			<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>날짜</th>
				<th>조회수</th>
			</tr>
			</thead>
			<tbody>
			<c:choose>
			<c:when test="${freesize==0}">
			<h3>등록된 게시물이 없습니다.</h3>
			</c:when>
			<c:otherwise>
			<c:forEach items="${freeList}" var="item">
			<tr>
			<th>${item.qseq}</th>
			<th><a href="NonageServlet2?command=freeDetail&qseq=${item.qseq}">${item.subject}</a></th>
			<th>${item.id}</th>
			<th>
			<fmt:formatDate value="${item.indate}" type="date"/></th>
			<th>${item.click}</th>
			</tr>
			</c:forEach>
			</c:otherwise>
			</c:choose>
			<a class="btn btn-default pull-right" href="boot/freeListForm.jsp">글쓰기</a>
			<tr><td colspan="6" style="text-align: center;"> ${paging} </td></tr>
			</tbody>
		</table>
		<hr/>
	</div>
	</form>
<script src="http://code.jquery.com/jquery-latest.js"></script>
 <script src="js/bootstrap.min.js"></script>
</body>
</html>