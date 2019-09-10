package study2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String savePath = "upload";;//여기를 바꿔주면 다운받는 경로가 바뀜
		int uploadFileSizeLimit = 5*1024*1024;//최대 업로드 파일 크기 5MB로 제한
		String encType="UTF-8";
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);//서버상의 실제 디렉토리
		try {
			MultipartRequest multi = new MultipartRequest(request,
					uploadFilePath,//서버상의 실제 디렉토리
					uploadFileSizeLimit,//최대 업로드 파일 크기
					encType,//인코딩방법
					//동인한 이름이 존재하면 새로운 이름 부여
					new DefaultFileRenamePolicy());
			Enumeration files = multi.getFileNames();
			while(files.hasMoreElements()) {
				String file = (String) files.nextElement();
				String file_name = multi.getFilesystemName(file);
				String ori_file_name=multi.getOriginalFileName(file);
				out.print("<br> 업로드된 파일명 : "+ file_name);
				out.print("<br> 원본 파일명 : "+ ori_file_name);
				out.print("<hr>"+ uploadFilePath);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
