package project.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.DAO.QnaDAO;


public class InquiryDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="NonageServlet2?command=inquiry";
		QnaDAO qnaDAO = QnaDAO.getInstance();
		String[] qseqArr = request.getParameterValues("qseq");
		for(String qseq:qseqArr) {
			qnaDAO.qnaDelete(qseq);
		}
		if(request.getParameter("free").equals("admin")) {
			url="NonageServlet2?command=admin_inquiry";
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
