<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.nonage.dto.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page isELIgnored="false"%>
<%@ include file="sub_menu.jsp" %>
<%@ include file="Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/wepapp/gheTeam/css/shopping.css">
</head>
<body>
<article>
<h2>Q&A List</h2>
<form name="formm" method="post">
<table id="cartList">
		<tr>
		 <th>번호(답변여부)</th><th>제목</th><th>작성자</th><th>작성일</th>
		</tr>
<c:choose>
<c:when test="${listSize<=0}">
	<h3 style="color:red; text-align:center;">장바구니가 비었습니다.</h3>
</c:when>
<c:otherwise>
		<c:forEach items="${qnaList}" var="qnaVO">
		<tr>
		<td height="23" align="center">
		<c:choose>
		<c:when test="${qnaVO.rep==2}">
		<span style="font-weight: bold; color:red;">${qnaVO.qseq}</span>
		(답변처리완료)
		</c:when>
		<c:otherwise>
		<span style="font-weight: bold; color:blue;">${qnaVO.qseq}</span>
		(미처리)
		</c:otherwise>
		</c:choose>
		</td>
		<td><a href="NonageServlet?command=admin_QnaDetail&qseq=${qnaVO.qseq}">${qnaVO.subject}</a></td>
		<td>${qnaVO.id}</td>
		<td>
			<fmt:formatDate value="${qnaVO.indate}"  type="date"/> 
		</td>
		</c:forEach>
		</table>
		</c:otherwise>
</c:choose>
</form>
</article>
</body>
</html>