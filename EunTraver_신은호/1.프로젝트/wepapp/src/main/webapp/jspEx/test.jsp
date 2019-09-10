<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<table border="1">
	<%
	for(int i=0; i<10;i++){ 
	%>
	<tr>
	<% 
	for(int j=2;j<10;j++){
	%>
		<td>
		<%if(i==0){ %>
			<%= j+"단" %>
		<% }else{ %>
			<%= j+"*"+i+"="+i*j %>
		<% } %>
		</td>
		<%
	}
		%>
	</tr>
	<%
	}
	%>
	</table>
	<%@ page import="java.util.*"%>
	<%@ page import="java.text.SimpleDateFormat"%>
	<%
	Date today = new Date();         
	SimpleDateFormat date = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초 입니다."); 
	String toDay = date.format(today);
	String[] weekDay = { "일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일" };     
	   Calendar cal = Calendar.getInstance(); 
	     int num = cal.get(Calendar.DAY_OF_WEEK)-1; 
	     String today2 = weekDay[num]; 
	out.println("오늘 : "+toDay+"(오늘은 "+today2+" 입니다.)"+"<br>"); 
	%>

</body>
</html>