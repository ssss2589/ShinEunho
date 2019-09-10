package project.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import project.VO.FreeVO;
import study.DBAction;

public class FreeDAO {
	private FreeDAO() {
	}

	private static FreeDAO instance = new FreeDAO();

	public static FreeDAO getInstance() {
		return instance;
	}
	
	public void insert(FreeVO free) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="insert into pro_free(subject,content,click,id,image) values(?,?,?,?,?)";
		try {
			conn=DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,free.getSubject());
			pstmt.setString(2, free.getContent());
			pstmt.setInt(3, free.getClick());
			pstmt.setString(4, free.getId());
			pstmt.setString(5, free.getImage());
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
	public ArrayList<FreeVO> freeList(int tpage,String subject) {
		ArrayList<FreeVO> freelist=new ArrayList<FreeVO>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from pro_free where subject like '%"
				+subject+"%' order by qseq desc";
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
			FreeVO free = new FreeVO();
			free.setSubject(rs.getString("SUBJECT"));
			free.setQseq(rs.getString("QSEQ"));
			free.setContent(rs.getString("CONTENT"));
			free.setId(rs.getString("ID"));
			free.setClick(rs.getInt("CLICK"));
			free.setIndate(rs.getTimestamp("INDATE"));
			free.setImage(rs.getString("IMAGE"));
			freelist.add(free);
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
		return freelist;
	}
	static int view_rows = 5;
	static int counts =10;
	
	public String pageNumber(int tpage,String subject) {
		String str="";
		int total_pages=totalRecord(subject);
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
			str +="<a href='NonageServlet2?command=adminMain&tpage=1&key="
					+subject+"'>&lt;&lt;</a>&nbsp;&nbsp;";
			str +="<a href= 'NonageServlet2?command=adminMain&tpage="
					+(start_page-1);
			str+="&key=<%subject%>'>&lt;</a>&nbsp;&nbsp;";
		}
		for(int i =start_page;i<= end_page;i++) {
			if(i==tpage) {
				str += "<font color=red>[" + i + "]&nbsp;&nbsp;</font>";
			}else {
				str +="<a href='NonageServlet2?command=adminMain&tpage="
						+i+"&key="+subject+"'>["+i+"]</a>&nbsp;&nbsp;";
			}
		}
		if(page_count > end_page) {
			str+="<a href='NonageServlet2?command=adminMain&tpage="
					+(end_page+1)+"&key="+subject+"'> &gt; </a>&nbsp;&nbsp;";
			str+="<a href='NonageServlet2?command=adminMain&tpage="
					+page_count + "&key="+subject+"'> &gt; &gt; </a>&nbsp;&nbsp;";
		}
		return str;
	}
	public int totalRecord(String subject) {
		int total_pages=0;
		String sql="select count(*) from pro_free where subject like '%"
				+subject+"%'";
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
	public FreeVO freeDetail(String qseq) {
		Connection conn=null;
		Statement pstmt=null;
		ResultSet rs=null;
		String sql="select * from pro_free where qseq='"+qseq+"'";
		try {
			conn=DBAction.getInstance().getConnection();
			pstmt = conn.createStatement();
			rs = pstmt.executeQuery(sql);
			if(rs.next()) {
			FreeVO free = new FreeVO();
			free.setSubject(rs.getString("SUBJECT"));
			free.setQseq(rs.getString("QSEQ"));
			free.setContent(rs.getString("CONTENT"));
			free.setId(rs.getString("ID"));
			free.setClick(rs.getInt("CLICK"));
			free.setIndate(rs.getTimestamp("INDATE"));
			free.setImage(rs.getString("IMAGE"));
			free.setQseq(qseq);
			return free;
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
		return null;
	}
	public void clickPlus(String qseq) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="update pro_free set click = click + 1 where qseq=?";
		try {
			conn=DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,qseq);
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
	public ArrayList<FreeVO> myFreeList(String id) {
		ArrayList<FreeVO> freelist = new ArrayList<FreeVO>();
		Connection conn=null;
		Statement pstmt=null;
		ResultSet rs=null;
		String sql="select * from pro_free where id='"+id+"'";
		try {
			conn=DBAction.getInstance().getConnection();
			pstmt = conn.createStatement();
			rs = pstmt.executeQuery(sql);
			while(rs.next()) {
			FreeVO free = new FreeVO();
			free.setSubject(rs.getString("SUBJECT"));
			free.setQseq(rs.getString("QSEQ"));
			free.setContent(rs.getString("CONTENT"));
			free.setId(rs.getString("ID"));
			free.setClick(rs.getInt("CLICK"));
			free.setIndate(rs.getTimestamp("INDATE"));
			free.setImage(rs.getString("IMAGE"));
			free.setQseq(rs.getString("QSEQ"));
			freelist.add(free);
			}
			return freelist;
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
	public void freeDelete(String qseq) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		String sql="delete from pro_free where qseq=?";
		try {
			conn=DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, qseq);
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
	public void freeUpdate(String subject,String content,String image,String qseq) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="update pro_free set subject=?, content=?, image=? where qseq=?";
		try {
			conn=DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,subject);
			pstmt.setString(2,content);
			pstmt.setString(3,image);
			pstmt.setString(4,qseq);
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
