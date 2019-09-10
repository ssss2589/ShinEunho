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
	private Socket s;// Ŭ���̾�Ʈ�� ����ϴ� ����
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
			server.register(this);// ����Ǵ¼��� ������� ��
			broadcast(name + "���� �湮�ϼ̽��ϴ�.");
			while (true) {
				String msg = i.readLine();
				if (msg.equals("list")) {
					broadcast(msg);
				} else
					broadcast(name + "-" + msg);

			}
		} catch (IOException ex) {}
		server.unregister(this);// �÷��ǿ��� �����ڴ�.
		broadcast(getName() + "���� �����̽��ϴ�");
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
