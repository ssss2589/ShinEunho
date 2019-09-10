<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p><a href="jstl06.jsp">[이전]</a><a href="jstl07.jsp">[다음]</a></p>

<h2>c:forTokens 태그</h2>

<% pageContext.setAttribute("tokens","v1=20&v2=30&op=+");
%>
<ul>
	<c:forTokens var="item" items="${tokens}" delims="&">
	<li>${item}</li>
	</c:forTokens>
</ul>
<p><a href="jstl06.jsp">[이전]</a><a href="jstl07.jsp">[다음]</a></p>
</body>
</html>