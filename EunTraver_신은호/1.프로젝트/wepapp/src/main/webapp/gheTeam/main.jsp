<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#notice {
	
}
</style>
</head>
<%@ include file="header.jsp"%>
<%@ include file="menubar.jsp"%>
<%@ include file="sideForm.jsp"%>
<body>
	<section id="body">
		<article id="good_board">
			<header
				style="float: left; margin-left: 10%; border-bottom: solid 2px gray; width: 60%; text-align: left;">
				<span style="font-size: 15px">인기글  <span style="float: right;">${good_board_select.value} /3<input type="button" value="◁"><input type="button" value="▷"></span></span> 
			</header>
			<input type="hidden" id="good_board_select" name="good_board_select" value=1>
			<table style="width: 60%; margin-left: auto;margin-right: auto;">		
				<tr>
				<c:forEach  var="board" items="${good_board}">
					<td><a href="#">${board.name}</a> <br/> 추천수 : ${board.bgood}</td>
				</c:forEach>				
				</tr>
			</table>
		</article>
	</section>
</body>
</html>