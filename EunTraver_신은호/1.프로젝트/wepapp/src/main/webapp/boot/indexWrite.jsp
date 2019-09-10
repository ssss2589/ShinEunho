<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, project.*" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Eun travel</title>
<link href="/wepapp/boot/css/bootstrap.min.css" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="/wepapp/boot/css/bootstrap-responsive.css" rel="stylesheet">
<link rel="stylesheet" href="/wepapp/boot/css/E.css">
</head>
<body>
<%@ include file="Aheader.jsp" %>
	<div id="content-categories">축제 등록</div>
<form id="writeForm" name="formm" action="/wepapp/NonageServlet2?command=IndexAdminWrite_Go" method="post" enctype="multipart/form-data">
<input type="hidden" name="boardCd" value="free" />
<table id="write-form" class="bbs-table">
<tr>
    <td align="center"><h4>제목</h4></td>
    <td><input type="text" name="title" style="width: 90%;" /></td>
</tr>
<tr>
    <td align="center"><h4>축제날짜</h4></td>
    <td><input type="text" name="indate" style="width: 90%;" /></td>
</tr>
<tr>
    <td align="center"><h4>사이트주소</h4></td>
    <td><input type="text" name="site" style="width: 90%;" /></td>
</tr>
<tr>
    <td colspan="2">
        <input type="text" name="textfield"  style=" width:1000px; height:500px;">
    </td>
</tr>
<tr>
    <td>첨부 파일</td>
    <td><input type="file" name="image" /></td>
</tr>
</table>
<div style="text-align: center;padding-bottom: 15px;">
    <input type="submit" value="전송" class="check"/>
    <input type="reset" value="취소" class="check"/>
    <input type="button" value="목록" class="check" 
    	onclick="location.href='NonageServlet2?command=IndexAdmin'"/>
</div>
</form>
 <script src="http://code.jquery.com/jquery-latest.js"></script>
 <script src="js/bootstrap.min.js"></script>
</body>
</html>