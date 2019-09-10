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
function comment(){
	var qseq=formm.qseq.value;
	formm.action="/wepapp/NonageServlet2?command=admin_Qna_Reply&qseq="+qseq;
	formm.submit();
}
</script>
<style type="text/css">
   th{
    text-align: left;
    }
   
</style>
</head>
<body>
<%@ include file="Aheader.jsp" %>
<article>
<h2>1:1 고객문의</h2>
<form name="formm" method="post">
		<span><b>제목</b> ${Qna.subject}</span><br>
		<span><b>등록일</b> <fmt:formatDate value="${Qna.indate}" pattern="yy.MM.dd  hh시mm분"/></span>
		<table>
		<tr>
		<th>내용</th>
		</tr>
		<c:if test="${Qna.image ne null}">
		<tr>
		<td colspan="4">
		<img src="product_images/${Qna.image}"/></td>
		</tr>
		</c:if>
		<tr>
		<td>${Qna.content}</td>
		</tr>
		<br/>
		<tr>
		<td><h3 style="color: green;">관리자 답글</h3></td>
		</tr>
		<c:choose>
		<c:when test="${Qna.rep==1 }">
		<td><input class="input-xxlarge" type="text" name="commend" placeholder="글을 입력해주세요.">
		<input class="check" type="button" onclick="comment()"value="등록"></td>
			<input type="hidden" value="${Qna.qseq}" name="qseq">
		</c:when>
		<c:otherwise>
		<tr>
		<td><h3>${Qna.reply}</h3></td>
		</tr>
		</c:otherwise>
		</c:choose>
		</table>
		<div class="clear"></div>
			<input type="button" value="목록보기" class="check" style="text-align: left;"
				onclick="location.href='NonageServlet2?command=admin_inquiry'">
		</div>
		</form>
</article>
<script src="http://code.jquery.com/jquery-latest.js"></script>
 <script src="js/bootstrap.min.js"></script>
</body>
</html>