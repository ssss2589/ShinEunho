package study;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SerbletEx2
 */
public class ServletEx2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /* <학습목표>
     * String <- request.getParameter(String name)//값을 가져온다
     * Emumeration <- request.getParameterNames()//값을 닮은 그릇을가져온다.
     * String[] <- request.getParameterValues(String name)//값들을 가져온다.
     */
	//response:응답객체 request:요청객체
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String nn = request.getParameter("name");
		out.println("<html>");
		out.println("<body>");
		out.println("<b>아이디 : "+id+"</b><br />");
		out.println("<b>아이디 : "+pw+"</b><br />");
		out.println("<b>암호 : "+nn+"</b>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
