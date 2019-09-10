package pos;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BankApplicationEx extends JFrame implements ActionListener, KeyListener {
	public MyDialog dialog;
	public MyDialog2 dialog2;
	public MyDialog3 dialog3;
	public MyDialog4 dialog4;

	boolean run;
	JButton b1, b2, b3, b4, b5, b6;
	Panel p, p2, p3, p4, p5, p6;
	JFrame f, f1;
	TextField tf, tf2, tf3, tf4, tf5, tf6, tf7;
	JLabel L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14;
	Two t;
	MyCanvas c;
	Image img;
	int x, y;
	long remainSecond;
	// PropertiesEx2 pro;
	public Canvas can;
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://192.168.0.78:3306/user7";
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;

	public BankApplicationEx() throws Exception {
		c = new MyCanvas();
		t = new Two();
		run = true;
		setTitle("E.H.Bank");
		f = new JFrame();
		f1 = new JFrame();
		p = new Panel();// 사진 넣는 패널
		p2 = new Panel();// 회원가입과 로그인 버튼 패널
		p3 = new Panel();
		p4 = new Panel();
		p5 = new Panel();
		p6 = new Panel();
		b1 = new JButton("회원가입");
		b2 = new JButton("로그인");
		b3 = new JButton("완료");
		b4 = new JButton("취소");
		b5 = new JButton("확인");
		b6 = new JButton("취소");
		tf = new TextField();
		tf2 = new TextField();
		tf3 = new TextField();
		tf4 = new TextField();
		tf5 = new TextField();
		tf6 = new TextField();
		tf7 = new TextField();
		L1 = new JLabel("이름");
		L2 = new JLabel("아이디");
		L3 = new JLabel("비밀번호");
		L4 = new JLabel("계좌");
		L5 = new JLabel(" ");
		L6 = new JLabel(" ");
		L7 = new JLabel(" ");
		L8 = new JLabel(" ");
		L9 = new JLabel("아이디");
		L10 = new JLabel("비밀번호");
		L11 = new JLabel(" ");
		L12 = new JLabel(" ");
		L13 = new JLabel("주민번호(ㅡ생략)");
		// L14 = new JLabel(" ");
		dialog = new MyDialog(this);
		dialog2 = new MyDialog2(this);
		dialog3 = new MyDialog3(this);
		dialog4 = new MyDialog4(this);
		p2.setLayout(new GridLayout(1, 2));
		p2.add(b1);
		p2.add(b2);
		add("Center", c);
		add("South", p2);
		setSize(300, 300);
		setVisible(true);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		tf.addKeyListener(this);
		tf4.addKeyListener(this);
		tf7.addKeyListener(this);

		Thread thread = new Thread() {
			public void run() {
				try {
					int year = Calendar.getInstance().get(Calendar.YEAR);
					int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
					int date = Calendar.getInstance().get(Calendar.DATE);
					int hour = Calendar.getInstance().get(Calendar.HOUR);
					int minute = Calendar.getInstance().get(Calendar.MINUTE);
					int second = Calendar.getInstance().get(Calendar.SECOND);

					LocalDateTime startDateTime = LocalDateTime.of(year, month, date, hour, minute, second);
					LocalDateTime endDateTime = LocalDateTime.of(year, month, date, hour, (minute + 1), second);

					remainSecond = ChronoUnit.SECONDS.between(startDateTime, endDateTime);

					while (true) {

						t.L[21].setText("로그아웃까지 남은시간: " + String.valueOf(remainSecond));

						Thread.sleep(1000);
						remainSecond--;
						if (t.f[0].isVisible()) {
							remainSecond = 60;
						} else if (t.f[1].isVisible()) {
							remainSecond = 60;
						} else if (t.f[2].isVisible()) {
							remainSecond = 60;
						} else if (t.f[3].isVisible()) {
							remainSecond = 60;
						} else if (t.f[4].isVisible()) {
							remainSecond = 60;
						}
						if (remainSecond == 0) {
							t.setVisible(false);
							remainSecond = 60;
						}
					}
				} catch (InterruptedException e) {
				}

			}
		};
		thread.start();
	}

	public String mDate() {
		Calendar cal = Calendar.getInstance();// 객체생성없이 사
		StringBuilder sb = new StringBuilder();
		sb.append(+cal.get(Calendar.YEAR) + "년  ");
		sb.append((cal.get(Calendar.MONTH) + 1) + "월 ");
		sb.append(cal.get(Calendar.DATE) + "일  ");
		sb.append(cal.get(Calendar.HOUR) + "시  ");
		sb.append(cal.get(Calendar.MINUTE) + "분  ");
		// sb.append(cal.get(Calendar.SECOND)+"초 ");
		String result = sb.toString();

		return result;
	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == b1) {// 회원가입 눌렀을시
			tf.setText("");
			tf2.setText("");
			tf3.setText("");
			tf7.setText("");
			
			setTitle("회원가입");
			p3.setLayout(new GridLayout(4, 3, 0, 50));
			p3.add(L1);
			p3.add(tf);
			p3.add(L5);
			p3.add(L2);
			p3.add(tf2);
			p3.add(L6);
			p3.add(L3);
			p3.add(tf3);
			p3.add(L8);
			p3.add(L13);
			p3.add(tf7);
			p4.setLayout(new FlowLayout());
			p4.add(b3);
			p4.add(b4);
			f.add("Center", p3);
			f.add("South", p4);
			f.setSize(400, 400);
			f.setVisible(true);
		} else if (obj == b2) {
			tf5.setText("");
			tf6.setText("");
			
			setTitle("로그인");
			p5.setLayout(new GridLayout(3, 2, 0, 50));
			p5.add(L9);
			p5.add(tf5);
			p5.add(L10);
			p5.add(tf6);
			p5.add(L11);
			p5.add(L12);
			p6.setLayout(new FlowLayout());
			p6.add(b5);
			p6.add(b6);
			f1.add("Center", p5);
			f1.add("South", p6);
			f1.setSize(250, 250);
			f1.setVisible(true);
		} else if (obj == b3) {// 완료 버튼을 눌렀을시
			if (join() == true) {
				dialog2.setLocation(200, 200);// 팝업창 생성!
				dialog2.setVisible(true);
				dialog2.pack();// 글씨 보이게 크기를 잡아줌!
				f.setVisible(false);
				remainSecond = 60;
			} else {
				dialog4.setLocation(200, 200);// 팝업창 생성!
				dialog4.setVisible(true);
				dialog4.pack();// 글씨 보이게 크기를 잡아줌!
				f.setVisible(false);
			}
		} else if (obj == b4) {
			f.setVisible(false);
		} else if (obj == b5) {// 완료 버튼을 눌렀을시
			if (cheak() == true) {
				dialog.setLocation(200, 200);// 팝업창 생성!
				dialog.setVisible(true);
				dialog.pack();// 글씨 보이게 크기를 잡아줌!
				remainSecond = 60;
				f1.setVisible(false);
				if (tf5.getText().equals("asd")) {
					t.mb.add(t.m);// 메뉴를 메뉴바에 추가
					t.setMenuBar(t.mb);
					t.setVisible(true);
					ChatServer server = new ChatServer(9830);
					server.start();
				} else {
					t.remove(t.mb);
					t.setVisible(true);
				}
			} else {
				dialog3.setLocation(200, 200);// 팝업창 생성!
				dialog3.setVisible(true);
				dialog3.pack();// 글씨 보이게 크기를 잡아줌!
			}

		} else if (obj == b6) {
			f1.setVisible(false);
		}
	}

	public void keyTyped(KeyEvent e) {
		Object obj = e.getSource();
		int k = e.getKeyChar();

		if (obj == tf && k < 65 || k > 122) {
			tf.setText(" ");
		}
		if (obj == tf4 && k < 47 || k > 58) {
			tf4.setText(" ");
		}

		String rrn = tf7.getText();
		int length = rrn.length();
		if (length > 13) {
			tf7.setText(" ");
		}
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}

	class MyDialog extends JDialog {
		public MyDialog(JFrame frame) {
			super(frame);
			setLayout(new FlowLayout());
			add(new JLabel("로그인 성공!"));
		}
	}

	class MyDialog2 extends JDialog {
		public MyDialog2(JFrame frame) {
			super(frame);
			setLayout(new FlowLayout());
			add(new JLabel("회원가입 완료    " + mDate()));
		}
	}

	class MyDialog3 extends JDialog {
		public MyDialog3(JFrame frame) {
			super(frame);
			setLayout(new FlowLayout());
			add(new JLabel("입력하신 정보가 틀렸습니다."));
		}
	}

	class MyDialog4 extends JDialog {
		public MyDialog4(JFrame frame) {
			super(frame);
			setLayout(new FlowLayout());
			add(new JLabel("이미 가입된 계정이 있습니다."));
		}
	}

	public boolean join() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "user7", "user7");
			stmt = con.createStatement();
			System.out.println("이름을 입력하세요");
			String owner = tf.getText();
			System.out.println("아이디를 입력하세요");
			String id = tf2.getText();
			System.out.println("비밀번호를 입력하세요");
			String pw = tf3.getText();
			System.out.println("주민번호를 입력하세요");
			String rrn = tf7.getText();
			String sql = "SELECT * FROM ACCOUNT";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {// 레코드가 존재하는 만큼 반복수행!]
				if (rs.getString("ID").equals(id)) {
					if (rs.getString("RRN").equals(rrn) || rs.getString("RRN").equals(null)) {
						return false;
					}
				}
			}
			jdbccreate(id, pw, owner, 0, rrn, mDate());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();

			}
		}

		return true;
	}

	Account account;

	public boolean cheak() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "user7", "user7");
			stmt = con.createStatement();
			String id = tf5.getText();
			String pw = tf6.getText();
			String sql = "SELECT * FROM ACCOUNT WHERE ID = '" + id + "'";
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				if (rs.getString("PW").equals(pw)) {
					String id2 = rs.getString("ID");
					String pw2 = rs.getString("PW");
					String owner = rs.getString("NAME");
					String ano = rs.getString("ANO");
					int balance = rs.getInt("BALANCE");
					String rrn = rs.getString("RRN");
					String mdata = rs.getString("MDate");
					account = new Account(id2, owner, pw2, ano, balance, rrn, mdata);
					t.account = account;

					return true;
				} else {
					return false;
				}

			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return false;
	}

	public boolean jdbccreate(String id, String pw, String owner, int balance, String rrn, String mdata) {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "user7", "user7");
			stmt = con.createStatement();
			int su2 = (int) (Math.random() * 999) + 100;
			int su3 = (int) (Math.random() * 999) + 100;
			int su4 = (int) (Math.random() * 90000) + 10000;

			String ano = su2 + "-" + su3 + "-" + su4;

			String sql = "INSERT INTO ACCOUNT VALUES('" + // 특정된 컬럼의 값을 줄때는 테이블이름옆에 (ID)로 명시해줘야한다.
					id + "','" + pw + "','" + owner + "','" + ano + "','" + balance + "','" + rrn + "','" + mdata
					+ "')";

			int result = stmt.executeUpdate(sql);
			String msg = result > -1 ? "successful" : "fail";
			System.out.println(msg);

		} catch (Exception e) {
			System.out.println("데이터베이스 연결 실패!");
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return true;
	}

	public static void main(String args[]) throws Exception {
		new BankApplicationEx();

	}

}

