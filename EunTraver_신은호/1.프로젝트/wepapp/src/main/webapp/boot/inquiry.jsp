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
function in_delete(){
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
		formm.action="/wepapp/NonageServlet2?command=in_delete"
		formm.submit();
	}
}
</script>
</head>
<body>
<%@ include file="header.jsp" %>
<h2>1:1 고객 게시판</h2>
	<form name="formm" method="post">
	<h4>고객님의 질문에 대해서 운영자가 1:1 답변을 드립니다.</h4>
	<div class="container">
		<table class="table table-striped">
			<c:choose>
			<c:when test="${size==0}">
			<h3>등록된 문의가 없습니다.</h3>
			</c:when>
			<c:otherwise>
			<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>날짜</th>
				<th>삭제</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${qnaList}" var="qna">
			<tr>
			<th>${qna.qseq}</th>
			<th><a href="NonageServlet2?command=inquiryDetail&qseq=${qna.qseq}">${qna.subject}</a></th>
			<th>${qna.id}</th>
			<th>
			<fmt:formatDate value="${qna.indate}" type="date"/></th>
			<td><input type="checkbox" id="qseq" name="qseq" value="${qna.qseq}"/></td>
			</tr>
			</c:forEach>
			</c:otherwise>
			</c:choose>
			<tr>
			<th colspan="5"><a href="#" onclick="in_delete()"><h4 style="text-align: right;">삭제하기</h4></a></th></tr>
			<tr><th colspan="5"><a class="btn btn-default pull-right" href="boot/inquiryWirte.jsp">글쓰기</a></th></tr>
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