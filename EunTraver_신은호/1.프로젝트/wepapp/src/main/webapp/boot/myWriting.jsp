<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, project.*"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<link href="/wepapp/boot/css/bootstrap.min.css" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="/wepapp/boot/css/bootstrap-responsive.css" rel="stylesheet">
<link rel="stylesheet" href="/wepapp/boot/css/E.css">
<meta charset="UTF-8">
<title>Eun travel</title>
<script type="text/javascript">
function free_delete(){
	var count = 0;
	var values = document.getElementsByName("qseq");
	
	for(var i=0;i<values.length;i++){
		if(values[i].checked){
			count++;
		}
	}
	if(count==0){
		alert("선택된 삭제항목이 없습니다.");
	}else{
		formm.action="/wepapp/NonageServlet2?command=free_delete"
		formm.submit();
	}
}
function com_delete(){
	var count = 0;
	var values = document.getElementsByName("cseq");
	
	for(var i=0;i<values.length;i++){
		if(values[i].checked){
			count++;
		}
	}
	if(count==0){
		alert("선택된 삭제항목이 없습니다.");
	}else{
		formm.action="/wepapp/NonageServlet2?command=com_delete"
		formm.submit();
	}
}
</script>
</head>
<body>
<%@ include file="header.jsp" %>
<h2>내가 등록한 게시물</h2>
	<form name="formm" method="post">
	<div class="container">
		<table class="table table-striped">
			<thead>
			<tr>
				<th>제목</th>
				<th>날짜</th>
				<th>조회수</th>
				<th> </th>
				<th>삭제</th>
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
			<th><a href="NonageServlet2?command=freeDetail&qseq=${item.qseq}">${item.subject}</a></th>
			<th>
			<fmt:formatDate value="${item.indate}" type="date"/></th>
			<th>${item.click}</th>
			<th><a href="NonageServlet2?command=correction&qseq=${item.qseq}">수정하기</a></th>
			<th><input type="checkbox" id="qseq" name="qseq" value="${item.qseq}"/></th>
			</tr>
			<input type="hidden" value="${item.qseq }" name="free">
			</c:forEach>
			</c:otherwise>
			</c:choose>
			<th colspan="5"><a href="#" onclick="free_delete()"><h4 style="text-align: right;">삭제하기</h4></a></th></tr>
			<tr><td colspan="6" style="text-align: center;"> ${paging} </td></tr>
			</tbody>
		</table>
<h2>내가 등록한 댓글</h2>
	<form name="formm2" method="post">
	<div class="container">
		<table class="table table-striped">
			<thead>
			<tr>
				<th>내용</th>
				<th>날짜</th>
				<th>게시물</th>
				<th>삭제</th>
			</tr>
			</thead>
			<tbody>
			<c:choose>
			<c:when test="${comsize==0}">
			<h3>등록하신 댓글이 없습니다.</h3>
			</c:when>
			<c:otherwise>
			<c:forEach items="${comList}" var="item">
			<tr>
			<th>${item.commend}</th>
			<th>
			<fmt:formatDate value="${item.indate}" type="date"/></th>
			<th><a href="NonageServlet2?command=freeDetail&qseq=${item.qseq}">${item.qseq}</a></th>
			<th><input type="checkbox" id="cseq" name="cseq" value="${item.cseq}"/></th>
			</tr>
			</c:forEach>
			</c:otherwise>
			</c:choose>
			<th colspan="4"><a href="#" onclick="com_delete()"><h4 style="text-align: right;">삭제하기</h4></a></th></tr>
			<tr><td colspan="6" style="text-align: center;"> ${paging} </td></tr>
			</tbody>
		</table>
<script src="http://code.jquery.com/jquery-latest.js"></script>
        <script src="js/bootstrap.min.js"></script>
</body>
</html>