class Account {
	private String ano;
	private String owner;
	private int balance;
	private String id;
	private String pw;
	private String rrn;
	private String mdata;

	public Account(String id, String owner, String pw, String ano, int balance, String rrn, String mdata) {
		this.balance = balance;
		this.ano = ano;
		this.id = id;
		this.rrn = rrn;
		this.owner = owner;
		this.pw = pw;
		this.mdata = mdata;
	}

	public String getMdata() {
		return mdata;
	}

	public void setMdata(String mdata) {
		this.mdata = mdata;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getRrn() {
		return rrn;
	}

	public void setRrn(String rrn) {
		this.rrn = rrn;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
}

class Two extends JFrame implements ActionListener {
	public MeDialog dialog;
	public MeDialog2 dialog2;
	public MeDialog3 dialog3;
	public MeDialog4 dialog4;
	public MeDialog5 dialog5;
	public MeDialog6 dialog6;
	public MeDialog7 dialog7;
	public MeDialog8 dialog8;
	public MeDialog9 dialog9;
	public MeDialog10 dialog10;
	public MeDialog11 dialog11;
	public MeDialog12 dialog12;
	public MeDialog13 dialog13;
	public MeDialog14 dialog14;
	public MeDialog15 dialog15;
	public MeDialog16 dialog16;
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21;
	Panel[] p;
	JFrame[] f;
	JLabel[] L;
	TextField[] tf;
	int i;
	MyCanvas2 c;
	TextArea ta, ta2, ta3, meta;
	boolean vs;
	public MenuBar mb;
	public Menu m;
	private MenuItem[] mi;
	FileDialog fd1, fd2;
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://192.168.0.78:3306/user7";
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;

	public Two() {
		setTitle("E.H.Bank");
		ta = new TextArea();
		ta2 = new TextArea();
		ta3 = new TextArea();
		meta = new TextArea();

		dialog = new MeDialog(this);
		dialog2 = new MeDialog2(this);
		dialog3 = new MeDialog3(this);
		dialog4 = new MeDialog4(this);
		dialog5 = new MeDialog5(this);
		dialog6 = new MeDialog6(this);
		dialog7 = new MeDialog7(this);
		dialog8 = new MeDialog8(this);
		dialog9 = new MeDialog9(this);
		dialog10 = new MeDialog10(this);
		dialog11 = new MeDialog11(this);
		dialog12 = new MeDialog12(this);
		dialog13 = new MeDialog13(this);
		dialog14 = new MeDialog14(this);
		dialog15 = new MeDialog15(this);
		dialog16 = new MeDialog16(this);

		c = new MyCanvas2();

		f = new JFrame[12];
		for (i = 0; i < f.length; i++) {
			f[i] = new JFrame();
		}

		p = new Panel[18];
		for (i = 0; i < p.length; i++) {
			p[i] = new Panel();
		}

		b1 = new JButton(" 예금  ");
		b2 = new JButton(" 출금  ");
		b3 = new JButton(" 이체  ");
		b4 = new JButton("회원 확인");
		b5 = new JButton("로그아웃");
		b6 = new JButton("정보변경");
		b7 = new JButton(" 확인 ");
		b8 = new JButton(" 취소 ");
		b9 = new JButton(" 확인 ");
		b10 = new JButton(" 취소 ");
		b11 = new JButton(" 확인 ");
		b12 = new JButton(" 취소 ");
		b13 = new JButton(" 확인 ");
		b14 = new JButton(" 취소 ");
		b15 = new JButton(" 확인 ");
		b16 = new JButton(" 취소 ");
		b17 = new JButton(" 확인 ");
		b18 = new JButton(" 취소 ");
		b19 = new JButton(" 확인 ");
		b20 = new JButton(" 취소 ");
		b21 = new JButton("상담원 연결");

		L = new JLabel[27];
		for (i = 0; i < L.length; i++) {
			L[i] = new JLabel();
		}

		L[0] = new JLabel("계좌번호");
		L[1] = new JLabel("입금액");
		L[2] = new JLabel("");
		L[3] = new JLabel("");
		L[4] = new JLabel("계좌번호");
		L[5] = new JLabel("출금액");
		L[6] = new JLabel("");
		L[7] = new JLabel("");
		L[8] = new JLabel("본인계좌");
		L[9] = new JLabel("받으실계좌");
		L[10] = new JLabel("이체액");
		L[11] = new JLabel("");
		L[12] = new JLabel("");
		L[13] = new JLabel("계좌번호");
		L[14] = new JLabel(" ");
		L[15] = new JLabel(" ");
		L[16] = new JLabel("아이디");
		L[17] = new JLabel("비밀번호");
		L[18] = new JLabel(" ");
		L[19] = new JLabel("변경아이디");
		L[20] = new JLabel("변경비밀번호");
		L[21] = new JLabel(" ");
		L[22] = new JLabel(" ");
		L[23] = new JLabel(" ");
		L[24] = new JLabel("회원 id");
		L[25] = new JLabel(" ");
		L[26] = new JLabel(" ");

		tf = new TextField[15];
		for (i = 0; i < tf.length; i++) {
			tf[i] = new TextField();
		}

		p[0].setLayout(new GridLayout(3, 1));
		p[0].add(b1);
		p[0].add(b2);
		p[0].add(b3);

		p[1].add(b21);

		p[2].setLayout(new GridLayout(3, 1));
		p[2].add(b4);
		p[2].add(b5);
		p[2].add(b6);
		// 메뉴바 생성
		mb = new MenuBar();
		m = new Menu("File");
		mi = new MenuItem[2];
		mi[0] = new MenuItem("회원 정보");
		mi[1] = new MenuItem("강제 탈퇴");

		p[13].setLayout(new FlowLayout());
		p[13].add(L[21]);

		for (int i = 0; i < mi.length; i++) {
			m.add(mi[i]);// 메뉴에 메뉴아이템 추가
			mi[i].addActionListener(this);
		}
		setLayout(new BorderLayout());
		add("Center", c);
		add("West", p[0]);
		add("East", p[2]);
		add("North", p[13]);
		add("South", p[1]);
		setSize(500, 500);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b10.addActionListener(this);
		b11.addActionListener(this);
		b12.addActionListener(this);
		b13.addActionListener(this);
		b14.addActionListener(this);
		b15.addActionListener(this);
		b16.addActionListener(this);
		b17.addActionListener(this);
		b18.addActionListener(this);
		b19.addActionListener(this);
		b20.addActionListener(this);
		b21.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == b1) {
			tf[0].setText("");
			tf[1].setText("");
			
			f[0].setTitle("예금");
			f[5].setTitle("예금");
			ta.setText("");
			p[3].setLayout(new GridLayout(3, 2, 0, 50));
			p[3].add(L[0]);
			p[3].add(tf[0]);
			p[3].add(L[1]);
			p[3].add(tf[1]);
			p[3].add(L[2]);
			p[3].add(L[3]);
			p[4].setLayout(new FlowLayout());
			p[4].add(b7);
			p[4].add(b8);
			f[0].add("Center", p[3]);
			f[0].add("South", p[4]);
			f[0].setSize(250, 250);
			f[0].setVisible(true);
			// f[5].add(ta);
			// f[5].setSize(250, 250);
			// f[5].setVisible(true);
		} else if (obj == b2) {
			tf[2].setText("");
			tf[3].setText("");
			
			f[1].setTitle("출금");
			f[6].setTitle("출금");
			ta2.setText("");
			p[5].setLayout(new GridLayout(3, 2, 0, 50));
			p[5].add(L[4]);
			p[5].add(tf[2]);
			p[5].add(L[5]);
			p[5].add(tf[3]);
			p[5].add(L[6]);
			p[5].add(L[7]);
			p[6].setLayout(new FlowLayout());
			p[6].add(b9);
			p[6].add(b10);
			f[1].add("Center", p[5]);
			f[1].add("South", p[6]);
			f[1].setSize(250, 250);
			f[1].setVisible(true);
			// f[6].add(ta2);
			// f[6].setSize(250, 250);
			// f[6].setVisible(true);
		} else if (obj == b3) {
			tf[4].setText("");
			tf[5].setText("");
			tf[6].setText("");
			
			f[2].setTitle("이쳬");
			f[7].setTitle("이체");
			ta3.setText("");
			p[7].setLayout(new GridLayout(4, 2, 0, 50));
			p[7].add(L[8]);
			p[7].add(tf[4]);
			p[7].add(L[9]);
			p[7].add(tf[5]);
			p[7].add(L[10]);
			p[7].add(tf[6]);
			p[7].add(L[11]);
			p[7].add(L[12]);
			p[8].setLayout(new FlowLayout());
			p[8].add(b11);
			p[8].add(b12);
			f[2].add("Center", p[7]);
			f[2].add("South", p[8]);
			f[2].setSize(300, 300);
			f[2].setVisible(true);
			// f[7].setSize(300, 300);
			// f[7].setVisible(true);
		} else if (obj == b4) {
			tf[7].setText("");
			
			f[3].setTitle("회원확인");
			p[9].setLayout(new GridLayout(2, 2, 0, 50));
			p[9].add(L[13]);
			p[9].add(tf[7]);
			p[9].add(L[14]);
			p[9].add(L[15]);
			p[10].setLayout(new FlowLayout());
			p[10].add(b13);
			p[10].add(b14);
			f[3].add("Center", p[9]);
			f[3].add("South", p[10]);
			f[3].setSize(200, 200);
			f[3].setVisible(true);
		} else if (obj == b5) {
			setVisible(false);

		} else if (obj == b6) {
			tf[8].setText("");
			tf[9].setText("");
			
			f[4].setTitle("회원정보 변경");
			p[11].setLayout(new GridLayout(3, 2, 0, 50));
			p[11].add(L[16]);
			p[11].add(tf[8]);
			p[11].add(L[17]);
			p[11].add(tf[9]);
			p[11].add(L[18]);
			p[12].setLayout(new FlowLayout());
			p[12].add(b15);
			p[12].add(b16);
			f[4].add("Center", p[11]);
			f[4].add("South", p[12]);
			f[4].setSize(300, 300);
			f[4].setVisible(true);

		} else if (obj == b7) {
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, "user7", "user7");
				stmt = con.createStatement();
				String sql = "SELECT * FROM ACCOUNT WHERE ANO = '" + tf[0].getText() + "'";
				rs = stmt.executeQuery(sql);
				if (rs.next()) {
					if (deposit()) {
						dialog.setLocation(200, 200);// 팝업창 생성!
						dialog.setVisible(true);
						dialog.pack();
					} else {
						dialog5.setLocation(200, 200);// 팝업창 생성!
						dialog5.setVisible(true);
						dialog5.pack();
						f[0].setVisible(false);
						f[5].setVisible(false);
					}
				} else {
					dialog5.setLocation(200, 200);// 팝업창 생성!
					dialog5.setVisible(true);
					dialog5.pack();
					f[0].setVisible(false);
					f[5].setVisible(false);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (obj == b8) {
			f[0].setVisible(false);
		} else if (obj == b9) {
			int i = withdraw();
			if (i == 1) {
				// ta2.append("\n" + mDate() + "\n" + "출금액 :" + tf[3].getText() + "\n잔액 :" +
				// account.getBalance());
				dialog2.setLocation(200, 200);// 팝업창 생성!
				dialog2.setVisible(true);
				dialog2.pack();
			} else if (i == 0) {
				dialog5.setLocation(200, 200);// 팝업창 생성!
				dialog5.setVisible(true);
				dialog5.pack();
				f[1].setVisible(false);
				f[6].setVisible(false);
			} else if (i == 2) {
				dialog6.setLocation(200, 200);// 팝업창 생성!
				dialog6.setVisible(true);
				dialog6.pack();
				f[1].setVisible(false);
				f[6].setVisible(false);
			}
		} else if (obj == b10) {
			f[1].setVisible(false);
		} else if (obj == b11) {
			int i = transfer();
			if (i == 0) {
				dialog5.setLocation(200, 200);// 팝업창 생성!
				dialog5.setVisible(true);
				dialog5.pack();
				f[2].setVisible(false);
				f[7].setVisible(false);

			} else if (i == 1) {
				dialog7.setLocation(200, 200);// 팝업창 생성!
				dialog7.setVisible(true);
				dialog7.pack();
				f[2].setVisible(false);
				f[7].setVisible(false);
			} else if (i == 2) {
				// ta3.append("\n" + mDate() + "\n" + "이체액 :" + tf[6].getText() + "\n잔액 :" +
				// account.getBalance());
				dialog3.setLocation(200, 200);// 팝업창 생성!
				dialog3.setVisible(true);
				dialog3.pack();
				f[2].setVisible(false);
				f[7].setVisible(false);
			} else if (i == 3) {
				dialog6.setLocation(200, 200);// 팝업창 생성!
				dialog6.setVisible(true);
				dialog6.pack();
				f[2].setVisible(false);
				f[7].setVisible(false);
			} else if (i == 4) {
				dialog8.setLocation(200, 200);// 팝업창 생성!
				dialog8.setVisible(true);
				dialog8.pack();
				f[2].setVisible(false);
				f[7].setVisible(false);
			}
		} else if (obj == b12) {
			f[2].setVisible(false);
		} else if (obj == b13) {
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, "user7", "user7");
				stmt = con.createStatement();
				
				String sql = "SELECT * FROM ACCOUNT WHERE ANO = '" + tf[7].getText() + "'";
				rs = stmt.executeQuery(sql);

				if (rs.next()) {
					if(!account.getAno().equals(tf[7].getText())) {
						dialog5.setLocation(200, 200);// 팝업창 생성!
						dialog5.setVisible(true);
						dialog5.pack();
						f[3].setVisible(false);
						return;
					}
					if (rs.getInt("BALANCE") >= 500000) {
						dialog4.setLocation(300, 300);// 팝업창 생성
						dialog4.setVisible(true);
						dialog4.la.setText("우수회원입니다.  잔액:" + rs.getInt("BALANCE") + "  가입 시간:" + rs.getString("MDate"));
						dialog4.pack();
						f[3].setVisible(false);
					} else {
						dialog9.setLocation(200, 200);// 팝업창 생성!
						dialog9.la.setText("일반회원입니다.  잔액:" + rs.getInt("BALANCE") + "  가입 시간:" + rs.getString("MDate"));
						dialog9.setVisible(true);
						dialog9.pack();
						f[3].setVisible(false);
					}
				} else {
					dialog5.setLocation(200, 200);// 팝업창 생성!
					dialog5.setVisible(true);
					dialog5.pack();
					f[3].setVisible(false);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		} else if (obj == b14) {
			f[3].setVisible(false);
		} else if (obj == b15) {// 정보변경 확인키
			if (cheak() == true) {
				dialog10.setLocation(200, 200);// 팝업창 생성!
				dialog10.setVisible(true);
				dialog10.pack();// 글씨 보이게 크기를 잡아줌!
				f[4].setVisible(false);
				if (!f[4].isVisible()) {
					p[14].setLayout(new GridLayout(3, 2, 0, 50));
					// dialog10.setVisible(false);
					p[14].add(L[19]);
					p[14].add(tf[10]);
					p[14].add(L[20]);
					p[14].add(tf[11]);
					p[14].add(L[22]);
					p[14].add(L[23]);
					p[15].setLayout(new FlowLayout());
					p[15].add(b17);
					p[15].add(b18);
					f[8].add("Center", p[14]);
					f[8].add("South", p[15]);
					f[8].setSize(300, 300);
					f[8].setVisible(true);
				}
			} else {
				dialog11.setLocation(200, 200);// 팝업창 생성!
				dialog11.setVisible(true);
				dialog11.pack();// 글씨 보이게 크기를 잡아줌!
			}
		} else if (obj == b16) {
			f[4].setVisible(false);
		} else if (obj == b17) {
			if (MyFormat()) {
				dialog12.setLocation(200, 200);// 팝업창 생성!
				dialog12.setVisible(true);
				dialog12.pack();
				f[8].setVisible(false);
			} else {
				System.out.println("바보");
			}
		} else if (obj == b18) {
			f[8].setVisible(false);
		}
		if (obj == mi[0]) {

			f[9].add(meta);
			meta.setText("");
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, "user7", "user7");
				stmt = con.createStatement();
				String sql = "SELECT * FROM ACCOUNT";
				rs = stmt.executeQuery(sql);
				ResultSetMetaData rsmd = rs.getMetaData();
				meta.append("id \t pw \t owner \t ano \t balance, rrn \t\t mdata \n");
				int columnCnt = rsmd.getColumnCount();
				while (rs.next()) {
					for (int i = 1; i <= columnCnt; i++) {
						String columnValue = rs.getString(i);
						meta.append(columnValue + "\t");
					}
					meta.append("\n");
				}
				f[9].setSize(250, 250);
				f[9].setVisible(true);
			} catch (Exception e1) {
				System.out.println("데이터베이스 연결 실패!");
			} finally {
				try {
					if (stmt != null)
						stmt.close();
					if (con != null)
						con.close();
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
			}

		} else if (obj == mi[1]) {
			p[16].setLayout(new GridLayout(2, 2, 0, 50));
			p[16].add(L[24]);
			p[16].add(tf[12]);
			p[16].add(L[25]);
			p[16].add(L[26]);
			p[17].setLayout(new FlowLayout());
			p[17].add(b19);
			p[17].add(b20);
			f[10].add("Center", p[16]);
			f[10].add("South", p[17]);
			f[10].setSize(250, 250);
			f[10].setVisible(true);

		} else if (obj == b19) {
			if (!tf[12].getText().equals("asd")) {
				try {
					Class.forName(driver);
					con = DriverManager.getConnection(url, "user7", "user7");
					stmt = con.createStatement();

					String sql = "DELETE FROM ACCOUNT " + "WHERE ID = '" + tf[12].getText() + "'";

					int result = stmt.executeUpdate(sql);
					String msg = result > -1 ? "successful " : "fail";
					System.out.println(msg);
					vs = true;

				} catch (Exception e1) {
					vs = false;
					e1.printStackTrace();

				} finally {
					try {
						if (stmt != null)
							stmt.close();
						if (con != null)
							con.close();
					} catch (Exception e1) {
						System.out.println(e1.getMessage());
					}
				}
				if (vs == true) {
					dialog13.setLocation(200, 200);// 팝업창 생성!
					dialog13.setVisible(true);
					dialog13.pack();
				} else {
					dialog14.setLocation(200, 200);// 팝업창 생성!
					dialog14.setVisible(true);
					dialog14.pack();
				}
			} else {
				dialog14.setLocation(200, 200);// 팝업창 생성!
				dialog14.setVisible(true);
				dialog14.pack();
			}
		} else if (obj == b20) {
			f[10].setVisible(false);
		} else if (obj == b21) {
			try {
				new ChatClient("localhost");
			} catch (Exception e1) {
				e1.printStackTrace();
				dialog15.setLocation(200, 200);// 팝업창 생성!
				dialog15.setVisible(true);
				dialog15.pack();
			}

		} 
	}

	public String mDate() {
		Calendar cal = Calendar.getInstance();// 객체생성없이 사
		StringBuilder sb = new StringBuilder();
		sb.append(cal.get(Calendar.YEAR) + "년  ");
		sb.append((cal.get(Calendar.MONTH) + 1) + "월 ");
		sb.append(cal.get(Calendar.DATE) + "일  ");
		sb.append(cal.get(Calendar.HOUR) + "시  ");
		sb.append(cal.get(Calendar.MINUTE) + "분  ");
		sb.append(cal.get(Calendar.SECOND) + "초 ");

		String result = sb.toString();

		return result;
	}

	Account account;

	public boolean deposit() {

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "user7", "user7");
			stmt = con.createStatement();
			String input = tf[0].getText();
			int money = 0;
			
			if (Integer.parseInt(tf[1].getText()) > 0) {
				money = Integer.parseInt(tf[1].getText());
			} else {
				return false;
			}
			String id = account.getId();
			if(!account.getAno().equals(input)) {
				return false;
			}
			String sql2 = "select * from ACCOUNT where ID ='" +id+ "'";

			rs = stmt.executeQuery(sql2);

			if (rs.next()) {
				
					int balance = rs.getInt("BALANCE") + money;
					String sql = "UPDATE ACCOUNT SET BALANCE='" + balance + "'"+ "WHERE ANO='" + input + "'";
					int result = stmt.executeUpdate(sql);
					String msg = result > -1 ? "successful" : "fail";
					System.out.println(msg);

					return true;
				} else {
					return false;
				}
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public int withdraw() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "user7", "user7");
			stmt = con.createStatement();
			String input = tf[2].getText();
			int money = 0;
			if (Integer.parseInt(tf[3].getText()) >= 0) {
				money = Integer.parseInt(tf[3].getText());
			} else {
				return 0;
			}
			String id = account.getId();
			if(!account.getAno().equals(input)) {
				return 0;
			}
			String sql2 = "select * from ACCOUNT where ID ='" +id+ "'";
			
