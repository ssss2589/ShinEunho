package com.nonage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.nonage.dto.AdminVO;
import com.nonage.dto.ProductVO;

import study2.DBAction;

public class AdminDAO {
	private static AdminDAO instance = new AdminDAO();

	public static AdminDAO getInstance() {
		return instance;
	}
	
	public AdminVO login(String id,String pw) {
		Connection conn=null;
		Statement pstmt=null;
		ResultSet rs=null;
		String sql = "select * from worker where id='"+id+"' and pwd='"+pw+"'";
		try {
			conn=DBAction.getInstance().getConnection();
			pstmt=conn.createStatement();
			rs=pstmt.executeQuery(sql);
			if(rs.next()) {
				AdminVO adm = new AdminVO();
				adm.setId(id);
				adm.setPwd(pw);
				adm.setName(rs.getString(3));
				adm.setPhone(rs.getString(4));
				return adm;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
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
	public ArrayList<ProductVO> itemList(){
		ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql = "select * from product order by pseq desc";
		try {
			conn=DBAction.getInstance().getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				ProductVO pro = new ProductVO();
				pro.setPseq(rs.getInt("PSEQ"));
				pro.setName(rs.getString("NAME"));
				pro.setKind(rs.getString("KIND"));
				pro.setPrice1(rs.getInt("PRICE1"));
				pro.setPrice2(rs.getInt("PRICE2"));
				pro.setPrice3(rs.getInt("PRICE3"));
				pro.setContent(rs.getString("CONTENT"));
				pro.setImage(rs.getString("IMAGE"));
				pro.setUseyn(rs.getString("USEYN"));
				pro.setBestyn(rs.getString("BESTYN"));
				pro.setIndate(rs.getTimestamp("INDATE"));
				productList.add(pro);
			}
			return productList;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
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
}
