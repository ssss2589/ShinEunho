package project.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.DAO.MemberDAO;
import project.VO.MemberVO;

public class MemberDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="NonageServlet2?command=index";
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		MemberDAO memberDAO = MemberDAO.getInstance();
		if(loginUser!=null) {
		memberDAO.Delete(loginUser.getId());
		session.removeAttribute("loginUser");
		}else {
			url="NonageServlet2?command=login_Form";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
