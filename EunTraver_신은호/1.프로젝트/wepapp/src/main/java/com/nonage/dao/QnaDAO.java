package com.nonage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.nonage.dto.QnaVO;

import study2.DBAction;

public class QnaDAO {

	private static QnaDAO instance = new QnaDAO();
	public static QnaDAO getInstance() {
		return instance;
	}
	public ArrayList<QnaVO> qnaList(String id) {
		ArrayList<QnaVO> qnaList = new ArrayList<QnaVO>();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		String sql="select * from qna where id='"+id+"'";
		try {
			conn=DBAction.getInstance().getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				QnaVO qna = new QnaVO();
				qna.setQseq(rs.getInt(1));
				qna.setSubject(rs.getString(2));
				qna.setContent(rs.getString(3));
				qna.setReply(rs.getString(4));
				qna.setId(rs.getString(5));
				qna.setRep(rs.getInt(6));
				qna.setIndate(rs.getTimestamp(7));
				qnaList.add(qna);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) 
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return qnaList;
	}
	public void qnaWrite(QnaVO qna) {
		Connection conn=null;
		PreparedStatement pstmt=null;
	
		String sql="insert into qna(subject,content,id,rep) values(?,?,?,?)";
		try {
			conn=DBAction.getInstance().getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,qna.getSubject());
			pstmt.setString(2, qna.getContent());
			pstmt.setString(3, qna.getId());
			pstmt.setInt(4, qna.getRep());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public QnaVO qnaView(String qseq) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from qna where qseq=?";
		try {
			conn=DBAction.getInstance().getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, qseq);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				QnaVO qna = new QnaVO();
				qna.setSubject(rs.getString("SUBJECT"));
				qna.setIndate(rs.getTimestamp("INDATE"));
				qna.setContent(rs.getString("CONTENT"));
				qna.setReply(rs.getString("REPLY"));
				qna.setRep(rs.getInt("REP"));
				return qna;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) 
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public void deleteQna(String qseq) {
		Connection conn=null;
		Statement pstmt=null;
		String sql="delete from qna where qseq='"+qseq+"'";
		try {
			conn=DBAction.getInstance().getConnection();
			pstmt=conn.createStatement();
			pstmt.executeUpdate(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public ArrayList<QnaVO> qnaList(){
		ArrayList<QnaVO> qnaList = new ArrayList<QnaVO>();
		Connection conn=null;
		Statement pstmt=null;
		ResultSet rs=null;
		String sql="select * from qna order by rep asc, qseq desc";
		try {
			conn=DBAction.getInstance().getConnection();
			pstmt=conn.createStatement();
			rs=pstmt.executeQuery(sql);
			while(rs.next()) {
				QnaVO qna = new QnaVO();
				qna.setQseq(rs.getInt("QSEQ"));
				qna.setSubject(rs.getString("SUBJECT"));
				qna.setId(rs.getString("ID"));
				qna.setIndate(rs.getTimestamp("INDATE"));
				qna.setRep(rs.getInt("REP"));
				qnaList.add(qna);
			}
			return qnaList;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public void qnaAdminUpdate(String reply,String subject) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql = "update qna set reply=?, rep=? where subject=?";
		try {
			conn=DBAction.getInstance().getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, reply);
			pstmt.setString(2, "2");
			pstmt.setString(3, subject);
			pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
