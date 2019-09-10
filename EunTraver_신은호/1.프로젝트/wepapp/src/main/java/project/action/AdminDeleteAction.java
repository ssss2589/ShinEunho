package project.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.DAO.MemberDAO;
import project.VO.AdminVO;

public class AdminDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="NonageServlet2?command=admin_Member";
		MemberDAO memberDAO = MemberDAO.getInstance();
		HttpSession session= request.getSession();
		AdminVO admin = (AdminVO) session.getAttribute("loginAdmin");
		if(admin!=null) {
		String[] midArr=request.getParameterValues("mid");
		for(String mid:midArr) {
		memberDAO.Delete(mid);
		}
		}else {
		url="NonageServlet2?command=adminLogin";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
