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
	var values = document.getElementsByName("qseq");
	
	for(var i=0;i<values.length;i++){
		if(values[i].checked){
			count++;
		}
	}
	if(count==0){
		alert("선택된 삭제항목이 없습니다.");
	}else{
		formm.action="/wepapp/NonageServlet2?command=free_delete&free=admin"
		formm.submit();
	}
}
function go_search(){
	formm.action="NonageServlet2?command=adminMain";
	formm.submit();
}
function go_total(){
	formm.action="NonageServlet2?command=adminMain";
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
		제목명
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
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>날짜</th>
				<th>조회수</th>
				<th>삭제</th>
			</tr>
			</thead>
			<tbody>
			<c:choose>
			<c:when test="${freesize==0}">
			<h3>등록된 게시물이 없습니다.</h3>
			</c:when>
			<c:otherwise>
			<c:forEach items="${freeList}" var="item">
			<tr>
			<th>${item.qseq}</th>
			<th><a href="NonageServlet2?command=freeDetail&free=admin&qseq=${item.qseq}">${item.subject}</a></th>
			<th>${item.id}</th>
			<th>
			<fmt:formatDate value="${item.indate}" type="date"/></th>
			<th>${item.click}</th>
			<th><input type="checkbox" id="qseq" name="qseq" value="${item.qseq}"/></th>
			</tr>
			</c:forEach>
			</c:otherwise>
			</c:choose>
			<th colspan="6"><a href="#" onclick="f_delete()"><h4 style="text-align: right;">삭제하기</h4></a></th>
			<tr><td colspan="6" style="text-align: center;"> ${paging} </td></tr>
			</tbody>
		</table>
		<hr/>
	</div>
	</form>
<script src="http://code.jquery.com/jquery-latest.js"></script>
 <script src="js/bootstrap.min.js"></script>
</body>
</html>