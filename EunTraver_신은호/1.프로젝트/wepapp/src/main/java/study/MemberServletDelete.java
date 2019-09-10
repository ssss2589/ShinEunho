package study;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Connection conn;
	private Statement pstmt;
	
	@Override
	public void init() throws ServletException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.0.78:3306/user7", "user7", "user7");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
    public MemberServletDelete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		System.out.println(id);
		try {
			pstmt = conn.createStatement();
			String sql = "DELETE FROM EUNSTYLE WHERE ID='" + id + "'";
			int result = pstmt.executeUpdate(sql);
			String msg = result > -1 ? "successful" : "fail";
			System.out.println(msg);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("MemberListServlet");//페이지의 전환! (포워드는 페이지의 자원까지 가져감)
	}

	@Override
	public void destroy() {
		try {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
