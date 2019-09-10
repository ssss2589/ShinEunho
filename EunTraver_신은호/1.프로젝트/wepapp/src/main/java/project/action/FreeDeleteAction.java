package project.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.DAO.FreeDAO;

public class FreeDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="NonageServlet2?command=mywrite";
		FreeDAO freeDAO = FreeDAO.getInstance();
		String[] qseqArr=request.getParameterValues("qseq");
		for(String qseq:qseqArr) {
		freeDAO.freeDelete(qseq);
		}
		if(request.getParameter("free").equals("admin")) {
			url="NonageServlet2?command=adminLogin";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}	

}
