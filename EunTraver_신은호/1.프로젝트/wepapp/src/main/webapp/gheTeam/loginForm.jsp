<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@page isELIgnored="false"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
  function login(){
	 if(formm.id.value.length == 0){
		 alert("아이디를 입력해주세요");
		 return;
	 }else if(formm.pw.value.length == 0){
		 alert("비밀번호를 입력해주세요");
		 return;
	 }
	 formm.submit();
  }

</script>

</head>

	<div id="hj_login">
		<form action="/wepapp/GHEServlet?command=login" method="post" name="formm">
		<table>	
			<tr>
				<td>ID</td>
				<td><input type="text" size="12" name="id"/></td>
				<td rowspan="2" id="d"><input type="button" style="width: 80pt; height: 40pt; color: white; background-color: #60e1ec; border: none;" id="hj_login_button" value="로그인" onclick="login()"/></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><input type="password" size="13" name="pw"/></td>
			</tr>
		<c:if test="${loginFail != null}"><tr> <td colspan="3"><p style="color: red; text-align: center; font-size: 15px; text-align: center; margin-top:0px;margin-bottom: 0px;" >아이디 또는 비밀번호가 틀립니다.</p></td></tr> </c:if>
		</table>
		<label>아이디 찾기/</label>
		<label>비밀번호 찾기/</label>
		<label>회원가입</label>
		</form>
	</div>
</html>