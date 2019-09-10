<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.nonage.dto.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/shopping.css">
</head>
<body>
	<%@ include file="../Header.jsp" %> 
	<%@ include file="sub_img.html" %> 
	<%@ include file="sub_menu.html" %> 
	<article>
		<c:forEach items="${productKindList}" var="item">
					<div id="item">
						<a href="NonageServlet?command=detail&pseq=${item.pseq} "><img style="width: 200px; height: 200px;" alt="new"
							src="product_images/${item.image}">
							
						<h2>${item.name}</h2>
						<h2>${item.price2}</h2></a>
					</div>
				</c:forEach>]
	</article>
</body>
</html>