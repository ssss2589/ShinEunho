package com.nonage.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		String url = "NonageServlet?command=index";
		RequestDispatcher rs = request.getRequestDispatcher(url);
		HttpSession session= request.getSession();
		session.removeAttribute("loginUser");
		rs.include(request, response);
	}
	
}
