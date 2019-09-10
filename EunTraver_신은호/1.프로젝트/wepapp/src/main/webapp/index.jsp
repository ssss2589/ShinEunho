<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.nonage.dto.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nonage Shop</title>
<link rel="stylesheet" href="css/index.css">
</head>
<body>
	<div id="wrap">
	<%@ include file="../Header.jsp" %> 
		<section>
			<div>
				<img class="main" alt="메인사진" src="images/main_img_s.jpg">
			</div>
			<hr />
			<article>
				<div>
					<p class="newproduct">신상품</p>
				</div>
			</article>
			<hr />
			<article class="new_item">
				<c:forEach items="${newProductList}" var="item">
					<div id="new">
						<img style="width: 200px; height: 200px;" alt="new"
							src="product_images/${item.image}">
						<h2>${item.name}</h2>
						<h2>${item.price2}</h2>
					</div>
				</c:forEach>
			</article>
			
			<article>
				<div>
					<p class="newproduct">베스트 상품</p>
				</div>
			</article>
			<hr />
			<article class="new_item">
				<c:forEach items="${bestProductList}" var="item">
					<div id="new">
						<img style="width: 200px; height: 200px;" alt="new"
							src="product_images/${item.image}">
						<h2>${item.name}</h2>
						<h2>${item.price2}</h2>
					</div>
				</c:forEach>
			</article>
		</section>
		<%@ include file="../footer.jsp" %>   
	</div>
</body>
</html>