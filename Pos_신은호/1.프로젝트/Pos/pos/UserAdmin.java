package pos;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class UserAdmin extends JFrame implements ActionListener {
	JFrame f;
	JPanel p, p1, p2;
	List userlist;
	JButton b, b1, b2, b3;
	JLabel l, l2, l3, l4, l5, l6, l7, l8, l9, l10;
	TextField tf, tf2, tf3, tf4;

	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://192.168.0.78:3306/user7";
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;

	public UserAdmin() {
		setTitle("회원관리");
		f = new JFrame();

		p = new JPanel();
		p1 = new JPanel();
		p2 = new JPanel();

		userlist = new List();

		b = new JButton("회원 추가");
		b1 = new JButton("회원 삭제");
		b2 = new JButton("확인");
		b3 = new JButton("취소");

		l = new JLabel("아이디");
		l2 = new JLabel(" ");
		l3 = new JLabel(" ");
		l4 = new JLabel("비밀번호");
		l5 = new JLabel(" ");
		l6 = new JLabel(" ");
		l7 = new JLabel("이름");
		l8 = new JLabel(" ");
		l9 = new JLabel(" ");
		l10 = new JLabel("전화번호");

		tf = new TextField();
		tf2 = new TextField();
		tf3 = new TextField();
		tf4 = new TextField();

		p.add(b);
		p.add(b1);
		setLayout(new BorderLayout());
		add("Center", userlist);
		add("South", p);

		setSize(300, 300);
		setVisible(true);
		b.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		list();
		
	}

	public void list() {
		
		try {
			userlist.removeAll();
			Class.forName(driver);
			con = DriverManager.getConnection(url, "user7", "user7");
			stmt = con.createStatement();
			String sql = "SELECT * FROM POS";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				userlist.add(rs.getString("ID") + "," + rs.getString("PW") + "," + rs.getString("NAME") + ","
						+ rs.getString("PHONE") + "");
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
	}

	public boolean userDelete() {
		
		String post = userlist.getItem(userlist.getSelectedIndex());
		System.out.println(post);
		String delim = ",";
		StringTokenizer st = new StringTokenizer(post, delim, false);
		String token = st.nextToken();

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "user7", "user7");
			stmt = con.createStatement();
			String sql = "DELETE FROM POS WHERE ID = '" + token + "'";
			int result = stmt.executeUpdate(sql);
			String msg = result > -1 ? "successful" : "fail";
			System.out.println(msg);
			if (msg.equals("successful")) {
				return true;
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return false;
	}

	public boolean join() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "user7", "user7");
			stmt = con.createStatement();
			String id = tf.getText();
			String pw = tf2.getText();
			String name = tf3.getText();
			String phone = tf4.getText();

			String sql = "INSERT INTO POS VALUES('" + id + "','" + pw + "','" + name + "','" + 0 + "','" + phone + "')";
			int result = stmt.executeUpdate(sql);
			String msg = result > -1 ? "successful" : "fail";
			System.out.println(msg);
			if (msg.equals("successful")) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
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
		return false;
	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == b) {
			f.setTitle("회원 추가");
			p1.setLayout(new GridLayout(7, 2));
			p1.add(l);
			p1.add(tf);
			p1.add(l2);
			p1.add(l3);
			p1.add(l4);
			p1.add(tf2);
			p1.add(l5);
			p1.add(l6);
			p1.add(l7);
			p1.add(tf3);
			p1.add(l8);
			p1.add(l9);
			p1.add(l10);
			p1.add(tf4);
			p2.add(b2);
			p2.add(b3);

			f.setLayout(new BorderLayout());
			f.add("Center", p1);
			f.add("South", p2);

			f.setSize(300, 300);
			f.setVisible(true);
		} else if (obj == b1) {
			if (userDelete() == true) {
				JOptionPane.showMessageDialog(null, "삭제가 완료되었습니다.");
			} else {
				JOptionPane.showMessageDialog(null, "삭제가 실패");
			}
		} else if (obj == b2) {
			if (join() == true) {
				JOptionPane.showMessageDialog(null, "회원 추가 완료되었습니다.");
				f.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(null, "회원 추가 실패");
				f.setVisible(false);
			}
		} else if (obj == b3) {
			f.setVisible(false);
		}
	}

}
