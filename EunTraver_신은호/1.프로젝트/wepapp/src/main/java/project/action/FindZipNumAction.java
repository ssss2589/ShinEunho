package project.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.DAO.AddressDAO;
import project.VO.AddressVO;

public class FindZipNumAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="boot/findZipNum.jsp";
		AddressDAO addressDAO = AddressDAO.getInstance();
		String dong=request.getParameter("dong");
		try {
			ArrayList<AddressVO> addlist= addressDAO.selectAddressByDong(dong);
			request.setAttribute("addressList", addlist);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(request.getParameter("num")!=null) {
			url="boot/findZipNum2.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
