package com.nonage.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nonage.dao.ProductDAO;
import com.nonage.dto.ProductVO;

public class IndexAction implements Action{ // action is controller

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/index.jsp";
		ProductDAO productDAO = ProductDAO.getInstance();
		ArrayList<ProductVO> newProductList = null, bestProductList=null;
		try {
			newProductList = productDAO.listNewProduct();
			bestProductList = productDAO.listBestProduct();
		}catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("newProductList", newProductList);
		request.setAttribute("bestProductList", bestProductList);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response); // forward 넘겨주고 돌려받지 않음.
	}
}
