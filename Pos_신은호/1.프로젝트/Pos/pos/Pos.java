package pos;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Pos extends JFrame implements ActionListener {
	JPanel p,p1;
	JLabel l,l1,l2,l3;
	TextField tf,tf1;
	JButton b,b1;
	
	public Pos() {
		setTitle("E.H.POS");
		     
		l=new JLabel("아이디");
		l1=new JLabel("비밀번호");
		l2=new JLabel(" ");
		l3=new JLabel(" ");
		
		b=new JButton("로그인");
		b1=new JButton("종료");
		tf=new TextField();
		tf1=new TextField();
		p=new JPanel();
		p1=new JPanel();
		
		p.setLayout(new GridLayout(4, 2));
		p.add(l);
		p.add(tf);
		p.add(l2);
		p.add(l3);
		p.add(l1);
		p.add(tf1);
		
		p1.setLayout(new FlowLayout());
		p1.add(b);
		p1.add(b1);
		add("Center",p);
		add("South",p1);
		
		setSize(300, 300);
		setVisible(true);
		
		b.addActionListener(this);
		b1.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();
		if(obj==b) {
			int a=login();
			if(a==0) {
				AdminMenu.am = new AdminMenu();
				setVisible(false);
			}else if(a==1) {
				new Menu();
				setVisible(false);
			}else if(a==2){
				JOptionPane.showMessageDialog(null,"입력하신 정보가 틀렸습니다");
			}
		}
		else if(obj ==b1){
			setVisible(false);
		}
	}
	
	public int login() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://192.168.0.78:3306/user7";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "user7", "user7");
			stmt= conn.createStatement();
			String id = tf.getText();
			String pw = tf1.getText();
			String sql = "SELECT * FROM POS WHERE ID = '"+ id + "'";
			rs=stmt.executeQuery(sql);
			if(rs.next()) {
				if(rs.getString("PW").equals(pw)) {
					if(rs.getString("AUTHORITY").equals("1")) {
						return 0;
					}
					return 1;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return 2;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Pos();
		
	}
	
}
