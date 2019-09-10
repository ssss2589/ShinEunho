<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function inputChecked(obj){
		if(obj.id.value==""){
			alert("아이디를 입력해주세요.");
			form.id.focus();
		}else if(obj.password.value==""){
			alert("비밀번호를 입력해주세요.");
			form.password.focus();
		}else{
			obj.action="/wepapp/LoginServletEx";
			obj.submit();
		}
	}
</script>
</head>
<body>
	<h1>로그인</h1>
	<form action="" method='post' name="form">
		아이디 : <input type='text' name='id'><br>
		암호 : <input type='password' name='password'><br>
		<input type="button" value='로그인' onclick="inputChecked(this.form)"/>
		<input type="reset" value='취소'>
	</form>
	<jsp:include page="Tail.jsp" />
</body>
</html>