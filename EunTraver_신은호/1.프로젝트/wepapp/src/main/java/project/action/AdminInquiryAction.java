package project.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.DAO.QnaDAO;
import project.VO.AdminVO;
import project.VO.QnaVO;

public class AdminInquiryAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="boot/adminInquiry.jsp";
		QnaDAO qnaDAO = QnaDAO.getInstance();
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
		ArrayList<QnaVO> qna=qnaDAO.qnaList(Integer.parseInt(tpage),key);
		String paging=qnaDAO.pageNumber(Integer.parseInt(tpage), key);
		int size=qna.size();
		request.setAttribute("size", size);
		request.setAttribute("qnalist", qna);
		request.setAttribute("paging", paging);
		}else {
			url="boot/adminLoginForm.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
