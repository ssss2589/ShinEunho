package com.nonage.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nonage.dao.QnaDAO;
import com.nonage.dto.MemberVO;
import com.nonage.dto.QnaVO;

public class QnaWriteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="NonageServlet?command=qna_list";
		HttpSession session = request.getSession();
		MemberVO loginUser =(MemberVO) session.getAttribute("loginUser");
		if(loginUser==null) {
			url="NonageServlet?command=login_form";
		}else {
			QnaDAO qnaDAO = QnaDAO.getInstance();
			QnaVO qna = new QnaVO();
			qna.setId(loginUser.getId());
			qna.setSubject(request.getParameter("title"));
			qna.setContent(request.getParameter("body"));
			qna.setRep(1);
			qnaDAO.qnaWrite(qna);
		}
		response.sendRedirect(url);
	}

}
