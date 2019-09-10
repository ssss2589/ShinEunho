

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import study.DBAction;


public class FriendDAO {
	
	private FriendDAO() {
	}
	private static FriendDAO instance = new FriendDAO();
	public static FriendDAO getInstance() {
		return instance;
	}
	
	public int join(String id,String fid) {
		Connection conn=null;
		PreparedStatement pstmt = null;
		String sql="insert into and_friend(My,friend) values(?,?)";
		try {
			conn=DBAction.getInstance().getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, fid);
		
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
	public ArrayList<FriendVO> search(String id) {
		ArrayList<FriendVO> friendList = new ArrayList<>();
		Connection conn=null;
		Statement pstmt=null;
		ResultSet rs=null;
		String sql="select * from and_friend where My='"+id+"'";
		try {
			conn=DBAction.getInstance().getConnection();
			pstmt=conn.createStatement();
			rs=pstmt.executeQuery(sql);
			while(rs.next()) {
				FriendVO mem = new FriendVO();
				mem.setMid(rs.getString("MY"));
				mem.setFid(rs.getString("FRIEND"));
				friendList.add(mem);
			}
			return friendList;
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
	public boolean search(String id,String name) {
		ArrayList<FriendVO> friendList = new ArrayList<>();
		Connection conn=null;
		Statement pstmt=null;
		ResultSet rs=null;
		String sql="select * from and_friend where My='"+id+"' and friend='"+name+"'";
		try {
			conn=DBAction.getInstance().getConnection();
			pstmt=conn.createStatement();
			rs=pstmt.executeQuery(sql);
			return rs.next();
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
		return false;
	}
}
