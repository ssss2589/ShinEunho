package project.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import project.VO.MemberVO;
import project.VO.QnaVO;
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
		String sql="insert into pro_member(id,pwd,name,email,zip_num,address,phone) values(?,?,?,?,?,?,?)";
		try {
			conn=DBAction.getInstance().getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, mem.getId());
			pstmt.setString(2, mem.getPwd());
			pstmt.setString(3, mem.getName());
			pstmt.setString(4, mem.getEmail());
			pstmt.setString(5, mem.getZipNum());
			pstmt.setString(6, mem.getAddress());
			pstmt.setString(7, mem.getPhone());
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
		String sql="select * from pro_member where id='"+id+"' and pwd='"+pw+"'";
		try {
			conn=DBAction.getInstance().getConnection();
			pstmt=conn.createStatement();
			rs=pstmt.executeQuery(sql);
			if(rs.next()) {
				MemberVO mem = new MemberVO();
				mem.setId(rs.getString("ID"));
				mem.setPwd(rs.getString("PWD"));
				mem.setName(rs.getString("NAME"));
				mem.setEmail(rs.getString("EMAIL"));
				mem.setPhone(rs.getString("PHONE"));
				mem.setAddress(rs.getString("ADDRESS"));
				mem.setIndate(rs.getTimestamp("INDATE"));
				mem.setZipNum(rs.getString("ZIP_NUM"));
				mem.setUseyn(rs.getString("USEYN"));
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
	public MemberVO search(String id) {
		Connection conn=null;
		Statement pstmt=null;
		ResultSet rs=null;
		String sql="select * from pro_member where id='"+id+"'";
		try {
			conn=DBAction.getInstance().getConnection();
			pstmt=conn.createStatement();
			rs=pstmt.executeQuery(sql);
			if(rs.next()) {
				MemberVO mem = new MemberVO();
				mem.setId(rs.getString("ID"));
				mem.setPwd(rs.getString("PWD"));
				mem.setName(rs.getString("NAME"));
				mem.setEmail(rs.getString("EMAIL"));
				mem.setPhone(rs.getString("PHONE"));
				mem.setAddress(rs.getString("ADDRESS"));
				mem.setIndate(rs.getTimestamp("INDATE"));
				mem.setZipNum(rs.getString("ZIP_NUM"));
				mem.setUseyn(rs.getString("USEYN"));
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
	public void update(MemberVO mem, String id) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="update pro_member set pwd=?, zip_num=?, address=?, phone=? where id=?";
		try {
			conn=DBAction.getInstance().getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, mem.getPwd());
			pstmt.setString(2, mem.getZipNum());
			pstmt.setString(3, mem.getAddress());
			pstmt.setString(4, mem.getPhone());
			pstmt.setString(5, id);
			pstmt.executeUpdate();
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
	}
	public ArrayList<MemberVO> memberList(int tpage,String id) {
		ArrayList<MemberVO> memlist=new ArrayList<MemberVO>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from pro_member where id like '%"
				+id+"%'";
		int absolutepage=1;
		try {
			conn=DBAction.getInstance().getConnection();
			absolutepage=(tpage-1)*counts+1;
			pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				rs.absolute(absolutepage);
				int count=0;
			while(count<counts) {
				MemberVO mem = new MemberVO();
				mem.setId(rs.getString("ID"));
				mem.setPwd(rs.getString("PWD"));
				mem.setName(rs.getString("NAME"));
				mem.setEmail(rs.getString("EMAIL"));
				mem.setPhone(rs.getString("PHONE"));
				mem.setAddress(rs.getString("ADDRESS"));
				mem.setIndate(rs.getTimestamp("INDATE"));
				mem.setZipNum(rs.getString("ZIP_NUM"));
				mem.setUseyn(rs.getString("USEYN"));
				memlist.add(mem);
			if(rs.isLast()) {
				break;
			}
			rs.next();
			count++;
			}
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
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return memlist;
	}
	static int view_rows = 5;
	static int counts =10;

	public String pageNumber(int tpage,String id) {
		String str="";
		int total_pages=totalRecord(id);
		int page_count=total_pages/counts+1;
		if(total_pages % counts==0) {
			page_count--;
		}
		if(tpage <1) {
			tpage=1;
		}
		int start_page = tpage - (tpage%view_rows)+1;
		int end_page = start_page+(counts-1);
		if(end_page > page_count) {
			end_page = page_count;
		}
		if(start_page > view_rows ) {
			str +="<a href='NonageServlet2?command=AdminMember&tpage=1&key="
					+id+"'>&lt;&lt;</a>&nbsp;&nbsp;";
			str +="<a href= 'NonageServlet2?command=AdminMember&tpage="
					+(start_page-1);
			str+="&key=<%id%>'>&lt;</a>&nbsp;&nbsp;";
		}
		for(int i =start_page;i<= end_page;i++) {
			if(i==tpage) {
				str += "<font color=red>[" + i + "]&nbsp;&nbsp;</font>";
			}else {
				str +="<a href='NonageServlet2?command=AdminMember&tpage="
						+i+"&key="+id+"'>["+i+"]</a>&nbsp;&nbsp;";
			}
		}
		if(page_count > end_page) {
			str+="<a href='NonageServlet2?command=AdminMember&tpage="
					+(end_page+1)+"&key="+id+"'> &gt; </a>&nbsp;&nbsp;";
			str+="<a href='NonageServlet2?command=AdminMember&tpage="
					+page_count + "&key="+id+"'> &gt; &gt; </a>&nbsp;&nbsp;";
		}
		return str;
	}
	public int totalRecord(String id) {
		int total_pages=0;
		String sql="select count(*) from pro_member where id like '%"
				+id+"%'";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet pageset =null;
		try {
			conn=DBAction.getInstance().getConnection();
			pstmt=conn.prepareStatement(sql);
			pageset=pstmt.executeQuery();
			if(pageset.next()) {
				total_pages = pageset.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pageset!=null)
					pageset.close();
				if(pstmt!=null)
					pstmt.close();
				if(conn!=null)
					conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return total_pages;
	}
	public void Delete(String id) {
		String sql="update pro_member set useyn='n' where id=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DBAction.getInstance().getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
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
