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
<form name="formm" method="post">
		<span><b>아이디: </b> ${mem.id}</span><br>
		<span><b>비밀번호: </b> ${mem.pwd}</span><br>
		<span><b>이름: </b> ${mem.name}</span><br>
		<span><b>이메일: </b> ${mem.email}</span><br>
		<span><b>주소: </b>(${mem.zipNum}) ${mem.address}</span><br>
		<span><b>핸드폰: </b> ${mem.phone}</span><br>
		<span><b>가입날짜: </b> ${mem.indate}</span>
		<div class="clear"></div>
			<input type="button" value="목록보기" class="check" style="text-align: left;"
				onclick="location.href='NonageServlet2?command=admin_Member'">
		</div>
		</form>
</article>
 <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>