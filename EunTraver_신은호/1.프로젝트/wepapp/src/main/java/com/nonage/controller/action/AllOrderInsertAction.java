package com.nonage.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nonage.dao.CartDAO;
import com.nonage.dao.OrderDAO;
import com.nonage.dto.CartVO;
import com.nonage.dto.MemberVO;

public class AllOrderInsertAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="mypage/mypage.jsp";
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		if(loginUser==null) {
			url="NonageServlet?command=login_form";
		}else {
			OrderDAO orderDAO = OrderDAO.getInstance();
			ArrayList<CartVO> cartList = CartDAO.getInstance().listCart(loginUser.getId());
			int maxOseq = orderDAO.insertOrder(cartList, loginUser.getId());
			url="NonageServlet?command=Allorder_list&oseq="+maxOseq;
		}
		response.sendRedirect(url);
	}

}
