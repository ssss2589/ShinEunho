package server2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ChatHandler extends Thread {
	private Socket s;// 클라이언트와 통신하는 소켓
	private BufferedReader i;
	private PrintWriter o;
	private ChatServer server;
	private String userId;
	String userName;
	String friendName;
	private String roomKey;
	public static final int SET_PROFILE = 100;
	ChatRoom chatRoom;

	public String getRoomKey() {
		return roomKey;
	}

	public void setRoomKey(String roomkey) {
		this.roomKey = roomkey;
	}

	public ChatHandler(ChatServer server, Socket s) throws IOException {
		this.s = s;
		this.server = server;
		InputStream ins = s.getInputStream();
		OutputStream os = s.getOutputStream();
		i = new BufferedReader(new InputStreamReader(ins, "UTF-8"));
		o = new PrintWriter(new OutputStreamWriter(os, "UTF-8"), true);
		server.register(this);

	}

	public void protocol(int protocol, JSONObject ob) {
		switch (protocol) {

		case SET_PROFILE: {
			JSONObject profile = (JSONObject) ob.get("profile");
			userName = profile.get("name").toString();
			friendName = profile.get("friend").toString();
			ChatRoom room = null;
			if (null != server.findChatRoom(userName + friendName)) {
				room = server.findChatRoom(userName + friendName);
			} else if (null != server.findChatRoom(friendName + userName)) {
				room = server.findChatRoom(friendName + userName);
			} else {
				room = server.addChatRoom(userName, friendName);
			}
			room.joinRoom(this);
			chatRoom = room;
			break;
		}
		case ChatServer.BROADCAST: {
			String msg = ob.get("msg").toString();
			chatRoom.broadCast(getUserName()+":"+msg);
			break;
		}

		case ChatServer.MESSENGER: {

			break;
		}

		}
	}

	public void run() {
		try {
			boolean stop = true;
			while (stop) {
				String msg = i.readLine();
				System.out.println(msg);
				JSONObject ob = (JSONObject) new JSONParser().parse(msg);
				int protocol = Integer.parseInt(ob.get("protocol").toString());
				protocol(protocol, ob);
			}
		} catch (IOException ex) {
		} catch (ParseException ex1) {
			ex1.printStackTrace();
		}
		server.unregister(this);// 컬렉션에서 나오겠다.
		chatRoom.outRoom(this);
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
