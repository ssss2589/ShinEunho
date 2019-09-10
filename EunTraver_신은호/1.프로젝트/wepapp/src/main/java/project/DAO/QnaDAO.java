package project.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import project.VO.FreeVO;
import project.VO.QnaVO;
import study.DBAction;

public class QnaDAO {
private QnaDAO() {
}
private static QnaDAO instance = new QnaDAO();
public static QnaDAO getInstance() {
	return instance;
}
public ArrayList<QnaVO> qnaList(String id){
	ArrayList<QnaVO> qnalist=new ArrayList<QnaVO>();
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sql="select * from pro_qna where id=?";
	try {
		conn=DBAction.getInstance().getConnection();
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, id);
		rs=pstmt.executeQuery();
		while(rs.next()) {
			QnaVO qna=new QnaVO();
			qna.setContent(rs.getString("CONTENT"));
			qna.setId(rs.getString("ID"));
			qna.setIndate(rs.getTimestamp("INDATE"));
			qna.setQseq(rs.getInt("QSEQ"));
			qna.setRep(rs.getInt("REP"));
			qna.setReply(rs.getString("REPLY"));
			qna.setSubject(rs.getString("SUBJECT"));
			qnalist.add(qna);
		}
		return qnalist;
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	return null;
}
public void qnaWrite(QnaVO qna) {
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sql="insert into pro_qna(subject,content,id,image) values(?,?,?,?)";
	try {
		conn=DBAction.getInstance().getConnection();
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, qna.getSubject());
		pstmt.setString(2, qna.getContent());
		pstmt.setString(3, qna.getId());
		pstmt.setString(4, qna.getImage());
		pstmt.executeUpdate();
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null)pstmt.close();
			if(rs!=null)rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
public QnaVO qnaDetail(String qseq) {
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sql="select * from pro_qna where qseq=?";
	try {
		conn=DBAction.getInstance().getConnection();
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, qseq);
		rs=pstmt.executeQuery();
		if(rs.next()) {
			QnaVO qna = new QnaVO();
			qna.setSubject(rs.getString("SUBJECT"));
			qna.setContent(rs.getString("CONTENT"));
			qna.setId(rs.getString("ID"));
			qna.setImage(rs.getString("IMAGE"));
			qna.setIndate(rs.getTimestamp("INDATE"));
			qna.setQseq(rs.getInt("QSEQ"));
			qna.setRep(rs.getInt("REP"));
			qna.setReply(rs.getString("REPLY"));
			return qna;
		}
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	return null;
}
public void qnaDelete(String qseq) {
	Connection conn=null;
	PreparedStatement pstmt=null;
	String sql="delete from pro_qna where qseq=?";
	try {
		conn=DBAction.getInstance().getConnection();
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, qseq);
		pstmt.executeUpdate();
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
public ArrayList<QnaVO> qnaList(){
	ArrayList<QnaVO> qnalist=new ArrayList<QnaVO>();
	Connection conn=null;
	Statement pstmt=null;
	ResultSet rs=null;
	String sql="select * from pro_qna";
	try {
		conn=DBAction.getInstance().getConnection();
		pstmt=conn.createStatement();
		rs=pstmt.executeQuery(sql);
		while(rs.next()) {
			QnaVO qna=new QnaVO();
			qna.setContent(rs.getString("CONTENT"));
			qna.setId(rs.getString("ID"));
			qna.setIndate(rs.getTimestamp("INDATE"));
			qna.setQseq(rs.getInt("QSEQ"));
			qna.setRep(rs.getInt("REP"));
			qna.setReply(rs.getString("REPLY"));
			qna.setSubject(rs.getString("SUBJECT"));
			qnalist.add(qna);
		}
		return qnalist;
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	return null;
}
public ArrayList<QnaVO> qnaList(int tpage,String id) {
	ArrayList<QnaVO> qnalist=new ArrayList<QnaVO>();
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sql="select * from pro_qna where id like '%"
			+id+"%' order by qseq desc";
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
		QnaVO qna = new QnaVO();
		qna.setContent(rs.getString("CONTENT"));
		qna.setId(rs.getString("ID"));
		qna.setIndate(rs.getTimestamp("INDATE"));
		qna.setQseq(rs.getInt("QSEQ"));
		qna.setRep(rs.getInt("REP"));
		qna.setReply(rs.getString("REPLY"));
		qna.setSubject(rs.getString("SUBJECT"));
		qnalist.add(qna);
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
	return qnalist;
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
		str +="<a href='NonageServlet2?command=admin_inquiry&tpage=1&key="
				+id+"'>&lt;&lt;</a>&nbsp;&nbsp;";
		str +="<a href= 'NonageServlet2?command=admin_inquiry&tpage="
				+(start_page-1);
		str+="&key=<%id%>'>&lt;</a>&nbsp;&nbsp;";
	}
	for(int i =start_page;i<= end_page;i++) {
		if(i==tpage) {
			str += "<font color=red>[" + i + "]&nbsp;&nbsp;</font>";
		}else {
			str +="<a href='NonageServlet2?command=admin_inquiry&tpage="
					+i+"&key="+id+"'>["+i+"]</a>&nbsp;&nbsp;";
		}
	}
	if(page_count > end_page) {
		str+="<a href='NonageServlet2?command=admin_inquiry&tpage="
				+(end_page+1)+"&key="+id+"'> &gt; </a>&nbsp;&nbsp;";
		str+="<a href='NonageServlet2?command=admin_inquiry&tpage="
				+page_count + "&key="+id+"'> &gt; &gt; </a>&nbsp;&nbsp;";
	}
	return str;
}
public int totalRecord(String id) {
	int total_pages=0;
	String sql="select count(*) from pro_qna where id like '%"
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
public void qnaReply(String qseq,String reply) {
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sql="update pro_qna set rep=?, reply=?  where qseq=?";
	try {
		conn=DBAction.getInstance().getConnection();
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, "2");
		pstmt.setString(2, reply);
		pstmt.setString(3, qseq);
		pstmt.executeUpdate();
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
}
