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
		String savePath = "upload";;//���⸦ �ٲ��ָ� �ٿ�޴� ��ΰ� �ٲ�
		int uploadFileSizeLimit = 5*1024*1024;//�ִ� ���ε� ���� ũ�� 5MB�� ����
		String encType="UTF-8";
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);//�������� ���� ���丮
		try {
			MultipartRequest multi = new MultipartRequest(request,
					uploadFilePath,//�������� ���� ���丮
					uploadFileSizeLimit,//�ִ� ���ε� ���� ũ��
					encType,//���ڵ����
					//������ �̸��� �����ϸ� ���ο� �̸� �ο�
					new DefaultFileRenamePolicy());
			Enumeration files = multi.getFileNames();
			while(files.hasMoreElements()) {
				String file = (String) files.nextElement();
				String file_name = multi.getFilesystemName(file);
				String ori_file_name=multi.getOriginalFileName(file);
				out.print("<br> ���ε�� ���ϸ� : "+ file_name);
				out.print("<br> ���� ���ϸ� : "+ ori_file_name);
				out.print("<hr>"+ uploadFilePath);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
