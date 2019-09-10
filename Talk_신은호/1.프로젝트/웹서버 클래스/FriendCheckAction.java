import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FriendCheckAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		System.out.println(""+name+" == "+id);
		boolean friend = FriendDAO.getInstance().search(id.trim(), name.trim());
		request.setAttribute("protocol", friend);
		request.getRequestDispatcher("android/FrendCheck.jsp").forward(request, response);;
	}

}
