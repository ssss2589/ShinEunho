package project.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.DAO.QnaDAO;
import project.VO.AdminVO;
import project.VO.QnaVO;

public class AdminQnaDetailAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="boot/admin_QnaDetail.jsp";
		QnaDAO qnaDAO = QnaDAO.getInstance();
		QnaVO qna=qnaDAO.qnaDetail(request.getParameter("qseq"));
		HttpSession session = request.getSession();
		AdminVO admin = (AdminVO) session.getAttribute("loginAdmin");
		if(admin!=null) {
		request.setAttribute("Qna", qna);
		}
		else {
			url="boot/adminLoginForm.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
