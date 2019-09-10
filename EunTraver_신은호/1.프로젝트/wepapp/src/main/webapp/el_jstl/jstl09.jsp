<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>c:import 태그</h2>
<h3>RSS 피드 가져오기</h3>
<textarea rows="10" cols="80">
<c:import url="http://www.zdnet.co.kr/Include2/ZDNetKorea_News.xml" charEncoding="UTF-8"/>
</textarea>
<h3>RSS 피드 가져오기 - 보관소에 저장</h3>
<c:import var ="zdnetRss" url="http://www.zdnet.co.kr/Include2/ZDNetKorea_News.xml" charEncoding="UTF-8"/>
<textarea rows="10" cols="80">
${zdnetRss}
</textarea>

</body>
</html>