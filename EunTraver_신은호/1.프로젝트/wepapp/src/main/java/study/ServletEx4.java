package study;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletEx4
 */
public class ServletEx4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletEx4() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		String color = request.getParameter("color");
		String[] fruit = request.getParameterValues("fruit");//여러개의 체크박스의 주소의값을 받는다.
		out.println("<html>");
		out.println("<body>");
		out.println(color + "<br>");
		for(int i =0;i<fruit.length;i++) {
			out.println(fruit[i]);	
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
