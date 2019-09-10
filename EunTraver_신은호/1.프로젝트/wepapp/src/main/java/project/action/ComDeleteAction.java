package project.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.DAO.CommendDAO;

public class ComDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="NonageServlet2?command=mywrite";
		CommendDAO commendDAO = CommendDAO.getInstance();
		String[] cseqArr=request.getParameterValues("cseq");
		System.out.println("sad");
		for(String cseq:cseqArr) {
		commendDAO.comDelete(cseq);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
