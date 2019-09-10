<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		int a; //선언태그
		int b;
	%>
	<%
		a = 10; //실행태그
		b = 20;
		if (b / a > 10) {
	%><p>
		양의 값(첫번째) <br>
		<%=" 양의값 (두번쨰) "%><br><%--출력태그 --%>
		<%
			out.println("다시 양의 값(세번째)"); //내장객체가 존재하기때문에 out을 객체 생성하지않고 사용함.
		%>
		<%
			} else {
		%>
		음의 값
		<%
			}
		%>
	
</body>
</html>