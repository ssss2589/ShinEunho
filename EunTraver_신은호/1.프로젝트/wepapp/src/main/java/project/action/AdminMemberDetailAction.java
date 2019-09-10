package project.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.DAO.MemberDAO;
import project.VO.AdminVO;
import project.VO.MemberVO;

public class AdminMemberDetailAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="boot/adminMemberDetail.jsp";
		HttpSession session = request.getSession();
		AdminVO admin=(AdminVO) session.getAttribute("loginAdmin");
		if(admin!=null) {
			MemberDAO memberDAO = MemberDAO.getInstance();
			MemberVO mem=memberDAO.search(request.getParameter("id"));
			request.setAttribute("mem", mem);
		}else {
			url="NonageServlet2?command=admin_login_Form";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
