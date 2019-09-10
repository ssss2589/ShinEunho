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
function zipcheck(){
	window.open("/wepapp/boot/findZipNum2.jsp",'chiled','width=500, height=400');
}
function mem_reset(){
	alert("다시 로그인 해주세요.");
	formm.action="/wepapp/NonageServlet2?command=MemReset";
	formm.submit();
}
function mem_delete(){
	formm.action="/wepapp/NonageServlet2?command=Member_Delete";
	formm.submit();
}
function join(){
	 if(formm.pw.value.length == 0){
		 alert("비밀번호를 입력해주세요");
		 return;
	 }
	 if(formm.name.value.length == 0){
		 alert("이름을 입력해주세요");
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
}
</script>
</head>
<body>
<%@ include file="header.jsp" %>
<article>
		<form name="formm" action="" class="form" method="post">
			<table>	
				<tr>
					<td>아이디</td>
					<td><input type="text" id="text" name="id" size="12" onchange="change()"
					value="${mem.id }" readonly="readonly"/></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pw" id="text" size="12" value="${mem.pwd }"/></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" id="text" name="name" size="12" value="${mem.name}" readonly="readonly"/></td>
				</tr>
				
				<tr>
					<td>이메일</td>
					<td><input type="text" id="text" name="email" size="12" onchange="echange()" value="${mem.email}" readonly="readonly"/></td>
				</tr>
				<tr>
					<td>우편번호</td>
					<td><input type="text" id="text" name="zipNum" size="12" onchange="zchange()" value="${mem.zipNum}"/></td>
					<td><input type="button" class="check" value="주소찾기" onclick="zipcheck()"></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" id="text" name="address" value="${mem.address}"/></td>
				</tr>
				<tr>
					<td>핸드폰</td>
					<td><input type="text" id="text" name="phone" value="${mem.phone}"/></td>
				</tr>
			</table>
			<p>
			<div id="buttons">
				<input type="button" id="button" value="정보변경" onclick="mem_reset()">
				<input type="button" id="button" value="탈퇴" onclick="mem_delete()">
				<input type="reset" id="button" value="취소">
			</div>
			</p>
		</form>
	</article>
 <script src="http://code.jquery.com/jquery-latest.js"></script>
        <script src="js/bootstrap.min.js"></script>
</body>
</html>