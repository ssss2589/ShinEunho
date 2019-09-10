package com.nonage.controller.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nonage.dao.ProductDAO;
import com.nonage.dto.ProductVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class AdminItemAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="NonageServlet?command=admin_ItemList";
		HttpSession session = request.getSession();
		int sizelimit = 5*1024*1024;
		ProductVO pro = new ProductVO();
		String savePath ="product_images";
		System.out.println(savePath);
		ServletContext context=session.getServletContext();//서블릿 기타자원사용할수있는 객체
		String uploadFilePath=context.getRealPath(savePath);
		System.out.println(uploadFilePath);
			MultipartRequest multi = new MultipartRequest(request,
					uploadFilePath,//2.업로드될 파일이 저장될 파일 경로명
					sizelimit,//최대 업로드 파일 크기
					"UTF-8",//인코딩타입지정
					//동인한 이름이 존재하면 새로운 이름 부여
					new DefaultFileRenamePolicy());//덮어쓰기를 방지하기위한 부분
		pro.setKind(multi.getParameter("kind"));
		pro.setName(multi.getParameter("name"));
		pro.setPrice1(Integer.parseInt(multi.getParameter("price1")));
		pro.setPrice2(Integer.parseInt(multi.getParameter("price2")));
		pro.setPrice3(Integer.parseInt(multi.getParameter("price3")));
		pro.setContent(multi.getParameter("content"));
		pro.setImage(multi.getFilesystemName("image"));
		ProductDAO productDAO = ProductDAO.getInstance();
		int result=productDAO.insertProduct(pro);
		if(result==0) {
			url="NonageServlet?command=admin_Itemplus_form";
		}else {
			response.sendRedirect(url);
		}
	}

}
