
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "android/android.jsp";
		MemberDAO memberDAO = MemberDAO.getInstance();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		MemberVO mem = memberDAO.login(id, pw);
		if (mem != null) {
			request.setAttribute("size", 1);
			request.setAttribute("mem", mem);
		} else {
			request.setAttribute("size", 0);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
