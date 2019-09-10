package study;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletEx
 */
public class ServletEx extends HttpServlet {
	private static final long serialVersionUID = 1L; // ��ü�� ����ȭ�ؼ� ������ ������ȭ�� �Ҷ� ��ü�� �����Ѱ��ΰ��� �Ǵ��ϱ� ���� ��

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Hello Servlet");
		out.println("</body>");
		out.println("</html>");
		out.println("<h2>1��2�� ǥ �����</h2>");
		out.println("<table border=\"1\">");
		for (int j =0 ; j < 10; j++) {
			out.println("<tr>");
			for (int i = 2; i < 10; i++) {
				if(j==0) {
					out.println("<td>");
					out.println(i +"��");
					out.println("</td>");
				}else {
				out.println("<td>");
				out.println(i + "x" + j + "=" + i * j);
				out.println("</td>");
				}
			}
			out.println("</tr>");
		}
		out.println("</table>");

		out.close();
		// response.setCharacterEncoding("KSC5601");//�ѱ� ���ڵ����
		// response.setCharacterEncoding("EUC-KR");//�ѱ� ���ڵ����
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
