package project.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.DAO.QnaDAO;
import project.VO.MemberVO;
import project.VO.QnaVO;

public class InquiryAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="boot/inquiry.jsp";
		QnaDAO qnaDAO = QnaDAO.getInstance();
		HttpSession session = request.getSession();
		MemberVO loginUser =(MemberVO)session.getAttribute("loginUser");
		if(loginUser==null) {
			url="NonageServlet2?command=login_Form";
		}else {
			ArrayList<QnaVO> qnalist = qnaDAO.qnaList(loginUser.getId());
			int size=qnalist.size();
			request.setAttribute("qnaList", qnalist);
			request.setAttribute("size", size);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
