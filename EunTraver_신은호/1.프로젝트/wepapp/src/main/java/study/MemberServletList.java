package study;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberServletList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn;
	private Statement pstmt;
	private ResultSet rs;
	private ResultSetMetaData rsmd;
	@Override
	public void init() throws ServletException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.0.78:3306/user7", "user7", "user7");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
    public MemberServletList() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		out.println("<html><head><title>회원목록</title></head>");
		out.println("<body><h1>회원목록</h1>");
		String sql = "select * from eunstyle";
		try {
			pstmt = conn.createStatement();
			rs=pstmt.executeQuery(sql);
			rsmd=rs.getMetaData();
			int col=rsmd.getColumnCount();
			out.println("<table border='1'>");
			while(rs.next()){
				out.println("<tr>");
				for(int i=1;i <=col;i++) {
					out.println("<td><b>");
					if(i==2) {
						out.println("<a href=/wepapp/MemberServletUpdate?id="+rs.getString(i)+">"+rs.getString(i)+"</a>");
					}
					else{
						out.println(rs.getString(i));	
					}
					out.println("</b></td>");
				}
				
				out.println("</tr>");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
