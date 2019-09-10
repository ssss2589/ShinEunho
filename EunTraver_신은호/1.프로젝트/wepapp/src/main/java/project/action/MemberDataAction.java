package project.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.DAO.MemberDAO;
import project.VO.MemberVO;

public class MemberDataAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="boot/MemberData.jsp";
		HttpSession session = request.getSession();
		MemberVO loginUser =(MemberVO) session.getAttribute("loginUser");
		MemberDAO memberDAO = MemberDAO.getInstance();
		MemberVO mem = memberDAO.search(loginUser.getId());
		request.setAttribute("mem", mem);
		request.getRequestDispatcher(url).forward(request, response);
	}
}
