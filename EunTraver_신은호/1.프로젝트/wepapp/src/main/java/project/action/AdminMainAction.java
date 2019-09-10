package project.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.DAO.FreeDAO;
import project.VO.AdminVO;
import project.VO.FreeVO;

public class AdminMainAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="boot/adminMain.jsp";
		HttpSession session = request.getSession();
		FreeDAO freeDAO = FreeDAO.getInstance();
		String key = request.getParameter("key");
		String tpage = request.getParameter("tpage");
		AdminVO admin=(AdminVO) session.getAttribute("loginAdmin");
		if(admin!=null) {
		if(key==null) {key="";}
		if(tpage == null) {
			tpage="1";
		}else if(tpage.equals("")){
			tpage="1";
		}
			request.setAttribute("key", key);
			request.setAttribute("tpage", tpage);
			ArrayList<FreeVO> freelist=freeDAO.freeList(Integer.parseInt(tpage),key);
			String paging=freeDAO.pageNumber(Integer.parseInt(tpage), key);
			int freesize=freelist.size();
			request.setAttribute("freeList", freelist);
			request.setAttribute("freesize", freesize);
			request.setAttribute("paging", paging);
		}else {
			url="boot/adminLoginForm.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
