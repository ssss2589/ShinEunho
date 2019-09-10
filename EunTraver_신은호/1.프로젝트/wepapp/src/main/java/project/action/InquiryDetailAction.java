package project.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.DAO.QnaDAO;
import project.VO.QnaVO;

public class InquiryDetailAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="boot/inquiryDetail.jsp";
		QnaDAO qnaDAO = QnaDAO.getInstance();
		QnaVO qna=qnaDAO.qnaDetail(request.getParameter("qseq"));
		request.setAttribute("Qna", qna);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
