package com.nonage.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nonage.dao.CartDAO;

public class CartDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String url = "NonageServlet?command=cart_list";
		String[] cseqArr = request.getParameterValues("cseq");
		for(String cseq:cseqArr) {
		CartDAO cartDAO = CartDAO.getInstance();
		cartDAO.deleteCart(cseq);
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.include(request, response);
	}

}
