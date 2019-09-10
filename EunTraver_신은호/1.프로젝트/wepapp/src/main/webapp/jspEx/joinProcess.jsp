<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<b>
<%
	System.out.println((String)request.getAttribute("msg"));
	String msg = (String)request.getAttribute("msg");
%>
<%=msg %>
</b>
<a href='/wepapp/MemberListServlet'> 목록보기 </a><!-- 링크는 get으로 가는 특성이 있음 -->
</body>
</html>