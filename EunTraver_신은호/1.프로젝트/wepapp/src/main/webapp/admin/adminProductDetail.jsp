<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.nonage.dto.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<article>
		<h1>상품디테일</h1>
		<form name="formm" action="" method="post">
			<table>
				<tr>
					<td>상품분류</td>
					<td colspan="5"><select name="kind">
							<c:forEach items="${kindList}" var="kind" varStatus="status">
								<c:choose>
									<c:when test="${productVO.kind==status.count}">
										<option value="${status.count}" selected="selected">${kind}</option>
									</c:when>
									<c:otherwise>
										<option value="${status.count}">${kind}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>상품명</td>
					<td><input type="text" name="name" size="47"
						value="${pro.name}"></td>
				</tr>
				<tr>
					<td>원가(A)</td>
					<td><input type="text" name="price1" size="11"
						value="${pro.price1}"></td>
					<td>판매가(B)</td>
					<td><input type="text" name="price2" size="11"
						value="${pro.price2}"></td>
					<td>(B-A)</td>
					<td><input type="text" name="price3" size="11"
						value="${pro.price3}"></td>
				</tr>
				<tr>
					<td>베스트상품</td>
					<td><c:choose>
							<c:when test="${pro.bestyn=='y'}">
								<input type="checkbox" name="bestyn" value="y" checked="checked">
							</c:when>
							<c:otherwise>
								<input type="checkbox" name="bestyn" value="n">
							</c:otherwise>
						</c:choose></td>
					<td>사용유무</td>
					<td><c:choose>
							<c:when test="${pro.useyn=='y'}">
								<input type="checkbox" name="useyn" value="y" checked="checked">
							</c:when>
							<c:otherwise>
								<input type="checkbox" name="useyn" value="n">
							</c:otherwise>
						</c:choose></td>
				</tr>
				<tr>
					<td>상세설명</td>
					<td colspan="5"><textarea name="content" row="8" cols="70"}>${pro.content}</textarea></td>
				</tr>
				<tr>
					<td>상품이미지</td>
					<td colspan="5"><img src="product_images/${pro.image}"
						width="200pt"></td>
				</tr>
			</table>
			<input type="button" value="수정"
				onclick="location.href='/wepapp/NonageServlet?command=admin_product_update_form&pseq=${pro.pseq}'">
			<input type="button" value="취소"
				onclick="location.href='/wepapp/NonageServlet?command=admin_ItemList'">
		</form>
</body>
</html>