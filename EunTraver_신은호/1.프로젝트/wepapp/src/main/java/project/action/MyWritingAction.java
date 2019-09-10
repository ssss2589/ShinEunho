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
import project.VO.MemberVO;

public class MyWritingAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="boot/myWriting.jsp";
		FreeDAO freeDAO = FreeDAO.getInstance();
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		ArrayList<FreeVO> freelist=freeDAO.myFreeList(loginUser.getName());
		CommendDAO commendDAO = CommendDAO.getInstance();
		ArrayList<CommendVO>comlist=commendDAO.mycomList(loginUser.getId());
		int freesize=freelist.size();
		int comsize=comlist.size();
		request.setAttribute("freeList", freelist);
		request.setAttribute("comList", comlist);
		request.setAttribute("freesize", freesize);
		request.setAttribute("comsize", comsize);
		request.getRequestDispatcher(url).forward(request, response);
		}

}
