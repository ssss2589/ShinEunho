import java.io.File;
import java.io.IOException;

import javax.imageio.stream.FileImageInputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProfileAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "android/MemberList2.jsp";
		MemberDAO memberDAO = MemberDAO.getInstance();
		String id = request.getParameter("id");
		File file = new File("C:/IO/777.png");
		FileImageInputStream fil = new FileImageInputStream(file);
		 boolean stop = true;
	      int[] group = new int[1];
	      int i1 = 0;
	      StringBuilder builder = new StringBuilder();
	      while (stop) {
	         int a = fil.read();	   
	         if (a == -1) {
	            break;
	         }
	         builder.append(a+".");
	      }
	      
	      
	     request.setAttribute("bitmap", builder.toString());
		request.getRequestDispatcher(url).forward(request, response);
	}
}
