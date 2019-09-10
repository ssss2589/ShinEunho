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
<h2>Member List</h2>
<form name="formm" method="post">
<tr>
		<td width="642">
		회원 이름
		<input type="text" name="name">
		<input class="btn" name="btn_search" type="button" value="검색" onclick="go_search()">

		</td>
		</tr>
<table id="cartList">
		<tr>
		 <th>아이디(탈퇴여부)</th><th>이름</th><th>이메일</th><th>우편번호</th><th>주소</th>
		 <th>전화</th><th>가입일</th>
		</tr>
<c:choose>
<c:when test="${Listsize<=0}">
	<h3 style="color:red; text-align:center;">장바구니가 비었습니다.</h3>
</c:when>
<c:otherwise>
		<c:forEach items="${memberList}" var="memVO">
		<tr>
		<td height="23" align="center">
		<c:choose>
		<c:when test="${memVO.useyn=='y'}">
		<span style="font-weight: bold; color:blue;">${memVO.id}</span>
		(<input type="checkbox" name="result" value="${itemVO.id}">)
		</c:when>
		<c:otherwise>
		<span style="font-weight: bold; color:red;">${memVO.id}</span>
		(<input type="checkbox" checked="checked" value="${item.mem}" disabled=true>)
		</c:otherwise>
		</c:choose>
		</td>
		<td>${memVO.name}</td>
		<td>${memVO.email}</td>
		<td>${memVO.zipNum}</td>
		<td>${memVO.address}</td>
		<td>${memVO.phone}</td>
		<td>
			<fmt:formatDate value="${memVO.indate}"  type="date"/> 
		</td>
		</c:forEach>
		</table>
		</c:otherwise>
</c:choose>
</form>
</article>
</body>
</html>