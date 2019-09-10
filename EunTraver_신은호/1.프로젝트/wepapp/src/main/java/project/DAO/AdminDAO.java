package project.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import project.VO.AdminVO;
import study.DBAction;

public class AdminDAO {
	private AdminDAO() {
		
	}
	private static AdminDAO instance=new AdminDAO();
	public static AdminDAO getInstance() {
		return instance;
	}
	public AdminVO adminLogin(String id, String pw) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		String sql="select * from pro_worker where id=? and pwd=?";
		try {
			conn=DBAction.getInstance().getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				AdminVO adm = new AdminVO();
				adm.setId(rs.getString("ID"));
				adm.setName(rs.getString("NAME"));
				adm.setPhone(rs.getString("PHONE"));
				adm.setPw(rs.getString("PWD"));
				return adm;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
				try {
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
					if(conn!=null)
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return null;
	}
}
