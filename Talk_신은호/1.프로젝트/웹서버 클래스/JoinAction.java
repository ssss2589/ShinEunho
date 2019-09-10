
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MemberDAO memberDAO = MemberDAO.getInstance();
		MemberVO mem = new MemberVO();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String img = request.getParameter("image");
		if(img!=null) {
		 StringBuilder builder = new StringBuilder(img);
         int[] group = new int[0];
         for (int i = 0, x = 0; i < img.length(); i++) {
            if (img.charAt(i) == '.') {
               int su = Integer.parseInt(builder.substring(x, i).toString());
               int[] y = new int[group.length + 1];
               System.arraycopy(group, 0, y, 0, group.length);
               group = y;
               y[y.length - 1] = su;
               x = i + 1;
            }
         }

         String path = "C:/IO/"+request.getParameter("id");
         File file2 = new File(path + ".png");

		FileImageOutputStream writer = new FileImageOutputStream(file2);
		for (int i = 0; i < group.length; i++) {
			writer.write(group[i]);
		}
		System.out.println(file2.getName());
		writer.flush();
		writer.close();
		mem.setId(id);
		mem.setName(name);
		mem.setPw(pw);
		mem.setImg(file2.getName());
		}
		else{
		mem.setId(id);
		mem.setName(name);
		mem.setPw(pw);
		}
		memberDAO.join(mem);
	}
}
