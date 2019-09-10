package study;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServletEx extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public LoginServletEx() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/jspEx/loginForm.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM EUNSTYLE"
					+ " WHERE ID=? AND PW=?");
			pstmt.setString(1, request.getParameter("id"));
			pstmt.setString(2, request.getParameter("password"));
			rs = pstmt.executeQuery();
			if(rs.next()) {
				EunStyle eun= new EunStyle()
							.setName(rs.getString("NAME"))
							.setId(rs.getString("ID"))
							.setPw(rs.getString("PW"))
							.setSex(rs.getString("SEX"))
							.setRrn(rs.getString("RRN"))
							.setEmail(rs.getString("EMAIL"))
							.setPhone(rs.getString("PHONE"));
				HttpSession session = request.getSession();		
				session.setAttribute("eun", eun);
				session.setMaxInactiveInterval(60);//디펄트는 30분!
				response.sendRedirect("MemberListServlet");
				
			}else {
				RequestDispatcher rd = 
						request.getRequestDispatcher("/jspEx/loginFail.jsp");
				rd.forward(request, response);//포워드는 자원도 같이 가져간다!
			}
		}catch(Exception e) {
			throw new ServletException(e);
		} finally {
			try {if(rs !=null) rs.close();}catch(Exception e) {}
			try {if(pstmt !=null) pstmt.close();}catch(Exception e) {}
			try {if(conn !=null) conn.close();}catch(Exception e) {}
			
		}
	}

}
