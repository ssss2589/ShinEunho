package server2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class ChatRoom {
	Vector<ChatHandler> clients = new Vector<ChatHandler>();
	ArrayList<String> chatLog = new ArrayList<String>();
	ChatHandler chat;
	public ChatRoom(Vector<ChatHandler> clients) {
		this.clients = clients;

	}

	public ChatRoom() {

	}

	public void joinRoom(ChatHandler client) {
		clients.add(client);
		if (chatLog.size() != 0) {
			ArrayList<HashMap<String, String>> items = new ArrayList<HashMap<String, String>>();
			for (String chat : chatLog) {
				HashMap<String, String> item = new HashMap<String, String>();
				item.put("msg", chat);
				items.add(item);
			}
			String protocol = new ProtocolFactory(2000).addArr("msg", items).toString();
			System.out.println(protocol);
			client.println(protocol);
		}
	}

	public void outRoom(ChatHandler client) {
		clients.removeElement(client);
	}

	public void broadCast(String msg) {
		chatLog.add(msg);
		String protocol = new ProtocolFactory(ChatServer.BROADCAST).addObj("msg", msg).toString();
		for (ChatHandler client : clients) {
			client.println(protocol);
		}

	}

}