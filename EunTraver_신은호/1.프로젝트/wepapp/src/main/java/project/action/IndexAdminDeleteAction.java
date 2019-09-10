package project.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.DAO.IndexDAO;

public class IndexAdminDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="NonageServlet2?command=IndexAdmin";
		IndexDAO indexDAO = IndexDAO.getInstance();
		String[] qseqArr=request.getParameterValues("qseq");
		for(String qseq:qseqArr) {
		indexDAO.Delete(qseq);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
