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
function correction(){
	if(formm.subject.length==0){
		alert("제목을 입력해주세요");
		return;
	}
	formm.action="/wepapp/NonageServlet2?command=free_correction";
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
<%@ include file="header.jsp" %>
<article>
<h2>수정하기</h2>
<form name="formm" method="post" enctype="multipart/form-data">
		<span><b>제목</b> <input type="text" value="${free.subject}" name="subject" ></span><br>
		<table>
		<tr>
		<th>내용</th>
		</tr>
		<c:if test="${free.image ne null}">
		<tr>
		<td colspan="4">
		<img src="product_images/${free.image}"/></td>
		</tr>
		</c:if>
		<tr>
		<td><input type="text" value="${free.content}" name="content" style=" width:1000px; height:500px;" ></td>
		</tr>
		<tr>
		    <td>첨부 파일 변경<input type="text" value="${free.image}" name="myimage" readonly="readonly"></td>
		</tr>
		<tr>
		    <td><input type="file" name="image" /></td>
		</tr>
		</table>
		<input type="hidden" name="qseq" value="${free.qseq }">
		<div class="clear"></div>
			<input type="button" value="확인" class="check" style="text-align: left;"
				onclick="correction()">
				<input type="reset" value="취소" class="check" style="text-align: left;">
		</div>
		</form>
</article>
<script src="http://code.jquery.com/jquery-latest.js"></script>
 <script src="js/bootstrap.min.js"></script>
</body>
</html>