<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../Header.jsp"%>
<%@ include file="sub_img.html"%>
<%@ include file="sub_menu.html"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="join" action="NonageServlet?command=loginMember" method="post"
		name="formm">
			<legend>로그인</legend>
			아이디
			<input type="text" name="id" size="12">
			비밀번호
			<input type="password" name="pwd"><br>
			<div id="buttons">
			<input type="submit" value="로그인" class="submit">
			<input type="reset" value="취소" class="cancel">
		</div>

	</form>
</body>
</html>