package study;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context; //�������� �ִ� ��ü�� ����Ҷ� ���� ��� (������ �ִ� ��ü�� ����ϱ� ���Ѱ�)
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class PDBAction {
	private static PDBAction instance = new PDBAction();
	Connection conn = null;
	
	private DataSource ds;
	private Context ctx;
	public PDBAction() {
		try {
			InitialContext initctx = new InitialContext();//������ ������ �ʱ�ȭ�ϰڴ�.
			ctx = (Context)initctx.lookup("java:/comp/env");//������ ���� ������ �ʴ´�.
			ds = (DataSource)ctx.lookup("jdbc/oracle");//������ �����س��� �̸�! //Ŀ�ؼǵ��� ���������ִ� ��ġ.
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public static PDBAction getInstance() {
		if(instance == null)
				instance = new PDBAction();
		return instance;
	}
	public Connection getConnection() {
		try {
			conn = ds.getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	public void close() {
		try {
			if(conn != null) conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
		
		
	


