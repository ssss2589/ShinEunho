<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="study.DBAction, java.sql.*,java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	function call(val){
		opener.document.formm.id.value=val;
		opener.document.formm.idchecked.value = 1;
		self.close();
	}
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body><center><h3>* 아이디 확인 *</h3></center>
	<%!
		private DBAction db;
		private Connection conn;
		private PreparedStatement pstmt;
		private ResultSet rs;
		private String sql;
	%>
	<%
		String id = request.getParameter("id");
		sql = "select id from ghemember where id = ?";
		db = DBAction.getInstance();
		conn = db.getConnection();
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,id);
			rs=pstmt.executeQuery();
			if(rs.next()){
		%>
		<%=id %>는 이미 사용중인 ID입니다...
		<input type ="button" value = "닫기" onClick = "window.close()">
		<%
			}
			else{
		%>
		<%=id %>는 사용가능합니다.<br>
		
		<input type = "button" value="닫기" onClick="call('<%=id %>')">
		<%
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
			
		}
		%>
</body>
</html>