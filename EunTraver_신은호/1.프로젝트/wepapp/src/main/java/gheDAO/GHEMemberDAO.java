package gheDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import gheVO.GHEMemberVO;
import study.DBAction;

public class GHEMemberDAO {
	private static GHEMemberDAO instance = new GHEMemberDAO();
	public static GHEMemberDAO getInstance() {
		return instance;
	}
	
	public void join(GHEMemberVO mem) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="insert into ghemember(id,pw,name,grade,nickname) values(?,?,?,?,?)";
		try {
			conn=DBAction.getInstance().getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, mem.getId());
			pstmt.setString(2, mem.getPw());
			pstmt.setString(3, mem.getName());
			pstmt.setString(4, mem.getGrade());
			pstmt.setString(5, mem.getNickname());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
			if(pstmt != null)
				pstmt.close();
			if(conn != null)
				conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
	}
	public GHEMemberVO login(String id,String pw) {
		Connection conn=null;
		PreparedStatement stmt =null;
		ResultSet rs = null;
		String sql="select * from ghemember where id='"+id+"' and pw ='"+pw+"'";
		try {
			conn=DBAction.getInstance().getConnection();
			stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			if(rs.next()) {
				GHEMemberVO mem= new GHEMemberVO();
				mem.setId(id);
				mem.setPw(pw);
				mem.setName(rs.getString("NAME"));
				mem.setGrade(rs.getString("GRADE"));
				mem.setIndate(rs.getTimestamp("INDATE"));
				mem.setNickname(rs.getString("NICKNAME"));
				return mem;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
			if(stmt != null)
				stmt.close();
			if(conn != null)
				conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
		return null;
	}
}
