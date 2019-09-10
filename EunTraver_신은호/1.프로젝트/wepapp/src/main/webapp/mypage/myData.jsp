<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../Header.jsp"%>
<%@ include file="sub_img.html"%>
<%@ include file="sub_menu.jsp"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<link rel="stylesheet" href="css/shopping.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function Delete(){
	formm.action="NonageServlet?command=MemberDelete";
	formm.submit();
}
</script>
</head>
<body>
<article>
<form id="join" action="" method="post" name="formm">
			<div style="text-align: center;">
			<fieldset>
			<legend>나의 정보</legend>
			아이디<input type="text" name="id" size="12" value="${loginUser.id}" readonly="readonly"><br>
			비밀번호<input type="password" name="pwd" value="${loginUser.pwd}"><br>
			이름<input type="text" name="name" value="${loginUser.name}" readonly><br> 
			이메일<input type="text" name="email" value="${loginUser.email}"><br>
			우편번호<input type="text" name="zipNum" size="12" value="${loginUser.zipNum}">
			<input type="button" value="주소 찾기" class="dup" onclick="post_zip()"><br>
			주소<input type="text" name="addr1" value="${loginUser.address}"><br>
			전화번호<input type="text" name="phone" value="${loginUser.phone}"><br>
		</fieldset>
		<div class="clear"></div>
		<div id="buttons">
			<input type="button" value="정보수정" class="submit" onclick="">
			<input type="reset" value="취소" class="cancel">
			<input type="button" value="탈퇴" class="submit" onclick="Delete()">
		</div>
	</form>
	</article>
</body>
</html>