package project.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.DAO.IndexDAO;
import project.VO.AdminVO;
import project.VO.IndexVO;

public class AdminIndexDetailAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="boot/adminIndexDetail.jsp";
		HttpSession session = request.getSession();
		AdminVO admin=(AdminVO) session.getAttribute("loginAdmin");
		if(admin!=null) {
			IndexDAO indexDAO = IndexDAO.getInstance();
			IndexVO index=indexDAO.search(request.getParameter("qseq"));
			request.setAttribute("index", index);
		}else {
			url="NonageServlet2?command=admin_login_Form";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
