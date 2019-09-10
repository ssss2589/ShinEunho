package com.nonage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.nonage.dto.ProductVO;

import study.DBAction;

public class ProductDAO {
	private ProductDAO() {}

	private static ProductDAO instance = new ProductDAO();

	public static ProductDAO getInstance() {
		return instance;
	}

	public ArrayList<ProductVO> listProduct(int tpage,String product_name) {
		ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select pseq,indate,name,price1,price2,useyn,bestyn "
				+" from product where name like '%"
				+ product_name+"%' order by pseq desc";
		int absolutepage=1;
		try {
			conn = DBAction.getInstance().getConnection();
			absolutepage=(tpage-1)*counts+1;
			pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);//스크롤센시티브가 커서의 이동을 가능하게해줌.업데이테이블은 커서의 이동을 업데이트 해주는역할
			rs = pstmt.executeQuery();
			if (rs.next()) {
				rs.absolute(absolutepage);//앱솔루트는 동적커서. 원하는 커서위치로 이동해 원하는 횟수만큼 돌수있다.
				int count=0;
				while(count<counts) {
					ProductVO pro = new ProductVO();
					pro.setPseq(rs.getInt("PSEQ"));
					pro.setName(rs.getString("NAME"));
					pro.setPrice1(rs.getInt("PRICE1"));
					pro.setPrice2(rs.getInt("PRICE2"));
					pro.setUseyn(rs.getString("USEYN"));
					pro.setBestyn(rs.getString("BESTYN"));
					pro.setIndate(rs.getTimestamp("INDATE"));
					productList.add(pro);
				if(rs.isLast()) {
					break;
				}
				rs.next();
				count++;
				}
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
		return productList;
	}
	static int view_rows = 5;
	static int counts =5;

	public String pageNumber(int tpage,String name) {
		String str="";
		int total_pages=totalRecord(name);
		int page_count=total_pages/counts+1;
		if(total_pages % counts ==0) {//
			page_count--;
		}
		if(tpage < 1) {
			tpage=1;
		}
		int start_page = tpage - (tpage % view_rows)+1;
		int end_page = start_page + (counts-1);
		if(end_page > page_count) {
			end_page = page_count; // 마지막페이지를 맞춰주는 구문
		}
		if(start_page > view_rows) {//스타트가 5를 넘기게되면
			str += "<a href='NonageServlet?command=admin_ItemList&tpage=1&key="
					+name+"'>&lt;&lt;</a>&nbsp;&nbsp;";// >>생성
			str += "<a href = 'NonageServlet?command=admin_ItemList&tpage="
					+(start_page -1);
			str += "&key=<%product_name%>'>&lt;</a>&nbsp;&nbsp;";
		}
		for(int i = start_page; i<= end_page;i++) {//숫자들의 그림을 그리는 표현
			if(i==tpage) {//현재 보고있는 페이지
				str += "<font color=red>[" + i + "]&nbsp;&nbsp;</font>";
			}else {
				str += "<a href='NonageServlet?command=admin_ItemList&tpage="
						+i+"&key="+name+"'>["+i+"]</a>&nbsp;&nbsp;";
			}
		}
		if(page_count > end_page) { //왼쪽 화살표 표현
			str+="<a href='NonageServlet?command=admin_ItemList&tpage="
					+(end_page +1) +"&key="+name+"'> &gt; </a>&nbsp;&nbsp;";
			str+="<a href='NonageServlet?command=admin_ItemList&tpage="
					+page_count + "&key="+name+"'> &gt; &gt; </a>&nbsp;&nbsp;";
		}
		return str;
	}
	public int totalRecord(String product_name) {
		int total_pages=0;
		String sql="select count(*) from product where name like '%"
				+product_name+"%'";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet pageset = null;
		try {
			conn=DBAction.getInstance().getConnection();
			pstmt=conn.prepareStatement(sql);
			pageset=pstmt.executeQuery();
			if(pageset.next()) {
				total_pages = pageset.getInt(1);//레코드의 개수
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pageset != null)
					pageset.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return total_pages;
	}
	public ArrayList<ProductVO> listNewProduct() throws Exception {
		ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from NEW_PRO_VIEW";
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductVO product = new ProductVO();
				product.setPseq(rs.getInt("pseq"));
				product.setName(rs.getString("name"));
				product.setPrice2(rs.getInt("price2"));
				product.setImage(rs.getString("image"));
				productList.add(product);
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
		return productList;
	}

	public ArrayList<ProductVO> listBestProduct() {
		ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from BEST_PRO_VIEW";
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductVO product = new ProductVO();
				product.setPseq(rs.getInt("pseq"));
				product.setName(rs.getString("name"));
				product.setPrice2(rs.getInt("price2"));
				product.setImage(rs.getString("image"));
				productList.add(product);
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
		return productList;
	}
	public ArrayList<ProductVO> listKindProduct(String kind){
		ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
		String sql="select * from product where kind=?";
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, kind);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO product = new ProductVO();
				product.setPseq(rs.getInt("pseq"));
				product.setName(rs.getString("name"));
				product.setPrice2(rs.getInt("price2"));
				product.setImage(rs.getString("image"));
				productList.add(product);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn !=null)conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return productList;
	}
	public ProductVO selectProduct(String pseq) {
		ProductVO pro = new ProductVO();
		Connection conn =null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String sql="select * from product where pseq=?";
			conn=DBAction.getInstance().getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,pseq);
			rs=stmt.executeQuery();
			if(rs.next()) {
				pro.setPseq(rs.getInt("pseq"));
				pro.setName(rs.getString("name"));
				pro.setPrice1(rs.getInt("PRICE1"));
				pro.setPrice2(rs.getInt("price2"));
				pro.setPrice3(rs.getInt("price3"));
				pro.setImage(rs.getString("image"));
				pro.setKind(rs.getString("KIND"));
				pro.setBestyn(rs.getString("BESTYN"));
				pro.setUseyn(rs.getString("USEYN"));
				pro.setContent(rs.getString("CONTENT"));
				return pro;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				if(conn !=null)conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public ArrayList<ProductVO> searchProduct(String name) {
		ArrayList<ProductVO> productlist = new ArrayList<ProductVO>();
		Connection conn=null;
		Statement pstmt=null;
		ResultSet rs= null;
		String sql="select * from product where name like '%"+name+"%'";
		try {
			conn=DBAction.getInstance().getConnection();
			pstmt=conn.createStatement();
			rs=pstmt.executeQuery(sql);
			while(rs.next()) {
				ProductVO pro = new ProductVO();
				pro.setPseq(rs.getInt("PSEQ"));
				pro.setName(rs.getString("NAME"));
				pro.setPrice1(rs.getInt("PRICE1"));
				pro.setPrice2(rs.getInt("PRICE2"));
				pro.setUseyn(rs.getString("USEYN"));
				pro.setBestyn(rs.getString("BESTYN"));
				pro.setIndate(rs.getTimestamp("INDATE"));
				productlist.add(pro);
			}
			return productlist;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn !=null)conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public int insertProduct(ProductVO pro) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="insert into product(name,kind,price1,price2,price3,content,image) values(?,?,?,?,?,?,?)";
		try {
			conn=DBAction.getInstance().getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, pro.getName());
			pstmt.setString(2, pro.getKind());
			pstmt.setInt(3, pro.getPrice1());
			pstmt.setInt(4, pro.getPrice2());
			pstmt.setInt(5, pro.getPrice3());
			pstmt.setString(6, pro.getContent());
			pstmt.setString(7, pro.getImage());
			pstmt.executeUpdate();
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn !=null)conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	public int updateProduct(ProductVO product) {
		int result= -1;
		String sql="update product set kind=?, useyn=?, name=?" +
		", price1=?, price2=?, price3=?, content=?, image=?, bestyn=? "+
				" where pseq=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DBAction.getInstance().getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, product.getKind());
			pstmt.setString(2, product.getUseyn());
			pstmt.setString(3, product.getName());
			pstmt.setInt(4, product.getPrice1());
			pstmt.setInt(5, product.getPrice2());
			pstmt.setInt(6, product.getPrice3());
			pstmt.setString(7, product.getContent());
			pstmt.setString(8, product.getImage());
			pstmt.setString(9, product.getBestyn());
			pstmt.setInt(10, product.getPseq());
			result=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn !=null)conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return 1;
	}
}
