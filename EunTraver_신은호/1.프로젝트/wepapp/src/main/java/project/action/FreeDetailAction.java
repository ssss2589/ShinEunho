package project.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.DAO.CommendDAO;
import project.DAO.FreeDAO;
import project.VO.CommendVO;
import project.VO.FreeVO;
import project.VO.LikeToVO;
import project.VO.MemberVO;

public class FreeDetailAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="boot/freeDetail.jsp";
		FreeDAO freeDAO = FreeDAO.getInstance();
		HttpSession session = request.getSession();
		MemberVO loginUser=(MemberVO) session.getAttribute("loginUser");
		FreeVO free=freeDAO.freeDetail(request.getParameter("qseq"));
		freeDAO.clickPlus(request.getParameter("qseq"));
		CommendDAO commendDAO = CommendDAO.getInstance();
		CommendVO com = new CommendVO();
		if(request.getParameter("commend")!=null) {
			com.setQseq(request.getParameter("qseq"));
			com.setId(loginUser.getId());
			com.setCommend(request.getParameter("commend"));
			commendDAO.insert(com);
		}
		ArrayList<CommendVO> comlist= new ArrayList<CommendVO>();
		comlist= commendDAO.comList(request.getParameter("qseq"));
		int comsize=comlist.size();
		request.setAttribute("free", free);
		request.setAttribute("comList", comlist);
		request.setAttribute("size", comsize);
		if(loginUser==null) {
			if(request.getParameter("free").equals("admin")) {
				url="boot/adminFreeDetail.jsp";
			}else {
			url="boot/loginForm.jsp";
			}
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
