<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function join(){
	form.action="join.jsp"
	form.submit();
}
</script>
<style type="text/css">
h1{
	font: 50px "판타지", Fantasy;
}
form{
	line-height: 16px;
	margin-right :auto;
	margin-left:auto;
	text-align: center;
}
table{
	margin-right :auto;
	margin-left:auto;
	text-align: center;
}
</style>
</head>
<body>
<form action="/wepapp/loginServlet" name="form">
	<h1 align="center" style="color: blue;">Eum</h1>
	<fieldset>
	<table>
		<tr>
			<td>
			<h3>아이디</h3>
			</td>		
		</tr>
		<tr>
			<td align="center">
			<input type="text" name="id" maxlength="10" required autofocus/>
			</td>
		</tr>
		<tr>
			<td>
			<h3>비밀번호</h3>
			</td>
		</tr>
		<tr>
			<td>
			<input type="password" name="pw" required />
			</td>
		</tr>
						
	</table>
	</fieldset>	
	<input type = "submit" value = "확인" >
	<input type = "reset" value ="취소">
	<input type = "button" value = "회원가입" onclick="join()">
	</form>
</body>
</html>