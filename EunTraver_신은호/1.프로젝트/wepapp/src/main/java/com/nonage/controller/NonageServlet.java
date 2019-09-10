package com.nonage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nonage.controller.action.Action;

// Front Controller >> ���ʿ��� ��Ʈ�� ���ִ� �༮(��Ʈ�ѷ��� ȣ���� �ִ� �༮) , �Ʒ��� ��Ȱ ����� �Ұ� ����. �׼��� �����ϴ� ����? 
public class NonageServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ���� Ŀ�ǵ�� ��Ʈ���Ҽ� �ֵ�����.
		String command = request.getParameter("command");
		ActionFactory af = ActionFactory.getInstance();
		Action action = af.getAction(command);
		if( action != null) {
			action.execute(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}
}
