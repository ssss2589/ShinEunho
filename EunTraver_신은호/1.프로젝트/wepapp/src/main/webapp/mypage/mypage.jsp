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
<script type="text/javascript">

</script>
</head>
<body>
<article>
<h2>My Page(${title})</h2>
<form name="formm" method="post">
		<table id="cartList">
		<tr>
		 <th>주문일자</th><th>주문번호</th><th>상품명</th><th>결제금액</th><th>주문 상세</th>
		</tr>
		<c:forEach items="${orderList}" var="orderVO">
		<tr>
		<td>
			<fmt:formatDate value="${orderVO.indate}" type="date"/>
		</td>
		<td>${orderVO.oseq}</td>
		<td>${orderVO.pname}</td>
		<td>
			<fmt:formatNumber value="${orderVO.price2}"  type="currency"/> 
		</td>
		<td>
			<a href="NonageServlet?command=order_detail&oseq=${orderVO.oseq}" method="post">조회</a>
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
<%@ include file="../footer.jsp" %>
</body>
</html>