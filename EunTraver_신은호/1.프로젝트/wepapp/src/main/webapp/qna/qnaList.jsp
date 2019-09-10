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
function qna_delete(){
	var count =0;
	var values= document.getElementsByName("qseq");
	
	for(var i=0;i<values.length;i++){
		if(values[i].checked){
		count++;
		}
	}
	if(count==0){
		alert("삭제할 항목을 선택해주세요.")
	}else{
		formm.action="NonageServlet?command=qna_delete";
		formm.submit();
	}
}
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<article>
<h2>1:1 고객 게시판</h2>
<form name="formm" action="NonageServlet?command=qna_write_form" method="post">
		<h4>고객님의 질문에 대해서 운영자가 1:1 답변을 드립니다.</h4>
		<table id="cartList">
		<tr>
		 <th>번호</th><th>제목</th><th>등록일</th><th>답변 여부</th><th>삭제</th>
		</tr>
		<c:forEach items="${qnaList}" var="qnaVO">
		<tr>
		<td>
			${qnaVO.qseq}
		</td>
		<td><a href="NonageServlet?command=qna_view&qseq=${qnaVO.qseq}">${qnaVO.subject}</a></td>
		<td><fmt:formatDate value="${qnaVO.indate}" type="date"/></td>
		<td>
		<c:choose>
		<c:when test="${qnaVO.rep==1}">NO</c:when>
		<c:when test="${qnaVO.rep==2}">YES</c:when>
		</c:choose>
		</td>
		<td><input type="checkbox" id="qseq" name="qseq" value="${qnaVO.qseq}"/></td>
		</tr>
		</c:forEach>
		<tr>
		<th colspan="4"></th>
		<th><a href="#" onclick="qna_delete()"><h3>삭제하기</h3></a></th>
		</tr>
		</table>
		<div class="clear"></div>
		<div id="buttons" style="float:right">
			<input type="submit" value="1:1질문하기" class="submit">
			<input type="button" value="쇼핑 계속하기" class="cancel"
				onclick="location.href='NonageServlet?command=index'">
		</div>
		</form>
</article>
</body>
</html>