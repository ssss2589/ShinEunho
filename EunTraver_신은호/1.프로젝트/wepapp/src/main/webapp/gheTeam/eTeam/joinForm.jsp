<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function idcheck(){
	var id=formm.id.value;
	window.open("idcheck.jsp?id="+id,'chiled','width=300, height=200');
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
	 if(formm.nickname.value.length == 0){
		 alert("닉네임을 입력해주세요");
		 return;
	 }
	 if(formm.namechecked.value != 1){
			alert("아이디 중복확인을 해주세요");
			return;
		}
	formm.action="/wepapp/GHEServlet?command=join";
	formm.submit();
}
function change(){
	formm.idchecked.value = 0;
}
function nchange(){
	formm.namechecked.value = 0;
}
function namecheck(){
	var id=formm.nickname.value;
	window.open("namecheck.jsp?nickname="+id,'chiled','width=300, height=200');
}
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="/wepapp/gheTeam/css/teamH.css">
 <link rel="stylesheet" href="/wepapp/gheTeam/css/teamE.css">
</head>
<body>
	<article id="hj_join">
	<header class="search" >
	<div id="search">
		<div class="img"><a href="/wepapp/GHEServlet?command=index">
		<img alt="EZEN" src="/wepapp/Image/ezen.png">
		</a>
		</div>
		</div>
		</header>
		<form name="formm" action="" class="form" method="post">
			<input type="hidden" name="idchecked" value="0"> 
			<input type="hidden" name="namechecked" value="0">
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
					<td>닉네임</td>
					<td><input type="text" id="text" name="nickname" size="12" onchange="nchange()"/></td>
					<td><input type="button" class="check" value="중복확인" onclick="namecheck()"></td>
				</tr>
			</table>
			<p>
				<input type="button" class="button" value="회원가입" onclick="join()">
				<input type="button" class="button" value="취소">
			</p>
		</form>
	</article>
</body>
</html>