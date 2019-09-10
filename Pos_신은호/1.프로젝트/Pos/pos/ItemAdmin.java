package pos;

import java.awt.BorderLayout;
import java.awt.FileDialog;
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
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ItemAdmin extends JFrame implements ActionListener {

	JFrame f;
	JPanel p, p1, p2, p3;
	List userlist;
	JButton b, b1, b2, b3, b4, b5, b6;
	JButton itemImage;
	JLabel l, l2, l3, l4, l5, l6, l7, l8, l9;
	TextField tf, tf2, tf3, itemImageurl;
	JComboBox group;

	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://192.168.0.78:3306/user7";
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;

	public ItemAdmin() {
		setTitle("상품 관리");
		f = new JFrame();

		p = new JPanel();
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();

		String[] name = { "버거", "음료", "사이드" };
		group = new JComboBox(name);

		userlist = new List();

		b = new JButton("상품 추가");
		b1 = new JButton("상품 삭제");
		b2 = new JButton("확인");
		b3 = new JButton("취소");
		b4 = new JButton("버거");
		b5 = new JButton("음료");
		b6 = new JButton("사이드");
		itemImage = new JButton("사진첨부");

		l = new JLabel("제품이름");
		l2 = new JLabel(" ");
		l3 = new JLabel(" ");
		l4 = new JLabel("가격");
		l5 = new JLabel(" ");
		l6 = new JLabel(" ");
		l7 = new JLabel("분류");
		l8 = new JLabel(" ");
		l9 = new JLabel(" ");

		tf = new TextField();
		tf2 = new TextField();
		tf3 = new TextField();
		itemImageurl = new TextField();

		p.add(b);
		p.add(b1);
		p3.add(b4);
		p3.add(b5);
		p3.add(b6);
		setLayout(new BorderLayout());
		add("North", p3);
		add("Center", userlist);
		add("South", p);

		setSize(300, 300);
		setVisible(true);
		b.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		itemImage.addActionListener(this);
	}

	public void list(String name, int i) {
		try {
			f.setTitle(name);
			userlist.removeAll();
			Class.forName(driver);
			con = DriverManager.getConnection(url, "user7", "user7");
			stmt = con.createStatement();
			String sql = "SELECT * FROM POS_ITEM WHERE TYPE = '" + i + "'";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				userlist.add(rs.getString("NAME") + "," + rs.getString("PRICE"));
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
	}

	public void additional() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "user7", "user7");
			stmt = con.createStatement();
			String name = tf.getText();
			String price = tf2.getText();
			int type = group.getSelectedIndex();
			String url = itemImageurl.getText().replace('\\', '/');
			System.out.println(itemImageurl.getText());
			String sql = "INSERT INTO POS_ITEM VALUES('" + name + "','" + price + "','" + type + "','" + url + "')";
			int result = stmt.executeUpdate(sql);
			String msg = result > -1 ? "successful" : "fail";
			System.out.println(msg);

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
	}

	public boolean itemDelete() {
		String post = userlist.getItem(userlist.getSelectedIndex());
		System.out.println(post);
		String delim = ",";
		StringTokenizer st = new StringTokenizer(post, delim, false);
		String token = st.nextToken();

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "user7", "user7");
			stmt = con.createStatement();
			String sql = "DELETE FROM POS_ITEM WHERE NAME = '" + token + "'";
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

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == b) {
			p1.setLayout(new GridLayout(7, 2, 10, 0));
			p1.add(l);
			p1.add(tf);
			p1.add(l2);
			p1.add(l3);
			p1.add(l4);
			p1.add(tf2);
			p1.add(l5);
			p1.add(l6);
			p1.add(l7);
			p1.add(group);
			p1.add(l8);
			p1.add(l9);
			p1.add(itemImageurl);
			p1.add(itemImage);

			p2.add(b2);
			p2.add(b3);

			f.setLayout(new BorderLayout());
			f.add("Center", p1);
			f.add("South", p2);

			f.setSize(300, 300);
			f.setVisible(true);
		} else if (obj == b1) {
			if (itemDelete() == true) {
				JOptionPane.showMessageDialog(null, "삭제가 완료되었습니다.");
			} else {
				JOptionPane.showMessageDialog(null, "삭제 실패");
			}
		} else if (obj == b2) {
			additional();
			JOptionPane.showMessageDialog(null, "추가 완료되었습니다.");
			if (AdminMenu.am != null) {
				JButton item = new JButton(new ImageIcon(itemImageurl.getText()));
				System.out.println(group.getSelectedItem());
				if (group.getSelectedItem().equals("버거")) {
					AdminMenu.am.p_menu.add(item);
					AdminMenu.am.p_buger2.add(item);

					AdminMenu.am.p_menu.revalidate();
					AdminMenu.am.p_menu.repaint();
					AdminMenu.am.p_buger2.revalidate();
					AdminMenu.am.p_buger2.repaint();
					item.addActionListener(AdminMenu.am);
				} else if (group.getSelectedItem().equals("음료")) {
					AdminMenu.am.p_drink.add(item);
					AdminMenu.am.p_drink2.add(item);
					AdminMenu.am.p_side2.add(item);
					AdminMenu.am.p_side3.add(item);

					AdminMenu.am.p_drink.revalidate();
					AdminMenu.am.p_drink.repaint();
					AdminMenu.am.p_drink2.revalidate();
					AdminMenu.am.p_drink2.repaint();
					item.addActionListener(AdminMenu.am);
				} else if (group.getSelectedItem().equals("사이드")) {
					AdminMenu.am.p_side2.add(item);
					AdminMenu.am.p_side3.add(item);
					
					AdminMenu.am.p_side2.revalidate();
					AdminMenu.am.p_side2.repaint();
					AdminMenu.am.p_side3.revalidate();
					AdminMenu.am.p_side3.repaint();
					item.addActionListener(AdminMenu.am);
				}
			}
			f.setVisible(false);
		} else if (obj == b3) {
			f.setVisible(false);
		} else if (obj == b4) {
			list("버거", 0);
		} else if (obj == b5) {
			list("음료", 1);
		} else if (obj == b6) {
			list("사이드", 2);
		} else if (obj == itemImage) {
			FileDialog fd = new FileDialog(this, "파일 열기", FileDialog.LOAD);
			fd.setVisible(true);
			String url = fd.getDirectory() + fd.getFile();
			itemImageurl.setText(url);
		}
	}
}