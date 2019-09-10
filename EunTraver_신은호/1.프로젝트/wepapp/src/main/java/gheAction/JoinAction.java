package gheAction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gheDAO.GHEMemberDAO;
import gheVO.GHEMemberVO;

public class JoinAction implements GHEAction{

	@Override
	public void gheAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		String url="gheTeam/main.jsp";
		GHEMemberVO mem = new GHEMemberVO();
		mem.setId(request.getParameter("id"));
		mem.setPw(request.getParameter("pw"));
		mem.setName(request.getParameter("name"));
		mem.setGrade("1");
		mem.setNickname(request.getParameter("nickname"));
		try {
			GHEMemberDAO.getInstance().join(mem);
		}catch(Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