			rs = stmt.executeQuery(sql2);

			if (account.getAno().equals(input)) {
				if (rs.next()) {
					int balance = rs.getInt("BALANCE") - money;
					if (balance >= 0) {
						String sql = "UPDATE ACCOUNT SET BALANCE='" + balance + "'" + "WHERE ANO='" + input + "'";
						int result = stmt.executeUpdate(sql);
						String msg = result > -1 ? "successful" : "fail";
						System.out.println(msg);
						return 1;

					} else {
						return 2;
					}
				} else {
					return 0;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public int transfer() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "user7", "user7");
			stmt = con.createStatement();

			String ano = tf[4].getText();
			String input = tf[5].getText();
			int m = 0;
			if (Integer.parseInt(tf[6].getText()) >= 0) {
				m = Integer.parseInt(tf[6].getText());
			} else {
				return 0;
			}
			if(!account.getAno().equals(ano)) {
				return 0;
			}
			if (ano.equals(input)) {
				return 4;
			}

			String sql2 = "SELECT BALANCE FROM ACCOUNT WHERE ANO = '" + ano + "'";
			rs = stmt.executeQuery(sql2);
			if (account.getAno().equals(ano)) {
				if (rs.next()) {
					int balance = rs.getInt("BALANCE") - m;
					if (balance >= 0) {
						String sql = "UPDATE ACCOUNT SET BALANCE='" + balance + "'" + "WHERE ANO='" + ano + "'";
						int result = stmt.executeUpdate(sql);

						String msg = result > -1 ? "successful" : "fail";
						System.out.println(msg);
						if (msg.equals("successful")) {
							transfer2(input, m);
						}
						return 2;
					} else {
						return 3;
					}

				} else {
					return 0;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public void transfer2(String input, int m) {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "user7", "user7");
			stmt = con.createStatement();

			String sql2 = "SELECT BALANCE FROM ACCOUNT WHERE ANO = '" + input + "'";
			rs = stmt.executeQuery(sql2);

			if (rs.next()) {
				int balance = rs.getInt("BALANCE") + m;
				String sql = "UPDATE ACCOUNT SET BALANCE='" + balance + "'" + "WHERE ANO='" + input + "'";
				int result = stmt.executeUpdate(sql);

				String msg = result > -1 ? "successful" : "fail";
				System.out.println(msg);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public boolean cheak() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "user7", "user7");
			stmt = con.createStatement();
			System.out.println("아이디를 입력하세요");
			String id = tf[8].getText();
			System.out.println("비밀번호를 입력하세요.");
			String pw = tf[9].getText();
			if(!account.getId().equals(id)) {
				return false;
			}
			String sql = "SELECT * FROM ACCOUNT WHERE ID = '" + id + "'";
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				if (rs.getString("PW").equals(pw)) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return false;
	}

	public boolean MyFormat() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "user7", "user7");
			stmt = con.createStatement();
			// 바꿀 아이디 비밀번호
			String id = tf[8].getText();
			// 바뀔 아이디 비밀번호
			String id2 = tf[10].getText();
			String pw = tf[11].getText();

			String sql = "UPDATE ACCOUNT SET ID='" + id2 + "',PW ='" + pw + "'" + "WHERE ID='" + id + "'";

			int result = stmt.executeUpdate(sql);
			String msg = result > -1 ? "successful" : "fail";
			System.out.println(msg);
			if (msg.equals("successful")) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("데이터 베이스 연결 실패");
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return false;
	}

