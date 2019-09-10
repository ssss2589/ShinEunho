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
<script type="text/javascript">
function qna_write(){
	formm.action="NonageServlet?command=admin_QnaWrite";
	formm.submit();
}
</script>
</head>
<body>
<article>
<h2>Q&A 게시판</h2>
<form name="formm" method="post">
		<table>
		<tr>
		<th>제목 </th><td><input type="text" value="${qna.subject}" name="subject" readonly="readonly"></td>
		<tr>
		<th>등록일</th><td><fmt:formatDate value="${qna.indate}" type="date"/></td>
		</tr>
		<tr>
		<th>질문내용</th><td>${qna.content}</td>
		</tr>
		<tr>
		<c:choose>
		<c:when test="${qna.rep==2}">
		<th>답변내용</th><td>${qna.reply}</td>
		</tr>
		</table>
		<div class="clear"></div>
		<div id="buttons" style="float:right">
		<input type="button" value="목록보기" class="submit"
				onclick="location.href='NonageServlet?command=admin_qnaList'">
		</div>
		</c:when>
		<c:otherwise>
		<th>답변등록</th><td><input type="text" name="reply"></td>	
		</tr>
		</table>
		<div class="clear"></div>
		<div id="buttons" style="float:right">
		<input type="button" value="확인" class="cancel"
				onclick="qna_write()">
		<input type="button" value="목록보기" class="submit"
			onclick="location.href='NonageServlet?command=admin_qnaList'">
		</div>				
		</c:otherwise>
		</c:choose>
		</fome>
</article>
</body>
</html>