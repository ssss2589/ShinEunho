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
</head>
	<div id="hj_member">
		<table>
			<tr>
				<td> ${loginUser.nickname }</td>
			</tr>
			<tr>
				<td>등급 : ${loginUser.grade}</td>
			</tr>
			<tr>
				<td>회원정보</td><td>기타메뉴</td><td><a href="/webapp/GHEServlet?command=logout">로그아웃</a></td>
			</tr>
		</table>
	</div>
</html>