	class MeDialog extends JDialog {
		public MeDialog(JFrame frame) {
			super(frame);
			setLayout(new FlowLayout());
			add(new JLabel("예금이 완료 되었습니다!"));
		}
	}

	class MeDialog2 extends JDialog {
		public MeDialog2(JFrame frame) {
			super(frame);
			setLayout(new FlowLayout());
			add(new JLabel("출금이 완료 되었습니다."));
		}
	}

	class MeDialog3 extends JDialog {
		public MeDialog3(JFrame frame) {
			super(frame);
			setLayout(new FlowLayout());
			add(new JLabel("이체가 완료 되었습니다."));
		}
	}

	class MeDialog4 extends JDialog {
		JLabel la;

		public MeDialog4(JFrame frame) {
			super(frame);
			setLayout(new FlowLayout());
			la = new JLabel("");
			add(la);

		}
	}

	class MeDialog5 extends JDialog {
		public MeDialog5(JFrame frame) {
			super(frame);
			setLayout(new FlowLayout());
			add(new JLabel("없는 계좌입니다."));
		}
	}

	class MeDialog6 extends JDialog {
		public MeDialog6(JFrame frame) {
			super(frame);
			setLayout(new FlowLayout());
			add(new JLabel("잔액이 부족합니다."));
		}
	}

