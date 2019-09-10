<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.nonage.dto.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script language="javascript"> 
function login() { 
if(formm.id.length==0){
	alert("아이디를 입력해주세요.");
	return;
}
if(formm.pwd.length==0){
	alert("비밀번호를 입력해주세요.");
	return;
}
formm.action="/wepapp/NonageServlet2?command=adminLogin";
formm.submit();
}
</script> 

<style type="text/css">
.form {
  background: #FFFFFF;
  width: 600px;
  box-shadow: 0 0 30px rgba(0, 0, 0, 0.1);
  margin: 100px auto 10px;
  overflow: hidden;
}
.button {
  background: #4285F4;
  width: 100%;
  border: 0;
  border-radius: 4px;
  padding: 12px;
  cursor: pointer;
}
</style>
</head>
<body>
<form id="form" method="post"
		name="formm">
			<div style="text-align: center;">
			<table style="margin-left: auto;margin-right:auto; ">
			<th colspan="2"><h3>관리자님 로그인해주세요!</h3></th>
			<tr>
			<th>아이디</th>
			<td><input type="text" name="id"></td>
			</tr>
			<tr>
			<th>비밀번호</th>
			<td><input type="password" name="pwd"><br></td>
			</table>
			<div id="buttons">
			<input type="button" value="업무 로그인" class="button" onclick="login()" style="background-color:yellow">
		</div>
	</form>
</body>
</html>