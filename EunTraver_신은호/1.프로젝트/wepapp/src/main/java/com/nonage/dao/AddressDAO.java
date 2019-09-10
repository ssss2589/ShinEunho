package com.nonage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.nonage.dto.AddressVO;

import study.DBAction;

public class AddressDAO {
	private AddressDAO() {
	}

	private static AddressDAO instance = new AddressDAO();

	public static AddressDAO getInstance() {
		return instance;
	}

	public ArrayList<AddressVO> selectAddressByDong(String dong) 
			throws Exception {
		ArrayList<AddressVO> addressList = new ArrayList<AddressVO>();
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		String sql = "select * from zipcode where dong like '%" + dong +"%'";
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				AddressVO addressVO = new AddressVO();	
				addressVO.setZip_num(rs.getString("zipcode"));
				addressVO.setSido(rs.getString("sido"));
				addressVO.setGugun(rs.getString("gugun"));
				addressVO.setDong(rs.getString("dong"));
				addressVO.setBunji(rs.getString("bunji"));
				addressList.add(addressVO);
			}
		} catch ( Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {rs.close();}
				if (pstmt != null) {pstmt.close();}
				if (conn != null) {conn.close();}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return addressList;
	}
}
