package project.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import project.DAO.FreeDAO;
import project.VO.FreeVO;
import project.VO.MemberVO;

public class FreePlusAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="NonageServlet2?command=freeList";
		HttpSession session = request.getSession();
		int sizeLimit =5*1024*1024;
		String savePath = "product_images";
		ServletContext context = session.getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		MultipartRequest multi = new MultipartRequest(request,
				uploadFilePath,
				sizeLimit,
				"UTF-8",
				new DefaultFileRenamePolicy());
		MemberVO loginUser= (MemberVO) session.getAttribute("loginUser");
		FreeDAO freeDAO = FreeDAO.getInstance();
		FreeVO free = new FreeVO();
		if(loginUser!=null) {
		free.setSubject(multi.getParameter("title"));
		free.setContent(multi.getParameter("textfield"));
		free.setClick(0);
		free.setId(loginUser.getName());
		free.setImage(multi.getFilesystemName("image"));
		freeDAO.insert(free);
		}
		else {
			url="boot/loginForm.jsp";
		}
		response.sendRedirect(url);
	}

}
