package project.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.DAO.AdminDAO;
import project.VO.AdminVO;

public class AdminLoginAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="NonageServlet2?command=adminMain";
		AdminDAO adminDAO = AdminDAO.getInstance();
		AdminVO admin=adminDAO.adminLogin(request.getParameter("id"), request.getParameter("pwd"));
		HttpSession session = request.getSession();
		if(admin!=null) {
			session.setAttribute("loginAdmin", admin);
		}else {
			url="boot/adminLoginForm.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