	class MeDialog7 extends JDialog {
		public MeDialog7(JFrame frame) {
			super(frame);
			setLayout(new FlowLayout());
			add(new JLabel("받는분 계좌가 틀렸습니다."));
		}
	}

	class MeDialog8 extends JDialog {
		public MeDialog8(JFrame frame) {
			super(frame);
			setLayout(new FlowLayout());
			add(new JLabel("보내는분과 받는분의 계좌가 동일합니다"));
		}
	}

	class MeDialog9 extends JDialog {
		JLabel la;

		public MeDialog9(JFrame frame) {
			super(frame);
			setLayout(new FlowLayout());
			la = new JLabel("");
			add(la);
		}
	}

	class MeDialog10 extends JDialog {
		public MeDialog10(JFrame frame) {
			super(frame);
			setLayout(new FlowLayout());
			add(new JLabel("변경하고싶은 정보를 입력하세요."));
		}
	}

	class MeDialog11 extends JDialog {
		public MeDialog11(JFrame frame) {
			super(frame);
			setLayout(new FlowLayout());
			add(new JLabel("입력하신정보가 일치하지않습니다."));
		}
	}

	class MeDialog12 extends JDialog {
		public MeDialog12(JFrame frame) {
			super(frame);
			setLayout(new FlowLayout());
			add(new JLabel("변경이 완료되었습니다."));
		}
	}

