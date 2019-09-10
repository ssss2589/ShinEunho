<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@page isELIgnored="false"%>         
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<aside id="hj_sideForm">
	<div id="hj_side_login">
	<c:choose>
		<c:when test="${loginUser == null}">
			<jsp:include page="loginForm.jsp"/>
		</c:when>
		<c:otherwise>
			<jsp:include page="memberForm.jsp"/>
		</c:otherwise>
	</c:choose>
	</div>
</aside>
</html>