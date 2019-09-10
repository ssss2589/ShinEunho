package com.nonage.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nonage.dao.AddressDAO;
import com.nonage.dto.AddressVO;

public class FindZipNumAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/findZipNum.jsp";
		String dong = request.getParameter("dong");
		try {
			//  널 체크                         공백 체크
			//  자바 스크립트 자체에서 처리할수 있다. 그게 맞음 ㅎ ( 효율성 )
			if(dong != null && dong.trim().equals("") == false) {
				AddressDAO addressDAO = AddressDAO.getInstance();
				ArrayList<AddressVO> addressList 
				= addressDAO.selectAddressByDong(dong.trim());
				request.setAttribute("addressList", addressList);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
