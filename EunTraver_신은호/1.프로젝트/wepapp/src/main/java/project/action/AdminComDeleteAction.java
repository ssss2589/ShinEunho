package project.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.DAO.CommendDAO;
import project.DAO.FreeDAO;
import project.VO.AdminVO;
import project.VO.CommendVO;
import project.VO.FreeVO;

public class AdminComDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="boot/adminFreeDetail.jsp";
		CommendDAO commendDAO = CommendDAO.getInstance();
		HttpSession session = request.getSession();
		AdminVO admin = (AdminVO) session.getAttribute("loginAdmin");
		if(admin!=null) {
		String cseq=request.getParameter("cseq");
		commendDAO.comDelete(cseq);
		FreeDAO freeDAO = FreeDAO.getInstance();
		FreeVO free=freeDAO.freeDetail(request.getParameter("qseq"));
		freeDAO.clickPlus(request.getParameter("qseq"));
		ArrayList<CommendVO> comlist= new ArrayList<CommendVO>();
		comlist= commendDAO.comList(request.getParameter("qseq"));
		int comsize=comlist.size();
		request.setAttribute("free", free);
		request.setAttribute("comList", comlist);
		request.setAttribute("size", comsize);
		}else {
			url="boot/adminLoginForm.jsp";
		}	
		request.getRequestDispatcher(url).forward(request, response);
	}

}
