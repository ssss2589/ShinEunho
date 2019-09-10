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
       
    /* <�н���ǥ>
     * String <- request.getParameter(String name)//���� �����´�
     * Emumeration <- request.getParameterNames()//���� ���� �׸��������´�.
     * String[] <- request.getParameterValues(String name)//������ �����´�.
     */
	//response:���䰴ü request:��û��ü
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String nn = request.getParameter("name");
		out.println("<html>");
		out.println("<body>");
		out.println("<b>���̵� : "+id+"</b><br />");
		out.println("<b>���̵� : "+pw+"</b><br />");
		out.println("<b>��ȣ : "+nn+"</b>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
