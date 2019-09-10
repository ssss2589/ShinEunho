package project.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import project.VO.IndexVO;
import project.VO.MemberVO;
import study.DBAction;

public class IndexDAO {
	private IndexDAO() {
	}
	private static IndexDAO instance = new IndexDAO();
	public static IndexDAO getInstance() {
		return instance;
	}
	
public void insert(IndexVO ind) {
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sql="insert into pro_index(subject,content,indate,site,image) values(?,?,?,?,?)";
	try {
		conn=DBAction.getInstance().getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,ind.getSubject());
		pstmt.setString(2, ind.getContent());
		pstmt.setString(3, ind.getIndate());
		pstmt.setString(4, ind.getSite());
		pstmt.setString(5, ind.getImage());
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
public ArrayList<IndexVO> indexList(int tpage,String subject) {
ArrayList<IndexVO> indexlist=new ArrayList<IndexVO>();
Connection conn=null;
PreparedStatement pstmt=null;
ResultSet rs=null;
String sql="select * from pro_index where subject like '%"
		+subject+"%'";
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
		IndexVO index = new IndexVO();
		index.setContent(rs.getString("CONTENT"));
		index.setImage(rs.getString("IMAGE"));
		index.setIndate(rs.getString("INDATE"));
		index.setQseq(rs.getInt("QSEQ"));
		index.setSite(rs.getString("SITE"));
		index.setSubject(rs.getString("SUBJECT"));
		index.setUseyn(rs.getString("USEYN"));
		indexlist.add(index);
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
return indexlist;
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
	str +="<a href='NonageServlet2?command=IndexAdmin&tpage=1&key="
			+subject+"'>&lt;&lt;</a>&nbsp;&nbsp;";
	str +="<a href= 'NonageServlet2?command=IndexAdmin&tpage="
			+(start_page-1);
	str+="&key=<%subject%>'>&lt;</a>&nbsp;&nbsp;";
}
for(int i =start_page;i<= end_page;i++) {
	if(i==tpage) {
		str += "<font color=red>[" + i + "]&nbsp;&nbsp;</font>";
	}else {
		str +="<a href='NonageServlet2?command=IndexAdmin&tpage="
				+i+"&key="+subject+"'>["+i+"]</a>&nbsp;&nbsp;";
	}
}
if(page_count > end_page) {
	str+="<a href='NonageServlet2?command=IndexAdmin&tpage="
			+(end_page+1)+"&key="+subject+"'> &gt; </a>&nbsp;&nbsp;";
	str+="<a href='NonageServlet2?command=IndexAdmin&tpage="
			+page_count + "&key="+subject+"'> &gt; &gt; </a>&nbsp;&nbsp;";
}
return str;
}
public int totalRecord(String subject) {
int total_pages=0;
String sql="select count(*) from pro_index where subject like '%"
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
public ArrayList<IndexVO> indexlist() {
ArrayList<IndexVO> indexlist=new ArrayList<IndexVO>();
Connection conn=null;
Statement pstmt=null;
ResultSet rs=null;
String sql="select * from pro_index where useyn='y'";
try {
	conn=DBAction.getInstance().getConnection();
	pstmt = conn.createStatement();
	rs=pstmt.executeQuery(sql);
	while(rs.next()) {
		IndexVO index = new IndexVO();
		index.setContent(rs.getString("CONTENT"));
		index.setImage(rs.getString("IMAGE"));
		index.setIndate(rs.getString("INDATE"));
		index.setQseq(rs.getInt("QSEQ"));
		index.setSite(rs.getString("SITE"));
		index.setSubject(rs.getString("SUBJECT"));
		index.setUseyn(rs.getString("USEYN"));
		indexlist.add(index);
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
return indexlist;
}
public void Delete(String qseq) {
	String sql="update pro_index set useyn='n' where qseq=?";
	Connection conn=null;
	PreparedStatement pstmt=null;
	try {
		conn=DBAction.getInstance().getConnection();
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, qseq);
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
public IndexVO search(String qseq) {
	Connection conn=null;
	Statement pstmt=null;
	ResultSet rs=null;
	String sql="select * from pro_index where qseq='"+qseq+"'";
	try {
		conn=DBAction.getInstance().getConnection();
		pstmt=conn.createStatement();
		rs=pstmt.executeQuery(sql);
		if(rs.next()) {
			IndexVO index = new IndexVO();
			index.setContent(rs.getString("CONTENT"));
			index.setImage(rs.getString("IMAGE"));
			index.setIndate(rs.getString("INDATE"));
			index.setQseq(rs.getInt("QSEQ"));
			index.setSite(rs.getString("SITE"));
			index.setSubject(rs.getString("SUBJECT"));
			index.setUseyn(rs.getString("USEYN"));
			return index;
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
}
