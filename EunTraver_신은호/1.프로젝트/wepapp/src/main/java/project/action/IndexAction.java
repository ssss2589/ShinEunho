package project.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.DAO.IndexDAO;
import project.VO.IndexVO;

public class IndexAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="boot/index.jsp";
		IndexDAO indexDAO = IndexDAO.getInstance();
		ArrayList<IndexVO> indexlist=indexDAO.indexlist();
		int indexsize=indexlist.size();
		request.setAttribute("indexlist", indexlist);
		request.setAttribute("indexsize", indexsize);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
