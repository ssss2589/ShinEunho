package com.nonage.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nonage.dao.OrderDAO;

public class AdminResultSetAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="NonageServlet?command=admin_orderList";
			OrderDAO orderDAO = OrderDAO.getInstance();
			String[] odseqArr=request.getParameterValues("result");
			for(String odsep:odseqArr) {
				orderDAO.orderResultSet(odsep);
			}
			request.getRequestDispatcher(url).forward(request, response);
	}

}
