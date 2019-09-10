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
	formm.action="/wepapp/NonageServlet2?command=freeDetail&qseq="+qseq;
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
<h2>자유 게시판</h2>
<form name="formm" method="post">
		<span><b>제목: </b> ${index.subject}</span><br>
		<span><b>축제날짜: </b> ${index.indate}</span><br>
		<span><b>내용: </b> ${index.content}</span><br>
		<span><b>사이트: </b> ${index.site}</span><br>
		<c:if test="${index.image ne null}">
		<img src="product_images/${index.image}"/>
		</tr>
		</c:if>
		<div class="clear"></div>
			<input type="button" value="목록보기" class="check" style="text-align: left;"
				onclick="location.href='NonageServlet2?command=IndexAdmin'">
		</div>
		</form>
</article>
<script src="http://code.jquery.com/jquery-latest.js"></script>
 <script src="js/bootstrap.min.js"></script>
</body>
</html>