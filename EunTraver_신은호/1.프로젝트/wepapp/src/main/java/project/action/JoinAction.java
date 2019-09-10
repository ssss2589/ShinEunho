package project.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.DAO.MemberDAO;
import project.VO.MemberVO;



public class JoinAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="boot/loginForm.jsp";
		MemberDAO memberDAO = MemberDAO.getInstance();
		MemberVO mem= new MemberVO();
		mem.setId(request.getParameter("id"));
		mem.setPwd(request.getParameter("pw"));
		mem.setName(request.getParameter("name"));
		mem.setEmail(request.getParameter("email"));
		mem.setZipNum(request.getParameter("zipNum"));
		mem.setAddress(request.getParameter("address"));
		mem.setPhone(request.getParameter("phone"));
		int result=memberDAO.join(mem);
		if(result==0) {
			url="boot/joinForm.jsp";
		}
		response.sendRedirect(url);
	}	

}
