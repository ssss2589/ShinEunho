<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, project.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<head>
<meta charset="utf-8">
<title>Eun travel</title>
<link href="/wepapp/boot/css/bootstrap.min.css" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="/wepapp/boot/css/bootstrap-responsive.css" rel="stylesheet">
<link rel="stylesheet" href="/wepapp/boot/css/E.css">
<script type="text/javascript">
function go_pop(){
	window.open("/wepapp/boot/goCity.jsp","chiled","width=550,height=500");
}
function back_pop(){
	window.open("/wepapp/boot/backCity.jsp","chiled","width=550,height=500");
}

</script>
</head>
<body>
		<c:choose>
		<c:when test="${null eq sessionScope.loginUser}">
		<script type="text/javascript">	
		alert("로그인을 해주세요.");
		location.href="/wepapp/NonageServlet2?command=index";
		</script>
		</c:when>
		<c:otherwise>
		<%@ include file="header.jsp" %>
		<form action="/wepapp/NonageServlet2?command=bus_GoSearch" method="post"
		name="formm" class="form">
			<p class="text info">버스 검색</p>
			<tabel>
			<tr>
			<td>날짜</td>
			<td><input type="date" name="date" min="2000-01-01" max="2100-12-12" required /></td><br>
			</tr>
			<tr>
			<td>출발지역</td>
			<td><input type="text" id="text" name="go"  size="12" onclick="go_pop()" required /></td><br>
			</tr>
			<tr>
			<td>도착지역</td>
			<td><input type="text" id="text" name="back"  size="12" onclick="back_pop()" required></td><br>
			</tr>
			<tr>
			<td>버스등급</td>
			<td><select name="grade" class="text">
				<option value="">상관없음</option>
				<option value="1">우등</option>
				<option value="2">고속</option>
				<option value="3">심야우등</option>
				<option value="4">심야고속</option>
				<option value="5">일반</option>
				<option value="6">일반심야</option>
				<option value="7">프리미엄</option>
				<option value="8">심야프리미엄</option>
				
			</td>
			</tr>
			</tabel>
			<div id="buttons">
			<input type="submit" value="찾기" id="button" class="submit">
			<input type="reset" value="취소" id="button" class="cancel">
			</div>
		</form>
		</c:otherwise>
		</c:choose>
	
	 <script src="http://code.jquery.com/jquery-latest.js"></script>
     <script src="js/bootstrap.min.js"></script>
</body>
</html>
