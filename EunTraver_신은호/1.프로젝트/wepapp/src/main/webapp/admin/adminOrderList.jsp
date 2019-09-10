<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.nonage.dto.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page isELIgnored="false"%>
<%@ include file="sub_menu.jsp" %>
<%@ include file="Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function go_search(){
	var id=formm.id.value;
	formm.action="NonageServlet?command=admin_orderList&id="+id;
	formm.submit();
}
function go_result(){
	var count=0;
	if(document.formm.result.length == undefined){
		if(document.formm.result.checked == true){
			count++;
		}
	}else{
		for(var i=0;i<document.formm.result.length;i++){
			if(document.formm.result[i].checked == true){
				count++;
			}
		}
	}
	if(count==0){
		alert("체크된 항목이 없습니다.");
	}else{
		formm.action="NonageServlet?command=admin_ResultSet";
		formm.submit();
	}
}
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/wepapp/gheTeam/css/shopping.css">
</head>
<body>
<article>
<form name="formm" method="post">
<table>
		<tr>
		<td width="642">
		주문자 이름
		<input type="text" name="id">
		<input class="btn" name="btn_search" type="button" value="검색" onclick="go_search()">

		</td>
		</tr>
	</table>
	<table id="cartList">	
		<tr>
		 <th>주문번호(처리여부)</th><th>주문자</th><th>상품명</th><th>수량</th><th>우편번호</th><th>배송지</th>
		 <th>전화</th><th>주문일</th>
		</tr>
		<c:choose>
		<c:when test="${orderlistsize<=0}">
		<tr>
			<td width="100%" colspan='7' align="center" height="23">
			등록된 상품이 없습니다.
			</td>
		</tr>
		</c:when>
		<c:otherwise>
		<c:forEach items="${orderlist}" var="itemVO">
		<tr>
		<td height="23" align="center">
		<c:choose>
		<c:when test="${itemVO.result=='1'}">
		<span style="font-weight: bold; color:blue;">${itemVO.odseq}</span>
		(<input type="checkbox" name="result" value="${itemVO.odseq}">) 미처리
		</c:when>
		<c:otherwise>
		<span style="font-weight: bold; color:red;">${itemVO.odseq}</span>
		(<input type="checkbox" checked="checked" value="${item.odseq}" disabled=true>) 처리완료
		</c:otherwise>
		</c:choose>
		</td>
		<td>${itemVO.id}</td>
		<td>${itemVO.pname}</td>
		<td>${itemVO.quantity}</td>
		<td>${itemVO.zipNum}</td>
		<td>${itemVO.address}</td>
		<td>${itemVO.phone}</td>
		<td><fmt:formatDate value="${itemVO.indate}" /> </td>
		</tr>
		</c:forEach>
		</table>
			<input type="button" class="btn" name="order" value="주문처리" onclick="go_result()"
			style="margin-left: 300px;">
		</c:otherwise>
		</c:choose>
	</article>
</body>
</html>