<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.nonage.dto.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ include file="../Header.jsp" %> 
	<%@ include file="sub_img.html" %> 
	<%@ include file="sub_menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<article>
<h2>My Page(주문상세정보)</h2>
<form name="formm" method="post">
		<table id="cartList">
		<tr>
		 <th>주문일자</th><th>주문번호</th><th>주문자</th><th>주문 총액</th>
		</tr>
		<tr>
		<td>
			<fmt:formatDate value="${order.indate}" type="date"/>
		</td>
		<td>${order.oseq}</td>
		<td>${order.mname}</td>
		<td>
			<fmt:formatNumber value="${totalPrice}" type="currency"/>
		</td>
		</tr>
		</table>
		<table id="cartList">
		<tr>
		 <th>상품명</th><th>상품별주문번호</th><th>수량</th><th>가격</th><th>처리상태</th>
		</tr>
		<c:forEach items="${orderList}" var="orderVO">
		<tr>
		<td>
			${orderVO.pname}
		</td>
		<td>${orderVO.pseq}</td>
		<td>${orderVO.quantity}</td>
		<td>
			<fmt:formatNumber value="${orderVO.price2 * orderVO.quantity}" type="currency"/>
		</td>
		<td>
		<c:choose>
		<c:when test="${orderVO.result==1}">진행중</c:when>
		<c:when test="${orderVO.result==2}">완료</c:when>
		</c:choose>
		</td>
		</tr>
		</c:forEach>
		</table>
		<div class="clear"></div>
		<div id="buttons" style="float:right">>
			<input type="button" value="쇼핑 계속하기" class="cancel"
				onclick="location.href='NonageServlet?command= index'">
		</div>
		</fome>
</article>
</body>
</html>