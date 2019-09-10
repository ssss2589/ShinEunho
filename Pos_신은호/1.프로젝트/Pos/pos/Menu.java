package pos;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.StringTokenizer;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Menu extends JFrame implements ActionListener {
	JFrame f, f1;
	JPanel p_list, p_sum, p_mlist, p_menu, p, p1, p2, p3, p4, p5;
	List list;
	JLabel l, l1, l2, l3;
	JLabel L, L2, L3, L4, L5, L6, L7;// 영수증
	TextField tf;
	TextArea ta;
	JButton[] b;
	JButton[] bug;
	JButton[] dri;
	JButton[] sid;
	CardLayout cards, cards2, cards3, cards4;
	JPanel p_menu_f, p_drink, p_side, p_fasing;
	JPanel p_buger, p_buger2, p_drinking, p_drink2, p_side2, p_side3;
	JScrollPane scrollPane; // 스크롤판 추가
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://192.168.0.78:3306/user7";
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;

	static AdminMenu am;
	
	int num = 0;
	int sum = 0;

	public Menu() {		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "user7", "user7");
			stmt = con.createStatement();

			String sql = "SELECT * FROM POS_ITEM WHERE TYPE = '" + 0 + "'";
			rs = stmt.executeQuery(sql);

			cards = new CardLayout();
			cards2 = new CardLayout();
			cards3 = new CardLayout();
			cards4 = new CardLayout();
			f = new JFrame();
			f1 = new JFrame();

			p_menu_f = new JPanel();
			p_drink = new JPanel();
			p_side = new JPanel();
			p_buger = new JPanel();
			p_drinking = new JPanel();
			p_list = new JPanel();
			p_sum = new JPanel();
			p_mlist = new JPanel();
			p_menu = new JPanel();
			p = new JPanel();
			p_fasing = new JPanel();
			p_buger2 = new JPanel();
			p_drink2 = new JPanel();
			p_side2 = new JPanel();
			p_side3 = new JPanel();
			p1 = new JPanel();
			p2 = new JPanel();
			p3 = new JPanel();
			p4 = new JPanel();
			p5 = new JPanel();
			p_menu_f.setLayout(cards);
			p_buger.setLayout(cards2);
			p_drinking.setLayout(cards3);
			p_side.setLayout(cards4);

			l = new JLabel("합계");
			l1 = new JLabel("  ");
			l2 = new JLabel("  ");
			l3 = new JLabel("  ");

			ta = new TextArea();
			scrollPane = new JScrollPane(ta);
			scrollPane.updateUI();
			ta.setEditable(false);

			L = new JLabel("[   영수증    ]");
			L2 = new JLabel("은도날드");
			L3 = new JLabel("대표자: 신은호");
			L4 = new JLabel("TEL: 010-3977-4358");
			L5 = new JLabel("주소: 서울 노원구 이젠빌딩 1층");
			L6 = new JLabel("상품");
			L7 = new JLabel("금액");

			b = new JButton[8];
			for (int i = 0; i < b.length; i++) {
				b[i] = new JButton();
			}
			b[0] = new JButton("계산");
			b[1] = new JButton("삭제");
			b[2] = new JButton("버거");
			b[3] = new JButton("음료");
			b[4] = new JButton("사이드");
			b[5] = new JButton("<");
			b[6] = new JButton(">");
			b[7] = new JButton("출력");

			list = new List();
			
			tf = new TextField();
			int i = 0;
			bug = new JButton[30];
			while (rs.next()) {
				bug[i] = new JButton(new ImageIcon(rs.getString("IMAGEURL")));
				if (i < 9) {
					p_menu.add(bug[i]);
				} else {					
					p_buger2.add(bug[i]);
				}
				bug[i].addActionListener(this);
				i++;
			}
			p_menu.setLayout(new GridLayout(3, 3, 20, 20));
			p_buger2.setLayout(new GridLayout(3, 3, 20, 20));

			String sql2 = "SELECT * FROM POS_ITEM WHERE TYPE = '" + 1 + "'";
			rs = stmt.executeQuery(sql2);
			i = 0;
			dri = new JButton[30];
			while (rs.next()) {
				dri[i] = new JButton(new ImageIcon(rs.getString("IMAGEURL")));
				if (i < 9) {
					p_drink.add(dri[i]);
				} else {
					p_drink2.add(dri[i]);
				}
				dri[i].addActionListener(this);
				i++;
			}
			p_drink.setLayout(new GridLayout(3, 3, 20, 20));
			p_drink2.setLayout(new GridLayout(3, 3, 20, 20));

			String sql3 = "SELECT * FROM POS_ITEM WHERE TYPE = '" + 2 + "'";
			rs = stmt.executeQuery(sql3);

			i = 0;
			sid = new JButton[30];
			while (rs.next()) {
				sid[i] = new JButton(new ImageIcon(rs.getString("IMAGEURL")));
				if (i < 9) {
					p_side2.add(sid[i]);
				} else {
					p_side3.add(sid[i]);
				}
				sid[i].addActionListener(this);
				i++;
			}
			p_side2.setLayout(new GridLayout(3, 3, 20, 20));
			p_side3.setLayout(new GridLayout(3, 3, 20, 20));

			p_sum.setLayout(new GridLayout(2, 2));
			p_sum.add(l);
			p_sum.add(tf);
			p_sum.add(b[0]);
			p_sum.add(b[1]);

			p_list.setLayout(new BorderLayout());
			p_list.add("North", l3);
			p_list.add("Center", list);
			p_list.add("South", p_sum);
			
			p_side.add(p_side2, "side1");
			p_side.add(p_side3, "side2");

			p_buger.add(p_menu, "buger1");
			p_buger.add(p_buger2, "buger2");

			p_drinking.add(p_drink, "drink1");
			p_drinking.add(p_drink2, "drink2");

			p_menu_f.add(p_buger, "buger");
			p_menu_f.add(p_drinking, "drink");
			p_menu_f.add(p_side, "side");
			
			p_side2.repaint();
			p_side2.validate();
			p_side2.revalidate();
			p_buger.repaint();
			p_buger.validate();
			p_buger.revalidate();
			p_menu_f.repaint();
			p_menu_f.validate();
			p_menu_f.revalidate();
			
			p_mlist.add(b[2]);
			p_mlist.add(b[3]);
			p_mlist.add(b[4]);

			p_fasing.add(b[5]);
			p_fasing.add(b[6]);

			p.setLayout(new BorderLayout());
			p.add("North", p_mlist);
			p.add("Center", p_menu_f);
			p.add("South", p_fasing);
			p.add("West", l1);
			p.add("East", l2);

			setLayout(new GridLayout(1, 2));
			add(p_list);
			add(p);

			setSize(800, 800);
			setVisible(true);
			

			for (i = 0; i < b.length; i++) {
				b[i].addActionListener(this);
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
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {		
		Object obj = e.getSource();
		if (obj == b[0]) {
			JOptionPane.showMessageDialog(null, "결제가 완료 되었습니다.");
			salesdb();
			receipt();// 영수증

		} else if (obj == b[1]) {
			String item = list.getSelectedItem();
			String delim = ",";
			StringTokenizer st = new StringTokenizer(item, delim, false);
			st.nextToken();
			String token = st.nextToken();
			sum -= Integer.parseInt(token);
			tf.setText(Integer.toString(sum));
			list.remove(list.getSelectedItem());
			// tf.setText();
		} else if (obj == b[2]) {
			cards.show(p_menu_f, "buger");
			num = 0;
		} else if (obj == b[3]) {
			cards.show(p_menu_f, "drink");
			num = 1;
		} else if (obj == b[4]) {
			cards.show(p_menu_f, "side");
			num = 2;
		} else if (obj == b[5]) {
			if (num == 0) {
				cards2.show(p_buger, "buger1");
			} else if (num == 1) {
				cards3.show(p_drinking, "drink1");
			} else {
				cards4.show(p_side, "side1");
			}
		} else if (obj == b[6]) {
			if (num == 0) {
				cards2.show(p_buger, "buger2");
			} else if (num == 1) {
				cards3.show(p_drinking, "drink2");
			} else {
				cards4.show(p_side, "side2");
			}
		} else if (obj == b[7]) {
			sum = 0;
			tf.setText("");
			list.removeAll();
			f1.setVisible(false);
		}else if(obj instanceof JButton){

			itemPro((JButton)e.getSource());

		}

		
	}
	/**
	 * item process 
	 * @param item
	 */
	public void itemPro(JButton item) {
		Icon name = item.getIcon();
		int balance = sales(name);
		sum += balance;
		tf.setText(Integer.toString(sum));
	}

	public void salesdb() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "user7", "user7");
			stmt = con.createStatement();
			LocalDateTime now = LocalDateTime.now();

			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 M월 d일 h시 m분");
			String nowString = now.format(dateTimeFormatter);
			System.out.println(nowString);

			String[] i = list.getItems();
			for (int j = 0; j < i.length; j++) {
				String delim = ",";
				StringTokenizer st = new StringTokenizer(i[j], delim, false);
				String name = st.nextToken();

				String price = st.nextToken();
				String sql = "INSERT INTO POS_SALES_ITEM VALUES('" + name + "','" + price + "','" + nowString + "')";
				int result = stmt.executeUpdate(sql);
				String msg = result > -1 ? "successful" : "fail";
				System.out.println(msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public int sales(Icon name) {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "user7", "user7");
			stmt = con.createStatement();

			String sql = "SELECT * FROM POS_ITEM WHERE IMAGEURL = '" + name + "'";
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				String a = rs.getString("NAME");
				int b = rs.getInt("PRICE");

				list.add(a + "," + b);
				return b;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public void receipt() {
		ta.setText("");

		p1.setLayout(new BorderLayout());
		p1.add("Center", L);
		p1.add("South", L2);

		p2.setLayout(new GridLayout(2, 2));
		p2.add(L3);
		p2.add(L4);
		p2.add(L5);

		p4.setLayout(new GridLayout(1, 2));
		p4.add(L6);
		p4.add(L7);

		int h = 0;
		String[] i = list.getItems();
		for (int j = 0; j < i.length; j++) {
			String delim = ",";
			StringTokenizer st = new StringTokenizer(i[j], delim, false);
			String name = st.nextToken();
			String price = st.nextToken();
			h += Integer.parseInt(price);
			ta.append(name + "\t");
			ta.append(price + "\n");

		}
		ta.append("\n");
		ta.append("\n");

		ta.append("합계" + h);

		p3.add(scrollPane);

		p5.add(b[7]);

		f1.setLayout(new GridLayout(5, 1));
		f1.add(p1);
		f1.add(p2);
		f1.add(p4);
		f1.add(p3);
		f1.add(p5);

		f1.setSize(450, 800);
		f1.setVisible(true);
		f1.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

	}

}
