package gheAction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gheDAO.GHEMemberDAO;
import gheVO.GHEMemberVO;

public class LoginAction implements GHEAction{

	@Override
	public void gheAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("utf-8");
		request.setCharacterEncoding("utf-8");
		// TODO Auto-generated method stub
		String url="GHEServlet?command=index";
		HttpSession session = request.getSession();
		String id= request.getParameter("id");
		String pw= request.getParameter("pw");
		GHEMemberDAO ghemember = GHEMemberDAO.getInstance();
		GHEMemberVO mem= ghemember.login(id, pw);
		if(mem!=null) {
			session.setAttribute("loginUser",mem);
			System.out.println("�α��ε�");
		}else {
			request.setAttribute("loginFail", "���̵� �Ǵ� ��й�ȣ�� Ʋ���ϴ�.");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
