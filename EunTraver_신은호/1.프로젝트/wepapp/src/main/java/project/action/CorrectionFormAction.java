package project.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.DAO.FreeDAO;
import project.VO.FreeVO;

public class CorrectionFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="boot/free_correction.jsp";
		FreeDAO freeDAO = FreeDAO.getInstance();
		FreeVO free=freeDAO.freeDetail(request.getParameter("qseq"));
		request.setAttribute("free", free);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
