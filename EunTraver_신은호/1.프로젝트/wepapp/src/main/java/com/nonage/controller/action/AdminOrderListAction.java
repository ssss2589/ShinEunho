package com.nonage.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nonage.dao.OrderDAO;
import com.nonage.dto.OrderVO;

public class AdminOrderListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			String url ="admin/adminOrderList.jsp";
			OrderDAO orderDAO = OrderDAO.getInstance();
			ArrayList<OrderVO> order=orderDAO.adminOrderList(request.getParameter("id"));
			if(order==null) {
				url="admin/adminMain.jsp";
			}else {
				int n=order.size();
				request.setAttribute("orderlist", order);
				request.setAttribute("orderlistsize", n);
			}
			request.getRequestDispatcher(url).forward(request, response);
	}

}
