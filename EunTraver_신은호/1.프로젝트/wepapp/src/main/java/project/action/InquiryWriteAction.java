package project.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import project.DAO.QnaDAO;
import project.VO.MemberVO;
import project.VO.QnaVO;

public class InquiryWriteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="NonageServlet2?command=inquiry";
		QnaDAO qnaDAO = QnaDAO.getInstance();
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
		QnaVO qna = new QnaVO();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		if(loginUser==null) {
			url="boot/loginForm.jsp";
		}else {
		qna.setSubject(multi.getParameter("title"));
		qna.setContent(multi.getParameter("textfield"));
		qna.setId(loginUser.getId());
		qna.setImage(multi.getFilesystemName("image"));
		qnaDAO.qnaWrite(qna);
		}
		response.sendRedirect(url);
	}

}
