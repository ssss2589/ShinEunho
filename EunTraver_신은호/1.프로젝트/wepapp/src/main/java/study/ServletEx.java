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
	private static final long serialVersionUID = 1L; // 객체의 직렬화해서 보낼때 역직렬화를 할때 객체가 동일한것인가를 판단하기 위한 것

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
		out.println("<h2>1행2열 표 만들기</h2>");
		out.println("<table border=\"1\">");
		for (int j =0 ; j < 10; j++) {
			out.println("<tr>");
			for (int i = 2; i < 10; i++) {
				if(j==0) {
					out.println("<td>");
					out.println(i +"단");
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
		// response.setCharacterEncoding("KSC5601");//한글 인코딩방식
		// response.setCharacterEncoding("EUC-KR");//한글 인코딩방식
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
