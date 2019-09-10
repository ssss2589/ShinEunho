package pos;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Vector;

public class ChatServer extends Thread{

 private Vector handlers;

 ChatHandler c;
 StringBuilder names;
 int port;
 
 public ChatServer(int port) {
  this.port=port;
 }
 
 @Override
 public void run() {
  try {
   ServerSocket server = new ServerSocket(port);
   handlers = new Vector();
   System.out.println("ChatServer is ready.");
   while (true) {
    Socket client = server.accept();
    c = new ChatHandler(this, client); // ����� ����!
    c.start();// ChatHandler ������ó�����?

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

 public void broadcast(String message) {
  synchronized (handlers) {// ���û��ÿ��� ���ó��

   if (message.equals("list")) {
    broadcastNames();
   } else {
    broadcastMsg(message);
   }
  }
 }

 public void broadcastNames() {
  ArrayList<String> user_arr = new ArrayList<String>();
  ChatHandler ch = null;
  for (Object user : handlers) {// ��Ʈ�� ���۳� ������ ����ؼ� ���ڿ��� ��ġ��!
   ch = (ChatHandler) user;
   user_arr.add(ch.getUserName());
  }
  for (Object user : handlers) {
   ch = (ChatHandler) user;
   for (String userName : user_arr) {
    ch.println(userName);

   }
  }
 }

 public void broadcastMsg(String message) {
  int n = handlers.size();
  for (int i = 0; i < n; i++) {
   ChatHandler c = (ChatHandler) handlers.elementAt(i);// �� ����ڿ��� �޼��� ����.
   try {
    c.println(message);
   } catch (Exception ex) {
   }
  }
 }
 
 public boolean findByName(String name) {
  for(Object user : handlers) {
   ChatHandler ch = (ChatHandler)user;
   String userName = ch.getUserName();
   if(userName.equals(name)) {
    return true;
   }
  }
  return false;
 }

 public static void main(String[] args) {
  // TODO Auto-generated method stub
  new ChatServer(9830);

 }

 

}
