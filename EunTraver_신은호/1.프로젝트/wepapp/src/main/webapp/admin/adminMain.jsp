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
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/wepapp/gheTeam/css/shopping.css">
<script type="text/javascript">
function go_search(){
	formm.action="NonageServlet?command=Product_Search";
	formm.submit();
}
function go_total(){
	formm.action="NonageServlet?command=admin_ItemList";
	formm.submit();
}
function go_wrt(){
	//var theForm=document.frm;
	formm.action="NonageServlet?command=admin_Itemplus_form";
	formm.submit();
}

</script>
</head>
<body>
<article>
<form name="formm" method="post">
<table>
		<tr>
		<td width="642">
		상품명
		<input type="text" name="key" onkeypress="go_search()">
		<input class="btn" name="btn_search" type="button" value="검색" onclick="go_search()">
		<input class="btn" name="btn_total" type="button" value="전체보기" onclick="go_total()">
		<input class="btn" name="btn_write" type="button" value="상품등록" onclick="go_wrt()">
		</td>
		</tr>
	</table>
	<table id="cartList">	
		<tr>
		 <th>번호</th><th>상품명</th><th>원가</th><th>판매가</th><th>등록일</th><th>사용유무</th>
		</tr>
		<c:choose>
		<c:when test="${productListSize<=0}">
		<tr>
			<td width="100%" colspan='7' align="center" height="23">
			등록된 상품이 없습니다.
			</td>
		</tr>
		</c:when>
		<c:otherwise>
		<c:forEach items="${itemList}" var="itemVO">
		<tr>
		<td height="23" align="center">
			${itemVO.pseq}
		</td>
		<td style="text-align:left; padding-left: 50px; padding-right:0px;"><a href="NonageServlet?command=admin_ProductDetail&pseq=${itemVO.pseq}" >${itemVO.name}</a></td>
		<td><fmt:formatNumber value="${itemVO.price1}"/></td>
		<td><fmt:formatNumber value="${itemVO.price2}"/></td>
		<td><fmt:formatDate value="${itemVO.indate}" /> </td>
		<td>
		<c:choose>
		<c:when test="${itemVO.useyn=='y'}">사용</c:when>
		<c:when test="${itemVO.useyn=='n'}">노사용</c:when>
		</c:choose>
		</td>
		</tr>
		</c:forEach>
		<tr><td colspan="6" style="text-align: center;"> ${paging} </td></tr>
		</c:otherwise>
		</c:choose>
		</table>
		</form>
	</article>
</body>
</html>