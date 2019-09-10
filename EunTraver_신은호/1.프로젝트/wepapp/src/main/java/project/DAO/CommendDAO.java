package project.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import project.VO.CommendVO;
import project.VO.LikeToVO;
import study2.DBAction;

public class CommendDAO {
private CommendDAO() {
}
private static CommendDAO instance=new CommendDAO();
public static CommendDAO getInstance() {
	return instance;
}

public void insert(CommendVO com) {
	Connection conn=null;
	PreparedStatement pstmt=null;
	String sql="insert into pro_commend(commend,id,qseq) values(?,?,?)";
	try {
		conn = DBAction.getInstance().getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, com.getCommend());
		pstmt.setString(2, com.getId());
		pstmt.setString(3, com.getQseq());
		pstmt.executeUpdate();
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
public ArrayList<CommendVO> comList(String qseq) {
	ArrayList<CommendVO> comlist=new ArrayList<CommendVO>();
	Connection conn=null;
	Statement pstmt=null;
	ResultSet rs=null;
	String sql="select * from pro_commend where qseq='"+qseq+"'";
	try {
		conn=DBAction.getInstance().getConnection();
		pstmt = conn.createStatement();
		rs = pstmt.executeQuery(sql);
		while(rs.next()) {
		CommendVO com = new CommendVO();
		com.setCommend(rs.getString("COMMEND"));
		com.setIndate(rs.getTimestamp("INDATE"));
		com.setId(rs.getString("ID"));
		com.setRe_useyn(rs.getString("RE_USEYN"));
		com.setCseq(rs.getInt("CSEQ"));
		comlist.add(com);
		}
		return comlist;
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
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	return null;
}
public void goodPlus(String qseq,String cseq,String id) {
	Connection conn=null;
	PreparedStatement pstmt=null;
	String sql="insert into liketo(commendno,memid,like_check,likeno) values(?,?,?,?)";
	try {
		conn = DBAction.getInstance().getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, cseq);
		pstmt.setString(2, id);
		pstmt.setInt(3, 1);
		pstmt.setString(4, qseq);
		pstmt.executeUpdate();
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
public int searchCheck(String commendno, String memid) {
	Connection conn=null;
	Statement pstmt=null;
	ResultSet rs=null;
	String sql="select * from liketo where commendno='"+commendno+"' and memid='"+memid+"'";
	try {
		conn = DBAction.getInstance().getConnection();
		pstmt=conn.createStatement();
		rs=pstmt.executeQuery(sql);
		if(rs.next()) {
			if(rs.getInt("LIKE_CHECK")==1) {
				return 1;
			}else {
				return 0;
			}
		}
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	return 0;
}
public ArrayList<LikeToVO> goodList(String qseq) {
	ArrayList<LikeToVO> likelist=new ArrayList<LikeToVO>();
	Connection conn=null;
	Statement pstmt=null;
	ResultSet rs=null;
	String sql="select * from liketo where likeno='"+qseq+"'";
	try {
		conn=DBAction.getInstance().getConnection();
		pstmt = conn.createStatement();
		rs = pstmt.executeQuery(sql);
		while(rs.next()) {
		LikeToVO com = new LikeToVO();
		com.setCommendno(rs.getString("COMMENDNO"));
		com.setLike_check(rs.getInt("LIKE_CHECK"));
		com.setLikeno(rs.getString("LIKENO"));
		com.setMemid(rs.getString("MEMID"));
		likelist.add(com);
		}
		return likelist;
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
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	return null;
}
public ArrayList<CommendVO> mycomList(String id) {
	ArrayList<CommendVO> comlist=new ArrayList<CommendVO>();
	Connection conn=null;
	Statement pstmt=null;
	ResultSet rs=null;
	String sql="select * from pro_commend where id='"+id+"'";
	try {
		conn=DBAction.getInstance().getConnection();
		pstmt = conn.createStatement();
		rs = pstmt.executeQuery(sql);
		while(rs.next()) {
		CommendVO com = new CommendVO();
		com.setCommend(rs.getString("COMMEND"));
		com.setIndate(rs.getTimestamp("INDATE"));
		com.setId(rs.getString("ID"));
		com.setRe_useyn(rs.getString("RE_USEYN"));
		com.setCseq(rs.getInt("CSEQ"));
		com.setQseq(rs.getString("QSEQ"));
		comlist.add(com);
		}
		return comlist;
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
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	return null;
}
public void comDelete(String cseq) {
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs= null;
	String sql="delete from pro_commend where cseq=?";
	try {
		conn=DBAction.getInstance().getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, cseq);
		pstmt.executeUpdate();
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
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
}
