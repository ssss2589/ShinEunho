package com.nonage.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nonage.dao.QnaDAO;
import com.nonage.dto.QnaVO;

public class AdminQnaListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="admin/adminQnaList.jsp";
		QnaDAO qnaDAO = QnaDAO.getInstance();
		ArrayList<QnaVO> qnalist=qnaDAO.qnaList();
		if(qnalist==null) {
			url="admin/adminLogin.jsp";
		}else {
			int listSize=qnalist.size();
			request.setAttribute("qnaList", qnalist);
			request.setAttribute("listSize", listSize);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
