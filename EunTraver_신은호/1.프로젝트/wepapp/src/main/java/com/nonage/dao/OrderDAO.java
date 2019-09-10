package com.nonage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.nonage.dto.CartVO;
import com.nonage.dto.OrderVO;

import study.DBAction;

public class OrderDAO {
		private OrderDAO() {
		}
		private static OrderDAO instance = new OrderDAO();
		public static OrderDAO getInstance() {
			return instance;
		}
		public ArrayList<Integer> selectSeqOrderIng(String id){
			ArrayList<Integer> oseqList = new ArrayList<Integer>();
			String sql = "select distinct oseq from order_view"
					+ " where id=? and result='1' order by oseq desc";//진행중인 물품을 가져와라
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn=DBAction.getInstance().getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, id);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					oseqList.add(rs.getInt(1));
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
			return oseqList;
		}
		public ArrayList<OrderVO> listOrderById(String id,String result,int oseq){
			ArrayList<OrderVO> orderList = new ArrayList<OrderVO>();
			String sql = "select * from order_view where id=? "
					+"and result like '%" + result +"%' and oseq=?";
			Connection conn = null;
			PreparedStatement pstmt=null;
			ResultSet rs= null;
			try {
				conn= DBAction.getInstance().getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setInt(2, oseq);
				rs=pstmt.executeQuery();
				while(rs.next()) {
						OrderVO orderVO = new OrderVO();
						orderVO.setOdseq(rs.getInt("ODSEQ"));
						orderVO.setOseq(rs.getInt("OSEQ"));
						orderVO.setId(rs.getString("ID"));
						orderVO.setIndate(rs.getTimestamp("INDATE"));
						orderVO.setMname(rs.getString("MNAME"));
						orderVO.setZipNum(rs.getString("ZIP_NUM"));
						orderVO.setAddress(rs.getString("ADDRESS"));
						orderVO.setPhone(rs.getString("PHONE"));
						orderVO.setPseq(rs.getInt("PSEQ"));
						orderVO.setQuantity(rs.getInt("QUANTITY"));
						orderVO.setPname(rs.getString("PNAME"));
						orderVO.setPrice2(rs.getInt("PRICE2"));
						orderVO.setResult(rs.getString("RESULT"));
						orderList.add(orderVO);
						
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
			return orderList;
		}
		public int insertOrder(ArrayList<CartVO> cartList,String id) {
			int maxOseq =0;
			Connection conn=null;
			PreparedStatement pstmt= null;
			ResultSet rs =null;
			try {
				conn=DBAction.getInstance().getConnection();
				String insertOrder = "insert into orders(id) values(?)";
				pstmt =conn.prepareStatement(insertOrder);
				pstmt.setString(1, id);
				pstmt.executeUpdate();
				pstmt.close();
				String select = "select max(oseq) from orders";
				pstmt = conn.prepareStatement(select);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					maxOseq = rs.getInt(1);
				}
				for(CartVO cartVO : cartList) {
					insertOrderDetail(cartVO, maxOseq);
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
			return maxOseq;
		}
		public void insertOrderDetail(CartVO cartVO, int maxOseq) {
			Connection conn=null;
			PreparedStatement pstmt= null;
			try {
				conn = DBAction.getInstance().getConnection();
				String insertOrderDetail = "insert into order_detail(oseq,"
						+"pseq,quantity) values(?,?,?)";
				pstmt = conn.prepareStatement(insertOrderDetail);
				pstmt.setInt(1, maxOseq);
				pstmt.setInt(2,cartVO.getPseq());
				pstmt.setInt(3, cartVO.getQuantity());
				pstmt.executeUpdate();
				pstmt.close();
				String updateCartResult = "update cart set result=2 where cseq=?";
				pstmt=conn.prepareStatement(updateCartResult);
				pstmt.setInt(1, cartVO.getCseq());
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
		public ArrayList<OrderVO> adminOrderList(String id){
		ArrayList<OrderVO> orderList = new ArrayList<OrderVO>();
		String sql = "select * from order_view where id like '%"+id+"%' order by result, odseq desc";
		Connection conn = null;
		Statement pstmt=null;
		ResultSet rs= null;
		try {
			conn= DBAction.getInstance().getConnection();
			pstmt = conn.createStatement();
			rs=pstmt.executeQuery(sql);
			while(rs.next()) {
					OrderVO orderVO = new OrderVO();
					orderVO.setOdseq(rs.getInt("ODSEQ"));
					orderVO.setOseq(rs.getInt("OSEQ"));
					orderVO.setId(rs.getString("ID"));
					orderVO.setIndate(rs.getTimestamp("INDATE"));
					orderVO.setMname(rs.getString("MNAME"));
					orderVO.setZipNum(rs.getString("ZIP_NUM"));
					orderVO.setAddress(rs.getString("ADDRESS"));
					orderVO.setPhone(rs.getString("PHONE"));
					orderVO.setPseq(rs.getInt("PSEQ"));
					orderVO.setQuantity(rs.getInt("QUANTITY"));
					orderVO.setPname(rs.getString("PNAME"));
					orderVO.setPrice2(rs.getInt("PRICE2"));
					orderVO.setResult(rs.getString("RESULT"));
					orderList.add(orderVO);
			}
			return orderList;
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
		public void orderResultSet(String odsep) {
			Connection conn=null;
			PreparedStatement stmt=null;
			String sql ="update order_detail set result=2 where odseq=?";
			try {
				conn=DBAction.getInstance().getConnection();
				stmt=conn.prepareStatement(sql);
				stmt.setString(1, odsep);
				stmt.executeUpdate();
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
