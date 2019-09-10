package study;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberServletEx extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private Connection conn;
	private PreparedStatement pstmt;
	String rrn3;
	String email3;
	@Override
	public void init() throws ServletException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.0.78:3306/user7", "user7", "user7");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

    public MemberServletEx() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String pw2 = request.getParameter("pw2");
		String sex = request.getParameter("sex");
		String rrn =  request.getParameter("rrn");
		String rrn2 =  request.getParameter("rrn2");
		String email = request.getParameter("email");
		String email2 = request.getParameter("email2");
		String phone = request.getParameter("phone");
		rrn3=rrn+"-"+rrn2;
		email3=email+"@"+email2;
		String sql = "insert into eunstyle values(?,?,?,?,?,?,?)";
		String msg = null;
		try {
			pstmt = conn.prepareStatement(sql);
			if(pw.equals(pw2)) {
				pstmt.setString(1, name);
				pstmt.setString(2, id);
				pstmt.setString(3, pw);
				pstmt.setString(4, sex);
				pstmt.setString(5, rrn3);
				pstmt.setString(6, email3);
				pstmt.setString(7, phone);
			}
			
			msg = pstmt.executeUpdate() > 0 ? "회원가입 성공!" : "회원가입 실패!";
			request.setAttribute("msg", msg);
			RequestDispatcher rd = request.getRequestDispatcher("jspEx/joinProcess.jsp");
			rd.include(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void destroy() {
		try {
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
