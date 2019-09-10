<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="study.EunStyle"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<div
	style="background-color: #00008b; color: #ffffff; height: 20px; padding: 5px;">
	MemberSystem Header Page
	<c:choose>
	<c:when test="${eun != null}">

	<span style="float: right;"> ${eun.id} <a
		style="color: white;"
		href="<%=request.getContextPath()%>/LogoutServlet">로그아웃</a> <!-- getContextPath:wepapp를 의미 -->
	</span>
	</c:when>
	<c:otherwise>
	<script>
		location.href = "/wepapp/jspEx/loginForm.jsp";
	</script>
	</c:otherwise>
	</c:choose>
</div>
