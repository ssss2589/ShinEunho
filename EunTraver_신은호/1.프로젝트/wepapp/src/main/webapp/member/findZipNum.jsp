<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script>
	function result(zipNum, sido, gugun, dong, bunji){
		opener.document.formm.zipNum.value=zipNum;
		opener.document.formm.addr1.value=sido +" " + gugun + " "+dong;
		opener.document.formm.addr2.value=bunji;
		self.close();
		
	}

</script>
</head>
<body>
	<h1> 우편번호 검색</h1>
	<form method=post name = formm action= "/wepapp/NonageServlet?command=find_zip_num"> 
	동 이름 : <input name="dong" type="text">
			<input type="submit" value="찾기" class="submit"> 
	</form>
	<table id="zipcode">
		<tr>
		<th>우편번호</th>
		<th>주소</th>
		</tr>
		<c:forEach items="${addressList}" var="addressVO">
		<tr>
		<td>${addressVO.zip_num}</td>
			<td>
				<a href ="" onclick="result('${addressVO.zip_num}', '${addressVO.sido}', '${addressVO.gugun}', '${addressVO.dong}', '${addressVO.bunji}')">
					${addressVO.sido} ${addressVO.gugun } ${addressVO.dong} ${addressVO.bunji}
				</a>
				</td>
				</tr>
				
		</c:forEach>
	</table>
</body>
</html>