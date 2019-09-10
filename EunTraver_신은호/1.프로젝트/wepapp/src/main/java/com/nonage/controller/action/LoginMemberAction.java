package com.nonage.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nonage.dao.MemberDAO;
import com.nonage.dto.MemberVO;

public class LoginMemberAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String url = "NonageServlet?command=index";
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		String pw = request.getParameter("pwd");
		MemberDAO memberDAO = MemberDAO.getInstance();
		MemberVO mem = memberDAO.login(id,pw);
		try {
			if(mem!=null) {
				if(mem.getUseyn().equals("y")) {
				session.setAttribute("loginUser", mem);
				}else {
					url="member/login.jsp";
				}
			}else {
				url="member/login.jsp";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.include(request, response);
	}
}
