<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@ include file="header.jsp"%>
<%@ include file="menubar.jsp"%>
<%@ include file="sideForm.jsp"%>
<body>
	<section id="community">
		<article
			style="float: left; margin-left: 10%; border-bottom: solid 2px gray; width: 60%; text-align: left; margin-bottom: 40px;">
			<span style="font-size: 43px">금용이의 게임커뮤니티${community.cname} </span>
		</article>
		<br />




		<article id="g_board_type"
			style="margin-top: 50px; float: left; margin-left: 20%; width: 80%">
			<input type="button" id="g_board_button" value="전체글"><input
				type="button" id="g_board_button" value="인기글">
		</article>
		<article id="g_board_list" style="margin-right: 10%;">
			<table style="width: 60%; margin-left: auto; margin-right: auto;">
				<tr>
					<th
						style="border-top: solid 2px blue; border-bottom: solid 1px blue;">번호</th>
					<th width="60%"
						style="border-top: solid 2px blue; border-bottom: solid 1px blue;">제목</th>
					<th
						style="border-top: solid 2px blue; border-bottom: solid 1px blue;">글쓴이</th>
					<th
						style="border-top: solid 2px blue; border-bottom: solid 1px blue;">작성일</th>
					<th
						style="border-top: solid 2px blue; border-bottom: solid 1px blue;">조회</th>
					<th
						style="border-top: solid 2px blue; border-bottom: solid 1px blue;">추천</th>
				</tr>

				<tr>
					<c:forEach var="board" items="${boardList}">
						<td>${board.bseq}</td>
						<td><a href="#">${board.name}</a></td>
						<td>${board.nickname}</td>
						<td>${board.indate}</td>
						<td>${board.bview}</td>
						<td>${board.bgood}</td>
					</c:forEach>
				</tr>
			</table>
		</article>
	</section>
</body>
</html>