package com.nonage.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nonage.dao.AdminDAO;
import com.nonage.dto.AdminVO;

public final class LoginAdminAction implements 	Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String url="NonageServlet?command=admin_ItemList";
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		String pw = request.getParameter("pwd");
		AdminDAO adminDAO= AdminDAO.getInstance();
		AdminVO result = adminDAO.login(id, pw);
		try {
			if(result!=null) {
				session.setAttribute("loginAdmin", result);
			}else {
				url="NonageServlet?command=admin_login_form";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.include(request, response);
	}

}
