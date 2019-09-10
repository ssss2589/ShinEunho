<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="study.EunStyle"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.LinkedList"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL(Expression Language)</title>
<style type="text/css">
body {
	font-size: small;
}

table {
	border: thin solid gray;
	border-collapse: collapse;
}

td, th {
	border: thin dotted gray;
	padding: 2px;
}

th {
	background-color: lightgray;
}

pre {
	font-size: 90%;
}
</style>

</head>
<body>

	<p>
		<a href="el1.jsp">[이전]</a><a href="el3.jsp">[다음]</a>
	</p>
	<h2>EL - 값 꺼내기</h2>
	<%
		//데이터 준비
		pageContext.setAttribute("scores", new int[] { 90, 80, 70, 100 });

		List<String> nameList = new LinkedList<String>();
		nameList.add("홍길동");
		nameList.add("임꺽정");
		nameList.add("일지매");
		pageContext.setAttribute("nameList", nameList);

		Map<String, String> map = new HashMap<String, String>();
		map.put("s01", "홍길동");
		map.put("s02", "임꺽정");
		map.put("s03", "일지매");
		pageContext.setAttribute("map", map);
		pageContext.setAttribute("EunStyle", new EunStyle().setName("홍길동").setEmail("hong@test.com"));
	%>
	<table>
		<tr>
			<th>대상</th>
			<th>EL 코드</th>
			<th>설명</th>
		</tr>
		<tr>
			<td>배열</td>
			<td>\${myArray[1]}</td>
			<td>배열에서 해당 인덱스의 값을 꺼낸다.<br> <pre>[자바 코드]
				pageContext.setAttribute("scores",new int[]{90,80,70,100});
				[실행 결과]
				\${scores[2]} = ${scores[2]} 
			</pre>
			</td>
		</tr>
		<tr>
			<td>리스트</td>
			<td>\${myList[2]}</td>
			<td>List 객체에서 인덱스로 지정된 항목의 값을 꺼낸다. <pre>
					[자바코드]
					List nameList = new	LinkedList();
					nameList.add("홍길동");
					nameList.add("임꺽정");
					nameList.add("일지매");
					pageContext.setAttribute("nameList",nameList);
					
					[실행결과]
					\${nameList[1] = ${nameList[1]}
				</pre>
			</td>
		</tr>
		<tr>
			<td>맵</td>
			<td>\${myMap.ketName}</td>
			<td>Map 객체에서 키에 해당하는 값을 꺼낸다. <pre>
					[자바 코드]
					Map map = new HashMap();
					map.put("s01","홍길동");
					map.put("s02","임꺽정");
					map.put("s03","일지매");
					pageContext.setAttribute("map",map);
					
					[실행 결과]
					\${map.s02} = ${map.s02}
				</pre>
			</td>
		</tr>
		<tr>
			<td>자바빈</td>
			<td>\${myObj.proName}</td>
			<td>자바 객체에서 프로퍼티의 값을 꺼낸다. 
			<pre>
					[자바 코드]
					pageContext.setAttribute("EunStyle",
								new EunStyle()
									.setName("홍길동")
									.setEmail("hong@test.com"));
					
					[실행 결과]
					\${EunStyle.email} = ${EunStyle.email}
				</pre>
			</td>
		</tr>
	</table>
	<p>
		<a href="el1.jsp">[이전]</a><a href="el3.jsp>">[다음]</a>
	</p>
</body>
</html>