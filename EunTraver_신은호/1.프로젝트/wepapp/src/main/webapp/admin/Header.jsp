<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function logout(){
	form.action="/wepapp/NonageServlet?command=adminLogout";
	form.submit();
}
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="form" action="" method="post">
	<input type="button" onclick="logout()" value="로그아웃">
	</form>
</body>
</html>