<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <%@ page import="java.util.*, project.*"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Eun travel</title>
<link href="/wepapp/boot/css/bootstrap.min.css" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="/wepapp/boot/css/bootstrap-responsive.css" rel="stylesheet">
<link rel="stylesheet" href="/wepapp/boot/css/E.css">
</head>
<body>
<article>
<h2>버스 시간표</h2>
<form name="formm" method="post" action="/wepapp/NonageServlet2?command=busData_Form">
<c:choose>
<c:when test= "${itmesize==0}">
	<h3 style="color:red; text-align:center;">찾으시는 버스가 없습니다.</h3>
	</c:when>
	<c:otherwise>
		<table id="cartList" class="table">
		<tr>
		 <th>출발터미널</th><th>도착터미널</th><th>출발시간</th><th>도착시간</th><th>가격</th><th>등급</th>
		</tr>
		<c:forEach items="${items}" var="item">
		<tr>
		<td>
		${item.gocity}
		</td>
		<td>${item.endcity}</td>
		<td>
		${item.gotime}
		</td>
		<td>
			${item.endtime}
		</td>
		<td>
			${item.price}
		</td>
		<td>
			${item.grade}
		</td>
		</tr>
		</c:forEach>
		</table>
		</c:otherwise>
		</c:choose>
		<input type="submit" value="확인" id="button" class="submit">
		</fome>

</article>

</body>
</html>