	class MeDialog13 extends JDialog {
		public MeDialog13(JFrame frame) {
			super(frame);
			setLayout(new FlowLayout());
			add(new JLabel("삭제가 완료되었습니다."));
		}
	}

	class MeDialog14 extends JDialog {
		public MeDialog14(JFrame frame) {
			super(frame);
			setLayout(new FlowLayout());
			add(new JLabel("번호가 틀렸습니다."));
		}
	}

	class MeDialog15 extends JDialog {
		public MeDialog15(JFrame frame) {
			super(frame);
			setLayout(new FlowLayout());
			add(new JLabel("관리자가 부재중입니다."));
		}
	}

	class MeDialog16 extends JDialog {
		public MeDialog16(JFrame frame) {
			super(frame);
			setLayout(new FlowLayout());
			add(new JLabel("이미 2번째 계좌가 존재합니다."));
		}
	}

}

class MyCanvas extends Canvas {
	Image img[];

	public MyCanvas() {
		Toolkit tool = Toolkit.getDefaultToolkit();// 외부에 있는 툴킷을 사용!
		img = new Image[3];
		img[0] = tool.getImage(getClass().getResource("eun.png"));
	}

	public void paint(Graphics g) {
		g.drawImage(img[0], 0, 0, 290, 250, this);
	}
}

class MyCanvas2 extends Canvas {
	Image img;

	public MyCanvas2() {
		Toolkit tool = Toolkit.getDefaultToolkit();// 외부에 있는 툴킷을 사용!

		img = tool.getImage(getClass().getResource("eun2.jpg"));
	}

	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, 350, 500, this);
	}
}
