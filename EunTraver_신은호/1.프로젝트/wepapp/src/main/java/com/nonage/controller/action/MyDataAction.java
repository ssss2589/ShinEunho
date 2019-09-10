package com.nonage.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nonage.dao.MemberDAO;
import com.nonage.dto.MemberVO;

public class MyDataAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="mypage/myData.jsp";
		MemberDAO memberDAO = MemberDAO.getInstance();
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		if(loginUser==null) {
			url="member/login.jsp";
		}else {
			MemberVO mem=memberDAO.myData(loginUser.getId());
			request.setAttribute("loginUser", mem);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
