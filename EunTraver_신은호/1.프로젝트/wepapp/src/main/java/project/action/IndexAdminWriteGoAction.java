package project.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import project.DAO.IndexDAO;
import project.VO.AdminVO;
import project.VO.IndexVO;

public class IndexAdminWriteGoAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="NonageServlet2?command=IndexAdmin";
		IndexDAO indexDAO = IndexDAO.getInstance();
		int sizeLimit = 5*1024*1024;
		String savePath ="product_images";
		HttpSession session = request.getSession();
		ServletContext context = session.getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		MultipartRequest multi = new MultipartRequest(request,
				uploadFilePath,
				sizeLimit,
				"UTF-8",
				new DefaultFileRenamePolicy());
		AdminVO loginAdmin = (AdminVO) session.getAttribute("loginAdmin");
		IndexVO ind = new IndexVO();
		if(loginAdmin!=null) {
		ind.setSubject(multi.getParameter("title"));
		ind.setIndate(multi.getParameter("indate"));
		ind.setSite(multi.getParameter("site"));
		ind.setContent(multi.getParameter("textfield"));
		ind.setImage(multi.getFilesystemName("image"));
		indexDAO.insert(ind);
		}else {
			url="boot/adminLoginForm.jsp";
		}
		response.sendRedirect(url);
	}

}
