package study2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public test() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		Connection conn = null;
		Statement stmt =null;
		ResultSet rs = null;
		String msg=null;
		try{
			conn = DBAction.getInstance().getConnection();
			stmt=conn.createStatement();
			String id = request.getParameter("id");
			String sql = "SELECT ID FROM EUNSTYLE WHERE ID ='"+id+"'";
			rs=stmt.executeQuery(sql);
			if(rs.next()) {
			 msg = "존재";
			}else {
				msg = "없음";
			}
			request.setAttribute("msg", msg);
			RequestDispatcher rd = request.getRequestDispatcher("ex3/test.jsp");
			rd.include(request, response);
	
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {if(stmt !=null) stmt.close();}catch(Exception e) {}
			try {if(conn !=null) conn.close();}catch(Exception e) {}
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
