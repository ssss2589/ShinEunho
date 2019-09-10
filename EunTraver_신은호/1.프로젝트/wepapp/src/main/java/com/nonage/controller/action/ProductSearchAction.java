package com.nonage.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nonage.dao.ProductDAO;
import com.nonage.dto.ProductVO;

public class ProductSearchAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			String url="admin/adminMain.jsp";
			ProductDAO productDAO = ProductDAO.getInstance();
			if(request.getParameter("key")!="") {
			ArrayList<ProductVO> itemList=productDAO.searchProduct(request.getParameter("key"));
			if(itemList!=null) {
				request.setAttribute("itemList", itemList);
				}else {
					url="NonageServlet?adminMain_form";
				}
			}
			request.getRequestDispatcher(url).forward(request, response);
	}

}
