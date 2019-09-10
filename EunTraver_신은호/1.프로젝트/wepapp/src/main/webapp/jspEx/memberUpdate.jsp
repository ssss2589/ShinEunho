<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="study.EunStyle"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보변경</title>
<script type="text/javascript">
	function inputClieked(obj){
		if(obj.pw.value==""){
			alert("바꿀 비밀번호를 입력해주세요.");
			form.pw.focus(); 
		}else{
			obj.action="/wepapp/MemberServletUpdate2";
			obj.submit();
		}
	}
</script>
</head>
<body>
	<h1>정보변경</h1>
	<form action='' name="form">
		이름 : <input type='text' name='name' value="${eun.id}" readonly> <br /> 
			아이디 : <input type='text' name='id' value="${eun.name}" readonly> <br /> 
			암호 : <input type='password' name='pw'> <br /> 
			성별 : <input type='text' name='sex' value="${eun.sex}" readonly> <br /> 
			주민번호 : <input type='text' name='rrn' value="${eun.rrn}" readonly> <br /> 
			이메일 : <input type='text' name='email' value="${eun.email}" readonly> <br /> 
			휴대전화 : <input type='text' name='phone' value="${eun.phone}" readonly> <br /> <input
			type='button' value='확인' onclick="inputClieked(this.form)"> <input type='reset' value='취소'>
		<input type='button' value='삭제'
			onclick='location.href="/wepapp/MemberServletDelete?id=${eun.id}"'>
	</form>
</body>
</html>