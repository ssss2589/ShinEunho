package study2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class joinServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		joinVO VO = new joinVO();
		String url="test2/login.jsp";
		VO.setId(request.getParameter("id"));
		VO.setPw(request.getParameter("pw"));
		VO.setName(request.getParameter("name"));
		VO.setDate(request.getParameter("securit"));
		VO.setSex(request.getParameter("sex"));
		VO.setEmail(request.getParameter("email"));
		
		try {
			int v= joinAction.joinAction2(VO);
			if(v==0) {
				url="test2/join.jsp";
			}
		}catch(Exception e) {
			url="test2/join.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.include(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
