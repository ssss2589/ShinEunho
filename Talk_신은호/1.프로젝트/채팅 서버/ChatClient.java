package server2;

import java.awt.BorderLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame implements Runnable, ActionListener {

	private BufferedReader i;
	private PrintWriter o;
	private JTextArea output, output2;
	private JTextField input;
	private JLabel label;
	private Thread listener;
	private String host;
	private JScrollPane j;
	private JScrollBar jb;
	public MenuBar mb;
	public Menu m;
	private MenuItem[] mi;
	JFrame f;
	String requestMsg;

	public ChatClient(String server) {

		super("채팅프로그램");
		host = server;
		output = new JTextArea();
		output2 = new JTextArea();
		f = new JFrame();
		j = new JScrollPane(output);
		add(j);
		jb = j.getVerticalScrollBar();
		j.updateUI();
		output.setEditable(false);
		Panel bottom = new Panel(new BorderLayout());
		label = new JLabel("사용자 이름");
		bottom.add(label, "West");
		input = new JTextField();
		input.addActionListener(this);
		bottom.add(input, "Center");
		add(bottom, "South");

		mb = new MenuBar();
		m = new Menu("Menu");
		mi = new MenuItem[1];
		mi[0] = new MenuItem("회원정보");
		mb.add(m);// 메뉴를 메뉴바에 추가
		setMenuBar(mb);
		m.add(mi[0]);
		mi[0].addActionListener(this);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 300);
		setVisible(true);
		listener = new Thread(this);
		listener.start();

		
	}

	public void run() {
		try {
			Socket s = new Socket(host, 9870);
			InputStream ins = s.getInputStream();
			OutputStream os = s.getOutputStream();
			i = new BufferedReader(new InputStreamReader(ins,"UTF-8"));
			o = new PrintWriter(new OutputStreamWriter(os,"UTF-8"), true);
			while (true) {

				String line = i.readLine();
				if (requestMsg.equals("list"))
					output2.append(line + '\n');
				else {
					output.append(line + "\n");
				}
				jb.setValue(jb.getMaximum());

			}

		} catch (IOException e) {
		}

	}

	public void actionPerformed(ActionEvent e) {
		Object c = e.getSource();
		if (c == mi[0]) {
			requestMsg = "list";
			o.println("list");
			output2.setText("");
			f.add(output2);
			f.setSize(250, 250);
			f.setVisible(true);

		}
		if (c == input) {
			requestMsg = "msg";
			label.setText("메시지");
			o.println(input.getText());
			input.setText("");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length > 0) {
			new ChatClient(args[0]);
		} else {
			new ChatClient("localhost");
		}
	}

}
