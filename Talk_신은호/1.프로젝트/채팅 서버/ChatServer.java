package server2;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class ChatServer {

	private Vector<ChatHandler> handlers;
	private HashMap<String, ChatRoom> chatRoom = new HashMap<String, ChatRoom>();
	ChatHandler c;
	StringBuilder names;
	public static final int BROADCAST = 1000;
	public static final int MESSENGER = 1001;

	public ChatRoom addChatRoom(String user, String user2) {
		ChatRoom room = new ChatRoom();
		chatRoom.put(user + user2, room);
		return room;
	}

	public ChatRoom findChatRoom(String key) {
		ChatRoom chatroom = null;
		chatroom = chatRoom.get(key);
		return chatroom;
	}

	public ChatServer(int port) {
		try {
			ServerSocket server = new ServerSocket(port);
			handlers = new Vector<ChatHandler>();
			System.out.println("ChatServer is ready.");
			while (true) {
				Socket client = server.accept();
				c = new ChatHandler(this, client); // 사용자 저장!
				c.start();// ChatHandler 쓰레드처럼사용?

			}
		} catch (Exception e) {
		}
	}

	public Object getHandler(int index) {
		return handlers.elementAt(index);
	}

	public void register(ChatHandler c) {
		handlers.addElement(c);
	}

	public void unregister(Object o) {
		handlers.removeElement(o);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChatServer(9830);

	}

}
