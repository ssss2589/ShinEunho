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
<script type="text/javascript">
function image(){
	window.open("/wepapp/boot/visitImage.jsp","chiled","width=550,height=500");
}
</script>
</head>
<body>
<article>
<h2>관광 정보</h2>
<form name="formm" method="post" action="/wepapp/NonageServlet2?command=visitdata_Form">
<c:choose>
<c:when test= "${visitsize==0}">
	<h3 style="color:red; text-align:center;">찾으시는 관광이 없습니다.</h3>
	</c:when>
	<c:otherwise>
		<table id="cartList" class="table">
		<tr>
		 <th>주소</th><th>조회수</th><th>타이틀(사진)</th><th>전화번호</th>
		</tr>
		<c:forEach items="${visitList}" var="item">
		<tr>
		<td>
		${item.address}
		</td>
		<td>${item.readcount}</td>
		<td>
		<a href="${item.image}">${item.title}</a>
		</td>
		<td>
			${item.tel}
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