


// ����� ��û�� ���ؼ� ���� ������ ��� �б��Ű�� ��
public class AndroidFactory {
	private static AndroidFactory instance = new AndroidFactory();
	public static AndroidFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		if(command.equals("login")) {
			action= new LoginAction();
		}else if(command.equals("join")) {
			action= new JoinAction();
		}else if(command.equals("memberlist")) {
			action= new MemListAction();
		}else if(command.equals("profile")) {
			action= new ProfileAction();
		}else if(command.equals("plusfriend")) {
			action= new FriendplusAction();
		}else if (command.equals("friendCheck")) {
			action = new FriendCheckAction();
		}
		return action;
	}
}
