package com.nonage.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nonage.dao.ProductDAO;
import com.nonage.dto.AdminVO;
import com.nonage.dto.ProductVO;

public class AdminItemList implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String url="admin/adminMain.jsp";
		String key = request.getParameter("key");
		String tpage = request.getParameter("tpage");
		HttpSession session = request.getSession();
		AdminVO loginUser = (AdminVO)session.getAttribute("loginAdmin");
		if(loginUser==null) {
			url="NonageServlet?command=admin_login_form";
		}else {
		if(key==null) {key="";}
		if(tpage == null) {
			tpage="1";
		}else if(tpage.equals("")) {
			tpage="1";
		}
		request.setAttribute("key", key);
		request.setAttribute("tpage", tpage);
		ProductDAO productDAO = ProductDAO.getInstance();
		ArrayList<ProductVO> itemList = productDAO.listProduct(Integer.parseInt(tpage),key);
		String paging=productDAO.pageNumber(Integer.parseInt(tpage), key);
		request.setAttribute("itemList", itemList);
		int n = itemList.size();
		request.setAttribute("productListSize", n);
		request.setAttribute("paging", paging);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
		

}
