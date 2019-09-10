package study;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletEx6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletEx6() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String email = request.getParameter("receive");
		String[] dd=  request.getParameterValues("chk1");
		
		out.println("<html>");
		out.println("<body>");
		out.println(id + "<br>");
		out.println(pw + "<br>");
		out.println(email + "<br>");
		for(int i =0;i<dd.length;i++) {
			out.println(dd[i]);	
		}
		
		out.println("</body>");
		out.println("</html>");
		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
