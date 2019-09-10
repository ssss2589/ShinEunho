package com.nonage.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nonage.dao.QnaDAO;
import com.nonage.dto.QnaVO;

public class AdminQnaDetailAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="admin/QnaDetail.jsp";
		QnaDAO qnaDAO = QnaDAO.getInstance();
		QnaVO qna=qnaDAO.qnaView(request.getParameter("qseq"));
		if(qna==null) {
			url="admin/adminLogin.jsp";
		}else {
			request.setAttribute("qna", qna);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
