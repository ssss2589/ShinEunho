package gheAction;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gheDAO.GHEBoardDAO;
import gheVO.GHEBoardVO;

public class IndexFormAction implements GHEAction{

	@Override
	public void gheAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.setContentType("text/html; charset=utf-8");
			request.setCharacterEncoding("utf-8");
			ArrayList<GHEBoardVO>good_board = GHEBoardDAO.getInstance().bestBoard();
			request.setAttribute("good_board", good_board);
			request.getRequestDispatcher("gheTeam/main.jsp").include(request, response);
	}

}
