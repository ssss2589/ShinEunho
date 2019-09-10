<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p><a href="jstl07.jsp">[이전]</a><a href="jstl09.jsp">[다음]</a>
	<h2>계산기</h2>
	<form action="/webapp/CalculatorServlet2">
	<input type="text" name="v1">
	<input type="checkbox" value="+" name="op">
	<input type="text" name=v2>
	<input type="submit" value="계산하기">
	<p><a href="jstl07.jsp">[이전]</a><a href="jstl09.jsp">[다음]</a>
</form>
</body>
</html>