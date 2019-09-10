package project.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.DAO.IndexDAO;
import project.VO.AdminVO;
import project.VO.IndexVO;

public class IndexAdminAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="boot/indexAdminForm.jsp";
		IndexDAO indexDAO = IndexDAO.getInstance();
		HttpSession session = request.getSession();
		AdminVO admin = (AdminVO) session.getAttribute("loginAdmin");
		if(admin!=null) {
		String key = request.getParameter("key");
		String tpage = request.getParameter("tpage");
		if(key==null) {key="";}
		if(tpage == null) {
			tpage="1";
		}else if(tpage.equals("")){
			tpage="1";
		}
		request.setAttribute("key", key);
		request.setAttribute("tpage", tpage);
		ArrayList<IndexVO> index=indexDAO.indexList(Integer.parseInt(tpage),key);
		String paging=indexDAO.pageNumber(Integer.parseInt(tpage), key);
		int size=index.size();
		request.setAttribute("size", size);
		request.setAttribute("indexlist", index);
		request.setAttribute("paging", paging);
		}else {
			url="boot/adminLoginForm.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
