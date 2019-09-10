package study;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM EUNSTYLE ORDER BY NAME ASC");
			response.setContentType("text/html; charset=UTF-8");
			ArrayList<EunStyle> euns = new ArrayList<EunStyle>();
			//데이터 베이스에서 회원정보를 가져와 euns에 담는다.
			//기르고 eunstyle객체를 arratlist에 추가한다.
		while(rs.next()) {
			euns.add(new EunStyle()
					.setName(rs.getString("NAME"))
					.setId(rs.getString("ID"))
					.setPw(rs.getString("PW"))
					.setSex(rs.getString("SEX"))
					.setRrn(rs.getString("RRN"))
					.setEmail(rs.getString("EMAIL"))
					.setPhone(rs.getString("PHONE")));
		}
		//request에 회원 목록 데이터 보관
		request.setAttribute("euns", euns);
		for(EunStyle eun : euns) {
			eun.getName();
		}
		//JSP로 출력을 위임한다.
		RequestDispatcher rd = request.getRequestDispatcher("jspEx/MemberList.jsp");
		rd.include(request, response);
		}catch(Exception e) {
			throw new ServletException(e);
		}finally {
			try {if(rs !=null) rs.close();}catch(Exception e) {}
			try {if(stmt !=null) stmt.close();}catch(Exception e) {}
			try {if(conn !=null) conn.close();}catch(Exception e) {}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
