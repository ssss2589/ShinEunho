package com.nonage.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nonage.dao.ProductDAO;
import com.nonage.dto.ProductVO;

public class AdminDetailAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="admin/adminProductDetail.jsp";
		ProductDAO productDAO = ProductDAO.getInstance();
		ProductVO pro=productDAO.selectProduct(request.getParameter("pseq"));
		if(pro==null) {
			url="admin/adminMain.jsp";
		}else {
			String kindList[] = {"Heels","Boots","Sandals","Sneakers","Sale"};
			request.setAttribute("kindList", kindList);
			request.setAttribute("pro", pro);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
