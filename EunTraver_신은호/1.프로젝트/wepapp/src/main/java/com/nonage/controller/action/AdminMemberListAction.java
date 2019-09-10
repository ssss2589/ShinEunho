package com.nonage.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nonage.dao.MemberDAO;
import com.nonage.dto.MemberVO;

public class AdminMemberListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			String url="admin/adminMemberList.jsp";
			MemberDAO memberDAO = MemberDAO.getInstance();
			ArrayList<MemberVO> memberList=memberDAO.memberList();
			if(memberList==null) {
				url="admin/adminLogin.jsp";
			}
			else {
			int Listsize=memberList.size();
			request.setAttribute("memberList", memberList);
			request.setAttribute("Listsize", Listsize);
			}
			request.getRequestDispatcher(url).forward(request, response);
	}

}
