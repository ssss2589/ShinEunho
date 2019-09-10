package study2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.nonage.dto.MemberVO;

import study.DBAction;

public class joinAction {
	public static int joinAction2(joinVO VO){
		
	Connection conn = null;
	PreparedStatement stmt = null;

	int message=1;
	try {
		conn= DBAction.getInstance().getConnection();
		String sql = "insert into test_join(id,pw,name,date,sex,email) values(?,?,?,?,?,?)";
		stmt=conn.prepareStatement(sql);
		stmt.setString(1, VO.getId());
		stmt.setString(2, VO.getPw());
		stmt.setString(3, VO.getName());
		stmt.setString(4, VO.getDate());
		stmt.setString(5, VO.getSex());
		stmt.setString(6, VO.getEmail());
		stmt.executeUpdate();
		
	}catch(Exception e) {
		return 0;
	} finally {
		try {
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return message;
	}
	
	public static int logine(String id,String pw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int message=1;
		String sql = "select * from test_join where id ='" + id+"' and pw='"+pw+"'";
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return message;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
}
