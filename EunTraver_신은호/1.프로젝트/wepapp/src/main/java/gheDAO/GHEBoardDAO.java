package gheDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import gheVO.GHEBoardVO;
import study.DBAction;

public class GHEBoardDAO {
	private static GHEBoardDAO board = new GHEBoardDAO();
	public static GHEBoardDAO getInstance() {
		return board;
	}
	
	public ArrayList<GHEBoardVO> bestBoard(){
		ArrayList<GHEBoardVO> list = new ArrayList<GHEBoardVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			stmt = conn.createStatement();
			String sql = "select * from best_board_view";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				GHEBoardVO board = new GHEBoardVO();
				board.setName(rs.getString("bname"));
				board.setBgood(rs.getInt("bgood"));
				list.add(board);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				
			}
			
		}
		
		return list;
	}
	
}
