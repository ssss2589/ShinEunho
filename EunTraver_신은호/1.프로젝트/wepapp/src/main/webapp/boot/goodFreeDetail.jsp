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
<script type="text/javascript">
function comment(){
	var qseq=formm.qseq.value;
	formm.action="/wepapp/NonageServlet2?command=freeDetail&qseq="+qseq;
	formm.submit();
}
function good(){
	var indate=formm.indate.value;
	formm.action="/wepapp/NonageServlet2?command=good&indate="+indate;
	formm.submit();
}
</script>
<style type="text/css">
   th{
    text-align: left;
    }
   
</style>
</head>
<body>
<%@ include file="header.jsp" %>
<article>
<h2>자유 게시판</h2>
<form name="formm" method="post">
		<span><b>제목</b> ${free.subject}</span><br>
		<span><b>등록일</b> <fmt:formatDate value="${free.indate}" pattern="yy.MM.dd  hh시mm분"/></span>
		<table>
		<tr>
		<th>내용</th>
		</tr>
		<tr>
		<td colspan="4">
		<img src="product_images/${free.image}"/></td>
		</tr>
		<tr>
		<td>${free.content}</td>
		</tr>
		<br/>
		<tr>
		<td><h3>댓글남기기</h3></td>
		</tr>
		<tr>
		<td><input class="input-xxlarge" type="text" name="commend" placeholder="글을 입력해주세요.">
		<input class="check" type="button" onclick="comment()"value="등록"></td>
		<input type="hidden" value="${free.qseq}" name="qseq">
		</tr>
		</table>
		<c:if test="${size!=0}">
			<c:forEach items="${comList}" var="com" >
			<table style="border-top:1px solid black;">
			<tr>
				<td ><span><b>${com.id }님</b></span></td>
			</tr>
			<tr>
			<td>${com.commend}</td>
			</tr>
			<tr>
				<td><h4><fmt:formatDate value="${com.indate}" pattern="yy.MM.dd  hh시mm분"/></h4></td>
				<c:forEach items="${likeList}" var="like" >
				<c:if test="${like.commendno eq com.cseq}">
				<c:if test="${like_check eq 1}">
				<td><span><button type="button" name="good" style="color: red;" onclick="location.href='NonageServlet2?command=good&cseq=${com.cseq }&qseq=${free.qseq}'"><i class="icon-heart icon-red"></i></button></span></td>
				</c:if>
				<c:if test="${like_check ne 1 }">
				<td><span><button type="button" name="good" style="color: black;" onclick="location.href='NonageServlet2?command=good&cseq=${com.cseq }&qseq=${free.qseq}'"><i class="icon-heart icon-red"></i></button></span></td>
				</c:if>
				</c:if>
				</c:forEach>			
			</tr>
			</table>
			</c:forEach>
		</c:if>
		<div class="clear"></div>
			<input type="button" value="목록보기" class="check" style="text-align: left;"
				onclick="location.href='NonageServlet2?command=freeList'">
		</div>
		</form>
</article>
<script src="http://code.jquery.com/jquery-latest.js"></script>
 <script src="js/bootstrap.min.js"></script>
</body>
</html>