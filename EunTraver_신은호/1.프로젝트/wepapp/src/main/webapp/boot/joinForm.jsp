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
function idcheck(){
	var id=formm.id.value;
	window.open("/wepapp/boot/idcheck.jsp?id="+id,'chiled','width=300, height=200');
}
function join(){
	 if(formm.id.value.length == 0){
		 alert("아이디를 입력해주세요");
		 return;
	 }
	 if(formm.idchecked.value != 1){
		alert("아이디 중복확인을 해주세요");
		return;
	}
	 if(formm.pw.value.length == 0){
		 alert("비밀번호를 입력해주세요");
		 return;
	 }
	 if(formm.pw_check.value.length == 0){
		 alert("비밀번호확인를 입력해주세요");
		 return;
	 }
	 if(formm.pw.value!=formm.pw_check.value){
		 alert("비밀번호가 같지않습니다.");
		 return;
	 }
	 if(formm.name.value.length == 0){
		 alert("이름을 입력해주세요");
		 return;
	 }
	 if(formm.email.value.length == 0){
		 alert("이메일을 입력해주세요");
		 return;
	 }
	 if(formm.emailchecked.value != 1){
			alert("이메일 중복확인을 해주세요");
			return;
		}
	 if(formm.zipcode.value != 1){
			alert("주소 찾기를 해주세요");
			return;
		}
	 if(formm.phone.value.length == 0){
		 alert("핸드폰번호를 입력해주세요");
		 return;
	 }
	 if(formm.address.value.length == 0){
		 alert("주소를 입력해주세요");
		 return;
	 }
	formm.action="/wepapp/NonageServlet2?command=join";
	formm.submit();
}
function change(){
	formm.idchecked.value = 0;
}
function nchange(){
	formm.namechecked.value = 0;
}
function zchange(){
	formm.zipcode.value = 0;
}
function emailcheck(){
	var id=formm.email.value;
	window.open("/wepapp/boot/namecheck.jsp?email="+id,'chiled','width=300, height=200');
}
function zipcheck(){
	window.open("/wepapp/boot/findZipNum.jsp",'chiled','width=500, height=400');
}
</script>
</head>
<body>
<%@ include file="header.jsp" %>
 <article id="hj_join">
		<form name="formm" action="" class="form" method="post">
			<input type="hidden" name="idchecked" value="0"> 
			<input type="hidden" name="emailchecked" value="0">
			<input type="hidden" name="zipcode" value="0">
			<table>	
				<tr>
					<td>아이디</td>
					<td><input type="text" id="text" name="id" size="12" onchange="change()" /></td>
					<td><input type="button" name="check" class="check" value="중복확인" onclick="idcheck()"></td>
						
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pw" id="text" size="12"/></td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td><input type="password" name="pw_check" id="text" size="12"/></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" id="text" name="name" size="12"/></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="text" id="text" name="email" size="12" onchange="echange()"/></td>
					<td><input type="button" class="check" value="중복확인" onclick="emailcheck()"></td>
				</tr>
				<tr>
					<td>우편번호</td>
					<td><input type="text" id="text" name="zipNum" size="12" onchange="zchange()"/></td>
					<td><input type="button" class="check" value="주소찾기" onclick="zipcheck()"></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" id="text" name="address"/></td>
				</tr>
				<tr>
					<td>핸드폰</td>
					<td><input type="text" id="text" name="phone"/></td>
				</tr>
			</table>
			<p>
			<div id="buttons">
				<input type="button" id="button" value="회원가입" onclick="join()">
				<input type="button" id="button" value="취소">
			</div>
			</p>
		</form>
	</article>
 <script src="http://code.jquery.com/jquery-latest.js"></script>
        <script src="js/bootstrap.min.js"></script>
</body>
</html>