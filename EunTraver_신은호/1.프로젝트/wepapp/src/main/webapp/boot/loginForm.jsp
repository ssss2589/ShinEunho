<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, project.*"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<link href="/wepapp/boot/css/bootstrap.min.css" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="/wepapp/boot/css/bootstrap-responsive.css" rel="stylesheet">
<link rel="stylesheet" href="/wepapp/boot/css/E.css">
<meta charset="UTF-8">
<title>Eun travel</title>
<script type="text/javascript">
function login(){
	 if(formm.id.value.length == 0){
		 alert("아이디를 입력해주세요");
		 return;
	 }
	 if(formm.pw.value.length == 0){
		 alert("비밀번호를 입력해주세요");
		 return;
	 }
	formm.action="/wepapp/NonageServlet2?command=login";
	formm.submit();
}
</script>
</head>
<body>
<%@ include file="header.jsp" %>
 <article id="login">
		<form name="formm" action="" class="form" method="post">
			<table>	
				<tr>
					<td>아이디</td>
					<td><input type="text" id="text" name="id" size="12" onchange="change()" /></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pw" id="text" size="12"/></td>
				</tr>
			</table>
			<p>
			<div id="buttons">
				<input type="button" id="button" value="로그인" onclick="login()">
				<input type="button" id="button" value="취소">
			</div>
			</p>
		</form>
	</article>
 <script src="http://code.jquery.com/jquery-latest.js"></script>
        <script src="js/bootstrap.min.js"></script>
</body>
</html>