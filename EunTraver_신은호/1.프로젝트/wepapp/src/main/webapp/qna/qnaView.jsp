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
<h2>1:1 고객 게시판</h2>
<form name="formm" method="post">
		<h4>고객님의 질문에 대해서 운영자가 1:1 답변을 드립니다.</h4>
		<table>
		<tr>
		<th>제목 </th><td>${qna.subject}</td>
		</tr>
		<tr>
		<th>등록일</th><td><fmt:formatDate value="${qna.indate}" type="date"/></td>
		</tr>
		<tr>
		<th>질문내용</th><td>${qna.content}</td>
		</tr>
		<tr>
		<th>답변내용</th><td>${qna.reply}</td>
		</tr>
		</table>
		<div class="clear"></div>
		<div id="buttons" style="float:right">
			<input type="button" value="확인" class="cancel"
				onclick="qna_write()">
			<input type="button" value="목록보기" class="submit"
				onclick="location.href='NonageServlet?command=qna_list'">
		</div>
		</fome>
</article>
</body>
</html>