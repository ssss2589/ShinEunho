<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.nonage.dto.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
	<%@ include file="../Header.jsp" %> 
	<%@ include file="sub_img.html" %> 
	<%@ include file="sub_menu.html" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function go_cart(){
		if(document.formm.quantity.value ==""){
			alert("수량을 입력하여 주세요.");
			document.formm.quantity.focus();
		}else{
			document.formm.action ="NonageServlet?command=cart_insert";
			document.formm.submit();
		}
	}
</script>
<link rel="stylesheet" href="css/shopping.css">
</head>
<body>
<article>
	<h1>Item</h1>
	<div id="itemdetail">
		<form method="post" name="formm">
		<fieldset>
			<a href="NonageServelet?command=product_detail&pseq=${pro.pseq}">
				<span>
					<img src="product_images/${pro.image}"/>
				</span>
				<h2>${pro.name}</h2>
				</a>
				<label>가격:</label>
				<p>${pro.price2}원</p>
				<label>수량</label>
				<input type="text" name="quantity" size="2" value="1"><br>
				<input type="hidden" name="pseq" value="${pro.pseq}"><br>
		</fieldset>
		
		<div class="clear"></div>
		<div id="buttons">
			<input type="button" value="장바구니에 담기" class="submit" onclick="go_cart()">
			<input type="button" value="즉시구매" class="submit" onclick="go_order()">
			<input type="reset" value="취소" class="cancel">
		</div>
		</div>
		</form>
	</div>
</article>

</body>
</html>