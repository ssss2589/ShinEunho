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
function f_delete(){
	var count = 0;
	var values = document.getElementsByName("mid");
	
	for(var i=0;i<values.length;i++){
		if(values[i].checked){
			count++;
		}
	}
	if(count==0){
		alert("선택된 삭제항목이 없습니다.");
	}else{
		formm.action="/wepapp/NonageServlet2?command=admin_Member_Delete"
		formm.submit();
	}
}
function go_search(){
	formm.action="NonageServlet2?command=admin_Member";
	formm.submit();
}
function go_total(){
	formm.action="NonageServlet2?command=admin_Member";
	formm.submit();
}


</script>
</head>

<body>
<%@ include file="Aheader.jsp" %>
	<form name="formm" method="post">
	<input type="hidden" name="plus" value="0">
	<div class="container">
	<table>
		<tr>
		<td width="642">
		아이디명
		<input type="text" name="key">
		<input class="btn" name="btn_search" type="button" value="검색" onclick="go_search()">
		<input class="btn" name="btn_total" type="button" value="전체보기" onclick="go_total()">
		<input class="btn" type="button" value="로그아웃" onclick="location.href='NonageServlet2?command=index'">
		</td>
		</tr>
	</table>
		<table class="table table-striped">
			<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>이메일</th>
				<th>사용유무</th>
				<th>가입날짜</th>
				<th>탈퇴</th>
			</tr>
			</thead>
			<tbody>
			<c:choose>
			<c:when test="${size==0}">
			<th colspan="9"><h3>등록된 회원이 없습니다.</h3></th>
			</c:when>
			<c:otherwise>
			<c:forEach items="${memlist}" var="item">
			<tr>
			<th><a href="NonageServlet2?command=admin_MemberDetail&id=${item.id}">${item.id}</a></th>
			<th>${item.name}</th>
			<th>${item.email}</th>
			
			<c:if test="${item.useyn eq 'y'}">
			<th>사용중</th>
			</c:if>
			<c:if test="${item.useyn eq 'n'}">
			<th>미사용</th>
			</c:if>
			<th>
			<fmt:formatDate value="${item.indate}" type="date"/></th>
			<c:if test="${item.useyn eq 'y'}">
			<th><input type="checkbox" id="mid" name="mid" value="${item.id}"/></th>
			</c:if>
			<c:if test="${item.useyn eq 'n'}">
			<th>X</th>
			</c:if>
			</tr>
			</c:forEach>
			</c:otherwise>
			</c:choose>
			<th colspan="9"><a href="#" onclick="f_delete()"><h4 style="text-align: right;">탈퇴시키기</h4></a></th>
			<tr><td colspan="9" style="text-align: center;"> ${paging} </td></tr>
			</tbody>
		</table>
		<hr/>
	</div>
	</form>
<script src="http://code.jquery.com/jquery-latest.js"></script>
 <script src="js/bootstrap.min.js"></script>
</body>
</html>