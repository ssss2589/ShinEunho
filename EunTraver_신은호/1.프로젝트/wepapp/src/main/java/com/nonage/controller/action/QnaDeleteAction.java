package com.nonage.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nonage.dao.QnaDAO;
import com.nonage.dto.MemberVO;

public class QnaDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		String url="NonageServlet?command=qna_list";
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		if(loginUser==null) {
			url="NonageServlet?command=login_form";
		}else {
			String[] qseqArr = request.getParameterValues("qseq");
			for(String qseq:qseqArr) {
				QnaDAO.getInstance().deleteQna(qseq);
			}
		request.getRequestDispatcher(url).include(request, response);
		}
	}

}
