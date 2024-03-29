<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.nonage.dto.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function go_mod_save(tpage,pseq){
	var theForm= document.frm;
	if(theForm.useyn.checked == true){
		theForm.useyn.value = "y";
	}
	if(theForm.bestyn.checked == true){
		theForm.bestyn.value = "y";
	}
	theForm.action="NonageServlet?command=admin_product_update&tpage="+tpage+"&pseq="+pseq;
	theForm.submit();
}
function go_mov(){
	var theForm=document.frm;
	theForm.action="NonageServlet?command=admin_product_list";
	theForm.submit();
}
function on_change(){
	frzm.img.src = frm.image.value;
}
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<article>
	<h1>상품수정</h1>
	<form name="frm" method="post" enctype="multipart/form-data">
	<input type = "hidden" name="pseq" value="${productVO.pseq}">
	<table id="List">
		<tr>
		<th>상품분류</th>
		<td colspan="5">
		<select name="kind">
			<c:forEach items="${kindList}" var="kind" varStatus="status">
			<c:choose>
			<c:when test="${productVO.kind==status.count}">
				<option value="${status.count}" selected="selected">${kind}</option>
			</c:when>
			<c:otherwise>
				<option value ="${status.count}">${kind}</option>
			</c:otherwise>
			</c:choose>
			</c:forEach>
		</select>
		</td>
		</tr>
		<tr>
			<th>상품명</th>
			<td width="343" colspan="5">
				<input type="text" name="name" size="47" maxlength="100"
					value="${productVO.name}">
			</td>
		</tr>
		<tr>
			<th>원가[A]</th>
			<td width="70">
			<input type="text" name="price1" size="11" value="${productVO.price1}">
			</td>
			<th>판매가[A]</th>
			<td width="70">
			<input type="text" name="price2" size="11" value="${productVO.price2}">
			</td>
			<th>[B-A]</th>
			<td width="72">
			<input type="text" name="price3" size="11" value="${productVO.price3}">
			</td>
		</tr>
		<tr>
			<th>베스트상품</th>
			<td>
				<c:choose>
					<c:when test="${productVO.bestyn=='y'}">
						<input type="checkbox" name="bestyn" value="y" checked="checked">
					</c:when>
					<c:otherwise>
						<input type="checkbox" name="bestyn" value="n">
					</c:otherwise>
				</c:choose>
				</td>
				<th>사용유무</th>
					<td>
						<c:choose>
							<c:when test="${productVO.useyn=='y'}">
								<input type="checkbox" name="useyn" value="y" checked="checked">
							</c:when>
						<c:otherwise>
							<input type="checkbox" name="useyn" value="n">
						</c:otherwise>
						</c:choose>
						</td>
						<tr>
							<th>상세설명</th>
							<td colspan="5">
								<textarea name="content" rows="8" cols="70">${productVO.content}</textarea>
							</td>
						</tr>
						<tr>
							<th>상품이미지</th>
							<td colspan="5">
								<img src="product_images/${productVO.image}" width="200pt" name="img">
							<br>
							<input type="file" name="image" onchange="on_change()">
							<input type="text" name="image2" value="${productVO.image}"  readonly="readonly">
							</td>
						</tr>
	</table>
	<input class="btn" type="button" value="수정"
		onclick="go_mod_save('${tpage}', '${productVO.pseq}')">
		<input class="btn" type="button" value="취소"
		onclick="go_mov()">
	</form>
	</article>
</body>
</html>