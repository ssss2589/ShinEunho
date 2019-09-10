package com.nonage.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nonage.dao.QnaDAO;

public class AdminQnaWriteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="NonageServlet?command=admin_qnaList";
		QnaDAO qnaDAO = QnaDAO.getInstance();
		System.out.println(request.getParameter("reply"));
		System.out.println(request.getParameter("subject"));
		qnaDAO.qnaAdminUpdate(request.getParameter("reply"),request.getParameter("subject"));
		response.sendRedirect(url);
	}

}
