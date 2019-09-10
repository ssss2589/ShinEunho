<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	function go_save(){
		var theForm = document.formm;
		if(theForm.kind.value==''){
			alert('상품분류를 선택하세요.');
			theForm.kind.focus();
		}else if(theForm.name.value==''){
			alert('상품명을 입력하세요.');
			theForm.name.focus();
		}else if(theForm.price1.value==''){
			alert('원가를 입력하세요.');
			theForm.price1.focus();
		}else if(theForm.price2.value==''){
			alert('판매가를 입력하세요.');
			theForm.price2.focus();
		}else if(theForm.content.value==''){
			alert('상품상세를 입력하세요.');
			theForm.content.focus();
		}else if(theForm.image.value==''){
			alert('상품이미지를 입력하세요.');
			theForm.image.focus();
		}else{
			theForm.encoding="multipart/form-data";
			theForm.action="/wepapp/NonageServlet?command=admin_Itemplus";
			theForm.submit();
		}
	}
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="formm" action="" method="post">
		<table>
			<tr>
				<td>상품분류</td>
				<td><select name="kind">
						<option value="1">Heels</option>
						<option value="2">Boots</option>
						<option value="3">Sandals</option>
						<option value="4">Sneakers</option>
						<option value="5">On Sale</option>
				</select></td>
			</tr>
			<tr>
				<td>상품명</td>
				<td><input type="text" name="name" value="asd"></td>
			</tr>
			<tr>
				<td>원가(A)</td>
				<td><input type="text" name="price1"></td>
				<td>판매가(B)</td>
				<td><input type="text" name="price2"></td>
				<td>(B-A)</td>
				<td><input type="text" name="price3"></td>
			</tr>
			<tr>
				<td>상세설명</td>
				<td><input type="text" name="content"> </textarea></td>
			</tr>
			<tr>
				<td>상품이미지</td>
				<td><input type="file" name="image"> </textarea></td>
			</tr>
		</table>
		<input type="button" value="등록" onclick="go_save()"> 
		<input type="button" value="취소" onclick="location.href='/wepapp/NonageServlet?command=admin_ItemList'">
	</form>
</body>
</html>