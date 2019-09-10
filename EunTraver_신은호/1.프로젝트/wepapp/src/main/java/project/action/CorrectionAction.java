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

public class CorrectionAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="NonageServlet2?command=mywrite";
		FreeDAO freeDAO = FreeDAO.getInstance();
		HttpSession session=request.getSession();
		int sizeLimit =5*1024*1024;
		String savePath = "product_images";
		ServletContext context = session.getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		MultipartRequest multi = new MultipartRequest(request,
				uploadFilePath,
				sizeLimit,
				"UTF-8",
				new DefaultFileRenamePolicy());
		System.out.println(multi.getParameter("myimage"));
		if(multi.getFilesystemName("image")!=null){
			freeDAO.freeUpdate(multi.getParameter("subject"), multi.getParameter("content"),
					multi.getFilesystemName("image"), multi.getParameter("qseq"));
		}else {
			freeDAO.freeUpdate(multi.getParameter("subject"), multi.getParameter("content"),
					multi.getParameter("myimage"), multi.getParameter("qseq"));
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
