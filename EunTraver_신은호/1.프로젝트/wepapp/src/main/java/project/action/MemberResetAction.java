package project.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.DAO.MemberDAO;
import project.VO.MemberVO;

public class MemberResetAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="NonageServlet2?command=index";
		MemberDAO memberDAO= MemberDAO.getInstance();
		HttpSession session = request.getSession();
		session.removeAttribute("loginUser");
		MemberVO mem=new MemberVO();
		mem.setPwd(request.getParameter("pw"));
		mem.setZipNum(request.getParameter("zipNum"));
		mem.setAddress(request.getParameter("address"));
		mem.setPhone(request.getParameter("phone"));
		memberDAO.update(mem, request.getParameter("id"));
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
