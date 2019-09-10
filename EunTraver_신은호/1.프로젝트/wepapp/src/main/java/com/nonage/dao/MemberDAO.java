package com.nonage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.nonage.dto.MemberVO;

import study.DBAction;

public class MemberDAO {
	private MemberDAO() {
	}

	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {
		return instance;
	}

	public int confirmID(String id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member where id='" + id+"'";
		int message = -1;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				message = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
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
		return message;
	}
	public void join(MemberVO memberVO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into member(id,pwd,name,email,zip_num,address,phone) values(?,?,?,?,?,?,?)";

		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberVO.getId());
			pstmt.setString(2, memberVO.getPwd());
			pstmt.setString(3, memberVO.getName());
			pstmt.setString(4, memberVO.getEmail());
			pstmt.setString(5, memberVO.getZipNum());
			pstmt.setString(6, memberVO.getAddress());
			pstmt.setString(7, memberVO.getPhone());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
	public MemberVO login(String id,String pw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member where id ='" + id+"' and pwd='"+pw+"'";
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				MemberVO mem = new MemberVO();
				mem.setId(id);
				mem.setPwd(pw);
				mem.setName(rs.getString("name"));
				mem.setEmail(rs.getString("email"));
				mem.setZipNum(rs.getString("zip_num"));
				mem.setAddress(rs.getString("address"));
				mem.setPhone(rs.getString("phone"));
				mem.setUseyn(rs.getString("useyn"));
				return mem;
			}
		} catch (Exception e) {
			e.printStackTrace();
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
		return null;
	}
	public MemberVO myData(String id) {
		Connection conn = null;
		Statement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member where id='" +id+"'";
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.createStatement();
			rs=pstmt.executeQuery(sql);
			if (rs.next()) {
				MemberVO mem=new MemberVO();
				mem.setId(rs.getString("ID"));
				mem.setName(rs.getString("NAME"));
				mem.setPwd(rs.getString("PWD"));
				mem.setPhone(rs.getString("PHONE"));
				mem.setEmail(rs.getString("EMAIL"));
				mem.setAddress(rs.getString("ADDRESS"));
				mem.setZipNum(rs.getString("ZIP_NUM"));
				return mem;
			}
		} catch (Exception e) {
			e.printStackTrace();
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
		return null;
	}
	public void memberDelete(String id) {
		Connection conn=null;
		PreparedStatement stmt= null;
		String sql="update member set useyn='n' where id=?";
		try {
			conn = DBAction.getInstance().getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.executeUpdate();	
		} catch (Exception e) {
			e.printStackTrace();
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
	}
	public ArrayList<MemberVO> memberList() {
		ArrayList<MemberVO> memberList=new ArrayList<MemberVO>();
		Connection conn=null;
		Statement stmt =null;
		ResultSet rs=null;
		String sql="select * from member";
		try {
			conn = DBAction.getInstance().getConnection();
			stmt = conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				MemberVO mem=new MemberVO();
				mem.setId(rs.getString("ID"));
				mem.setName(rs.getString("NAME"));
				mem.setPwd(rs.getString("PWD"));
				mem.setPhone(rs.getString("PHONE"));
				mem.setEmail(rs.getString("EMAIL"));
				mem.setAddress(rs.getString("ADDRESS"));
				mem.setZipNum(rs.getString("ZIP_NUM"));
				mem.setUseyn(rs.getString("useyn"));
				mem.setIndate(rs.getTimestamp("indate"));
				memberList.add(mem);
			}
			return memberList;
		} catch (Exception e) {
			e.printStackTrace();
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
		return null;
	}
}
