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
		<form action="/wepapp/NonageServlet2?command=visitData" method="post"
		name="formm" class="form">
			<p class="text info">관광 검색</p>
			<tabel>
			<tr>
			<td>정렬방법</td>
			<td><select name="list" class="text">
				<option value="O">제목순</option>
				<option value="P">조회순</option>
				</select><br>
			</tr>
			<tr>
			<td>관광타입</td>
			<tr>
			<td><select name="visittype" class="text">
				<option value="12">관광</option>
				<option value="14">문화시설</option>
				<option value="15">축제/공연/행사</option>
				<option value="25">여행코스</option>
				<option value="28">레포츠</option>
				<option value="32">숙박</option>
				<option value="38">쇼핑</option>
				<option value="39">음식</option>
				</select><br>
			</td>
			</tr>
			<tr>
			<td>지역</td>
			<td><select name="area" class="text">
				<option value="1">서울</option>
				<option value="2">인천</option>
				<option value="3">대구</option>
				<option value="4">부산</option>
				<option value="5">광주</option>
				<option value="6">부산</option>
				<option value="7">울산</option>
				<option value="8">세종시</option>
				</select><br>
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
