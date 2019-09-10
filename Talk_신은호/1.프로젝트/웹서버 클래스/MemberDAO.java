

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import study.DBAction;


public class MemberDAO {
	
	private MemberDAO() {
	}
	private static MemberDAO instance = new MemberDAO();
	public static MemberDAO getInstance() {
		return instance;
	}
	
	public int join(MemberVO mem) {
		Connection conn=null;
		PreparedStatement pstmt = null;
		String sql="insert into and_member(id,pw,name,image) values(?,?,?,?)";
		try {
			conn=DBAction.getInstance().getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, mem.getId());
			pstmt.setString(2, mem.getPw());
			pstmt.setString(3, mem.getName());
			pstmt.setString(4, mem.getImg());
		
			pstmt.executeUpdate();
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
				try {
					if(pstmt!=null)
					pstmt.close();
					if(conn!=null)
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return 0;
	}
	public MemberVO login(String id, String pw) {
		Connection conn=null;
		Statement pstmt=null;
		ResultSet rs=null;
		String sql="select * from and_member where id='"+id+"' and pw='"+pw+"'";
		try {
			conn=DBAction.getInstance().getConnection();
			System.out.println(id+pw);
			pstmt=conn.createStatement();
			rs=pstmt.executeQuery(sql);
			if(rs.next()) {
				MemberVO mem = new MemberVO();
				mem.setId(rs.getString("ID"));
				mem.setPw(rs.getString("PW"));
				mem.setName(rs.getString("NAME"));
				
				return mem;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)
				rs.close();
				if(pstmt!=null)
				pstmt.close();
				if(conn!=null)
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		return null;
	}
	public ArrayList<MemberVO> memberList() {
		ArrayList<MemberVO> memlist=new ArrayList<MemberVO>();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		String sql="select * from and_member";
		try {
			conn=DBAction.getInstance().getConnection();
			stmt = conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				MemberVO mem = new MemberVO();
				mem.setId(rs.getString("ID"));
				mem.setPw(rs.getString("PW"));
				mem.setName(rs.getString("NAME"));
				mem.setImg("");
				memlist.add(mem);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)
					rs.close();
				if(stmt!=null)
					stmt.close();
				if(conn!=null)
					conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return memlist;
	}
}
