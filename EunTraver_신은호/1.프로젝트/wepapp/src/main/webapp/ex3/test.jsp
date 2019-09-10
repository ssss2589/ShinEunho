<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>about:blank
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta http-equiv="Refresh" content="0;url=/wepapp/ex3/ex3.html">
<%String msg = (String)request.getAttribute("msg");
	String id = request.getParameter("id");%>
<script type="text/javascript">
	var eun=window.open('','','width=500, height=400');
</script>
</head>
<body>
<% if(msg.equals("존재")){ %>
	<script type="text/javascript">
	eun.document.write("<h4>사용중인 아이디입니다.</h4>");
	</script>
<%}else{%>
	<script type="text/javascript">
	eun.document.write("사용가능한 아이디입니다.");
	</script>
<%}%>
</body>
</html>