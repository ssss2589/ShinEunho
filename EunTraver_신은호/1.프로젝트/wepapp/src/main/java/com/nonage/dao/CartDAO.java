package com.nonage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.nonage.dto.CartVO;

import study.DBAction;

public class CartDAO {
	private CartDAO() {
		
	}
	private static CartDAO instance = new CartDAO();
	public static CartDAO getInstance() {
		return instance;
	}
	public ArrayList<CartVO> listCart(String userId){
		ArrayList<CartVO> cartList = new ArrayList<CartVO>();
		String sql = "select * from cart_view where id=? order by cseq desc";
		Connection conn= null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,userId);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				CartVO cartVO = new CartVO();
				cartVO.setCseq(rs.getInt(1));
				cartVO.setId(rs.getString(2));
				cartVO.setPseq(rs.getInt(3));
				cartVO.setMname(rs.getString(4));
				cartVO.setPname(rs.getString(5));
				cartVO.setQuantity(rs.getInt(6));
				cartVO.setIndate(rs.getTimestamp(7));
				cartVO.setPrice2(rs.getInt(8));
				cartList.add(cartVO);
				
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
		return cartList;
	}
	public int insertCart(CartVO cartvo){
		Connection conn=null;
		PreparedStatement pstmt =null;
		String sql = "insert into cart(id,pseq,quantity) values(?,?,?)";
		try {
			conn=DBAction.getInstance().getConnection();
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, cartvo.getId());
			pstmt.setInt(2, cartvo.getPseq());
			pstmt.setInt(3, cartvo.getQuantity());
			pstmt.executeUpdate();
			return 1;
		}catch(Exception e){
			return 0;
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
	public void deleteCart(String cseq) {
		Connection conn=null;
		Statement stmt =null;
		String msg="";
		String sql = "delete from cart where cseq='"+cseq+"'";
		try {
			conn=DBAction.getInstance().getConnection();
			stmt=conn.createStatement();
			int result = stmt.executeUpdate(sql);
			msg = result > -1 ? "successful " : "fail";
			System.out.println(msg);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
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
}
