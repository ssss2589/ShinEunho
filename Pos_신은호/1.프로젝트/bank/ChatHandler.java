package pos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatHandler extends Thread {
	private Socket s;// 클라이언트와 통신하는 소켓
	private BufferedReader i;
	private PrintWriter o;
	private ChatServer server;
	private String userName;

	public ChatHandler(ChatServer server, Socket s) throws IOException {
		this.s = s;
		this.server = server;
		InputStream ins = s.getInputStream();
		OutputStream os = s.getOutputStream();
		i = new BufferedReader(new InputStreamReader(ins));
		o = new PrintWriter(new OutputStreamWriter(os), true);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void run() {
		try {
			String name = i.readLine();
			setUserName(name);
			server.register(this);// 실행되는수가 사용자의 수
			broadcast(name + "님이 방문하셨습니다.");
			while (true) {
				String msg = i.readLine();
				if (msg.equals("list")) {
					broadcast(msg);
				} else
					broadcast(name + "-" + msg);

			}
		} catch (IOException ex) {}
		server.unregister(this);// 컬렉션에서 나오겠다.
		broadcast(getName() + "님이 나가셨습니다");
		try {
			i.close();
			o.close();
			s.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	protected void println(String message) {
		o.println(message);
	}

	protected void broadcast(String message) {
		server.broadcast(message);
	}
}
