package study;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberServletUpdate() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = null;
		Statement pstmt = null;
		ResultSet rs = null;
		String id = request.getParameter("id");
		EunStyle eun = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.createStatement();
			String sql = "select * from eunstyle where id='" + id + "'";
			rs = pstmt.executeQuery(sql);
			response.setContentType("text/html; charset=UTF-8");
			if (rs.next()) {	
				eun = new EunStyle();
				eun.setName(rs.getString(1));
				eun.setId(rs.getString(2));
				eun.setPw(rs.getString(3));
				eun.setSex(rs.getString(4));
				eun.setRrn(rs.getString(5));
				eun.setEmail(rs.getString(6));
				eun.setPhone(rs.getString(7));
				
			}
			/*response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<html><head><title> 정보변경 </title></head>");
			out.println("<body><h1> 정보변경 </h1>");
			out.println("<form action = '/wepapp/MemberServletUpdate' method = 'post'>");
			out.println("이름 : <input type ='text' name = 'name' value='" + eun.getName() + "' readonly> <br/>");
			out.println("아이디 : <input type ='text' name = 'id' value='" + eun.getId() + "' readonly> <br/>");
			out.println("암호 : <input type ='password' name = 'pw'> <br/>");
			out.println("성별 : <input type ='text' name = 'sex' value='" + eun.getSex() + "' readonly> <br/>");
			out.println("주민번호 : <input type ='text' name = 'rrn' value='" + eun.getRrn() + "' readonly> <br/>");
			out.println("이메일 : <input type ='text' name = 'email' value='" + eun.getEmail() + "' readonly> <br/>");
			out.println("휴대전화 : <input type ='text' name = 'phone' value='" + eun.getPhone() + "' readonly> <br/>");
			out.println("<input type = 'submit' value = '확인'  > ");
			out.println("<input type = 'reset' value = '취소' > ");
			out.println("<input type = 'button' value = '삭제' onclick='location.href=\"/wepapp/MemberServletDelete?id="+id+"\"'>");
			out.println("</form>");
			out.println("</body></html>");
			out.close();*/
			request.setAttribute("eun", eun);
			//JSP로 출력을 위임한다.
			RequestDispatcher rd = request.getRequestDispatcher("jspEx/memberUpdate.jsp");
			rd.include(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(rs !=null) rs.close();}catch(Exception e) {}
			try {if(pstmt !=null) pstmt.close();}catch(Exception e) {}
			try {if(conn !=null) conn.close();}catch(Exception e) {}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
