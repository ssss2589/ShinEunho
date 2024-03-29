package com.nonage.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nonage.dao.MemberDAO;

public class IdCheckFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = "/member/idcheck.jsp";
		String id = request.getParameter("id").trim();
		MemberDAO memberDAO = MemberDAO.getInstance();
		try {
			request.setAttribute("message", memberDAO.confirmID(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("id", id);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}