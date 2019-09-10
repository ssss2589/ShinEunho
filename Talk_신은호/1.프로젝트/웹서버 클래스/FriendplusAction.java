
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FriendplusAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		FriendDAO DAO = FriendDAO.getInstance();
		String Mid = request.getParameter("Mid").trim();
		String Fname = request.getParameter("Fname").trim();
		System.out.println(Mid);
		System.out.println(Fname);
		DAO.join(Mid,Fname);
	}
}
