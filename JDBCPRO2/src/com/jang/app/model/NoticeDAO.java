package com.jang.app.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class NoticeDAO {
	private static Connection conn;
	private static ResultSet rs;
	private static PreparedStatement pr;
	
	private static String url ="jdbc:oracle:thin:@localhost:1521/xepdb1";
	private static String user_id="JANG";
	private static String pwd ="jang";
	private static String driver="oracle.jdbc.driver.OracleDriver";
	
	public List<NoticeVO> SelectALL(int page) throws SQLException {

		String sql ="SELECT * FROM NO_NO_J WHERE NUM BETWEEN ? AND ?";
	    List<NoticeVO> list = new ArrayList<>();
		getconn();
	    pr = conn.prepareStatement(sql);
	    pr.setInt(1, (page-1)*10+1);
	    pr.setInt(2, page*10);
	    rs = pr.executeQuery();
	    while(rs.next()) {
	    	int id = rs.getInt("ID");
			String title = rs.getString("title");
			String writerid = rs.getString("WRITER_ID");
			Date regDate = rs.getDate("REGDATE");
			String content = rs.getString("CONTENT");
			int hit = rs.getInt("hit");
			String files = rs.getString("FILES");
			//결과 컬럼 대소 구분 안함 
			NoticeVO not = new NoticeVO(id,title,writerid,regDate,content,hit,files);
			list.add(not);
	    }
	    closeall();
		return list;
	}

	public int getTotalPage() throws SQLException {
		String sql = "SELECT COUNT(id) as count FROM NEWLEC.NOTICE";
		getconn();
		pr = conn.prepareStatement(sql);
		rs = pr.executeQuery();
		rs.next();
		int total = rs.getInt("count");
		closeall();
		return total;
	}
	
	private  void getconn() {
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user_id,pwd);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void closeall() throws SQLException{
		if(rs != null) rs.close();
		if(pr != null) pr.close();
		if(conn != null) conn.close();
		
	}

	public List<NoticeVO> searchPage(int page, String Scope, String Search) throws SQLException {
		String sql ="SELECT * FROM(SELECT ROWNUM NUM2, NO_NO_J.* FROM NO_NO_J WHERE "+Scope+" LIKE ? order by NUM DESC) WHERE NUM2 BETWEEN ? AND ?";
	    List<NoticeVO> list = new ArrayList<>();
		getconn();
	    pr = conn.prepareStatement(sql);
	    pr.setString(1, "%"+Search+"%");
	    pr.setInt(2, (page-1)*10+1);
	    pr.setInt(3, page*10);
	    rs = pr.executeQuery();
	    while(rs.next()) {
	    	int id = rs.getInt("ID");
			String title = rs.getString("title");
			String writerid = rs.getString("WRITER_ID");
			Date regDate = rs.getDate("REGDATE");
			String content = rs.getString("CONTENT");
			int hit = rs.getInt("hit");
			String files = rs.getString("FILES");
			//결과 컬럼 대소 구분 안함 
			NoticeVO not = new NoticeVO(id,title,writerid,regDate,content,hit,files);
			list.add(not);
	    }
	    closeall();
		return list;
	}

	public int getsearchPage(String Scope, String Search) throws SQLException {
		String sql="SELECT count(id) count FROM(SELECT ROWNUM NUM2, NO_NO_J.* FROM NO_NO_J WHERE "+Scope+" LIKE ? order by NUM DESC)";
		getconn();
		pr = conn.prepareStatement(sql);
		pr.setString(1, "%"+Search+"%");
		rs = pr.executeQuery();
		rs.next();
		int result = rs.getInt("count");
		return result;
	}

	
}
	
	
	
	


