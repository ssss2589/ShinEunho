package study;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HelloWorld2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletConfig config;

    public HelloWorld2() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() »£√‚µ ");
		this.config = config;
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		System.out.println("getServletConfig() »£√‚µ ");
		return null;
	}

	public String getServletInfo() {
		// TODO Auto-generated method stub
		System.out.println("getServletInfo() »£√‚µ ");
		return "version=1.0;author=eomjinyoung;copyright=eomjinyoung 2013";
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("serveice() »£√‚µ ");
	}

}
