<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function back(){
		form.action="login.jsp"
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
<body >
	<form action="/wepapp/joinServlet" name="form">
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
			<input type="text" name="id" maxlength="10"
			pattern="^[a-z0-9]*$" title="소문자 또는 숫자만 가능(10자까지)" required autofocus/>
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
		<tr>
			<td>
			<h3>비밀번호 재확인</h3>
			</td>
		</tr>
		<tr>
			<td>
			<input type="password" name="pw_check" required />
			</td>
		</tr>
		<tr>
			<td>
			<h3>이름</h3>
			</td>
		</tr>
		<tr>
			<td>
			<input type="text" name="name" required />
			</td>
		</tr>
		<tr>
			<td>
			<h3>생년월일</h3>
			</td>
		</tr>
		<tr>
			<td>
				<input type="date" name="securit"min="1930-01-01" max="2019-12-12" required />
			</td>
		</tr>
		<tr>
			<td>
			<h3>성별</h3>
			</td>
		</tr>
		<tr>
			<td>
				<input type="radio" name="sex" value="남자" required />남자
				<input type="radio" name="sex" value="여자" required />여자
				<input type="radio" name="sex" value="선택안함" required />선택안함
			</td>
		</tr>
		<tr>
			<td>
			<h3>이메일</h3>
			</td>
		</tr>
		<tr>
			<td>
				<input type="text" name="email" required>
			</td>
		</tr>
		
						
	</table>
	<input type = "submit" value = "확인" >
	<input type = "button" value ="돌아가기" onclick="back()">
	</fieldset>	
	</form>
	
</body>
</html>