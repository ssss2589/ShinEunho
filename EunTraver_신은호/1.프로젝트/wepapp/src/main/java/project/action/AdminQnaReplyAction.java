package project.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.DAO.QnaDAO;

public class AdminQnaReplyAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="NonageServlet2?command=admin_QnaDetail&qseq="+request.getParameter("qseq");
		QnaDAO qnaDAO = QnaDAO.getInstance();
		qnaDAO.qnaReply(request.getParameter("qseq"), request.getParameter("commend"));
		request.getRequestDispatcher(url).forward(request, response);
	}

}
