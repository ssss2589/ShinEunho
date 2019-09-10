<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.nonage.dto.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ include file="../Header.jsp" %> 
	<%@ include file="sub_img.html" %> 
	<%@ include file="sub_menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function go_cart_delete(){
		/*var values = document.getElementsByName("cseq");
		for(var i=0;i<values.length;i++){
				if(values[i].checked == true){
					formm.action="NonageServlet?command=cart_delete";
					formm.submit();
				}
		}*/
		var count = 0;
		var values = document.getElementsByName("cseq");
		/* if(values.length==undefined){
			if( ){
				count++;
			}
		} */
		for(var i=0;i<values.length;i++){
				if(values[i].checked){
					count++;
				}
		}
		if(count==0){
			alert("삭제할 항목을 선택해주세요");
		}else{
			formm.action="NonageServlet?command=cart_delete";
			formm.submit();
		}
		
	}
	function go_order_insert(){
		formm.action="NonageServlet?command=order_insert";
		formm.submit();
	}

</script>
<link rel="stylesheet" href="css/shopping.css">
</head>
<body>
<article>
<h2>Cart List</h2>
<form name="formm" method="post">
<c:choose>
<c:when test= "${cartList.size()==0}">
	<h3 style="color:red; text-align:center;">장바구니가 비었습니다.</h3>
	</c:when>s
	<c:otherwise>
		<table id="cartList">
		<tr>
		 <th>상품명</th><th>수량</th><th>가격</th><th>주문일</th><th>삭제</th>
		</tr>
		<c:forEach items="${cartList}" var="cartVO">
		<tr>
		<td>
		<a href="NonageServlet?command=prduct_detail&pseq=${cartVO.pseq}">
			<h3>${cartVO.pname }</h3>
		</a>
		</td>
		<td>${cartVO.quantity}</td>
		<td>
		<fmt:formatNumber value="${cartVO.price2 * cartVO.quantity}"
			type="currency"/>
		</td>
		<td>
			<fmt:formatDate value="${cartVO.indate}"  type="date"/> 
		</td>
		<td>
			<input type="checkbox" id="cseq" name="cseq" value="${cartVO.cseq}"/>		</td>
		</tr>
		</c:forEach>
		<tr>
			<th colspan=2">총액</th>
			<th colspan=2">
			<fmt:formatNumber value="${totalPrice}" type="currency" /><br>
			</th>
			<th><a href="#" onclick="go_cart_delete()"><h3>삭제하기</h3></a></th>
		</tr>
		</table>
		</c:otherwise>
		</c:choose>
		<div class="clear"></div>
		<div id="buttons" style="float:right">>
			<input type="button" value="쇼핑 계속하기" class="cancel"
				onclick="location.href='NonageServlet?command= index'">
			<c:if test = "${cartList.size() !=0}">
			<input type="button" value= "주문하기" class="submit"
			onclick="go_order_insert()">
			</c:if>
		</div>
		</fome>

</article>


</body>
</html>