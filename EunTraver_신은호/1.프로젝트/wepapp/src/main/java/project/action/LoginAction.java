package project.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.DAO.MemberDAO;
import project.VO.MemberVO;

public class LoginAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="NonageServlet2?command=index";
		String id= request.getParameter("id");
		String pw = request.getParameter("pw");
		HttpSession session = request.getSession();
		MemberDAO memberDAO = MemberDAO.getInstance();
		MemberVO mem=memberDAO.login(id, pw);
		if(mem!=null&&mem.getUseyn().equals("y")) {
			session.setAttribute("loginUser", mem);
		}else {
			url="boot/loginForm.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
