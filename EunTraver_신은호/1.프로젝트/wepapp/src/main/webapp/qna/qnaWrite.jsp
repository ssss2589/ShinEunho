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
<script type="text/javascript">
function qna_write(){
	var title=document.formm
	formm.action="NonageServlet?command=qna_write"
	formm.submit();
}

</script>
<style type="text/css">
	#sub{
		 width:1000px;
 		 height:500px;
	}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<article>
<h2>1:1 고객 게시판</h2>
<form name="formm" method="post">
		<h4>고객님의 질문에 대해서 운영자가 1:1 답변을 드립니다.</h4>
		<h2>제목 <input type="text" name="title"></h2>
		<h2>내용</h2> <input id="sub" type="text" name="body">
		<div class="clear"></div>
		<div id="buttons" style="float:right">
			<input type="button" value="확인" class="cancel"
				onclick="qna_write()">
			<input type="reset" value="취소" class="cancle">
			<input type="button" value="전페이지로가기" class="submit"
				onclick="location.href='NonageServlet?command=qna_list'">
		</div>
		</fome>
</article>
</body>
</html>