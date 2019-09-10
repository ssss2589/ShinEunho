package study;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletEx7
 */
public class ServletEx7 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletEx7() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String pw2 = request.getParameter("pw2");
		String[] rrn = request.getParameterValues("rrn");
		String[] email = request.getParameterValues("email");
		String phone = request.getParameter("phone");
		
		out.println("<html>");
		out.println("<body>");
		out.println(name + "<br>");
		out.println(id + "<br>");
		if(pw.equals(pw2)) {
		out.println(pw + "<br>");
		}else {
			out.println("비밀번호가 일치하지않습니다."+"<br>");
		}
		for(int i=0;i<rrn.length;i++) {
			if(i==0) {
				out.println(rrn[i]+"-");
			}
			else {
				out.println(rrn[i]+"<br>");
			}
		}
		for(int i =0;i<email.length;i++) {
			if(i==0) {
				out.println(email[i]+"@");
			}
			else {
				out.println(email[i]+"<br>");
			}
		}
		out.println(phone + "<br>");
		
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
