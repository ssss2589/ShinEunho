package pos;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SalesAnalysis extends JFrame implements ActionListener{
	JPanel p,p2;
	TextField tf;
	TextArea ta;
	JButton b;
	JLabel l,l2;
	
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://192.168.0.78:3306/user7";
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public SalesAnalysis() {
		setTitle("판매 현황 관리");
		p=new JPanel();
		p2=new JPanel();
		
		tf=new TextField();
		
		ta= new TextArea();
		
		b=new JButton("검색");
		
		l=new JLabel(" ");
		l2=new JLabel(" ");
		
		p.setLayout(new GridLayout(1, 2,20,20));
		p.add(tf);
		p.add(b);
		//p.add(l);
		//p.add(l2);
		
		p2.add(ta);
		
		setLayout(new BorderLayout());
		add("North",p);
		add("Center",p2);
		
		setSize(500,300);
		setVisible(true);
		
		b.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==b) {
			day();
		}
	}

	public void day(){
		try {
			ta.setText("");
			Class.forName(driver);
			con=DriverManager.getConnection(url, "user7", "user7");
			stmt=con.createStatement();
			System.out.println(tf.getText());
			
			String sql = "SELECT * FROM POS_SALES_ITEM WHERE DAY LIKE '%" + tf.getText() + "%'";
			rs=stmt.executeQuery(sql);
			int sum=0;
			
			while(rs.next()) {
				String name = rs.getString("NAME");
				int price = rs.getInt("PRICE");
				sum += price ;
				ta.append("제품명 : "+name+" 가격:"+price +"\n");			
			}
			ta.append("합계 : " +sum+"원");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
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
}
