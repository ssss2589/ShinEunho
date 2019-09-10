<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.ArrayList" %>
    <%@page import="study.EunStyle" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transirional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>회원목록</title>
</head>
<body>

	<jsp:include page="Header.jsp" />
	<h1>회원목록</h1>
	<p><a href="/wepapp/MemberAddServlet">신규회원</a></p>	
	<c:forEach var ="ho" items="${euns}">
		이름:${ho.name},
		아이디:<a href="/wepapp/MemberServletUpdate?id=${ho.id}">${ho.id}</a>
		비밀번호:${ho.pw},
		성별:${ho.sex},
		주민번호:${ho.rrn},
		이메일:${ho.email},
		휴대전화:${ho.phone}<br>
		</c:forEach>
	<jsp:include page="Tail.jsp" />
</body>
</html>