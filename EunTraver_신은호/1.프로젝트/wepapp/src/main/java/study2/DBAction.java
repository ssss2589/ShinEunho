package study2;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context; //원격지에 있는 객체를 사용할때 쓰는 기술 (서버에 있는 객체를 사용하기 위한것)
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBAction {
	private static DBAction instance = new DBAction();
	Connection conn = null;
	
	private DataSource ds;
	private Context ctx;
	public DBAction() {
		try {
			InitialContext initctx = new InitialContext();//서버에 문서를 초기화하겠다.
			ctx = (Context)initctx.lookup("java:/comp/env");//여기의 값은 변하지 않는다.
			ds = (DataSource)ctx.lookup("jdbc/oracle");//서버에 설정해놓은 이름! //커넥션들을 꺼내쓸수있는 장치.
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public static DBAction getInstance() {
		if(instance == null)
				instance = new DBAction();
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
		
		
	

