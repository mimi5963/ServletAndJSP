package com.newlecture.app.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.newlecture.app.entitiy.Notice;

public class NoticeService {
	private static Connection conn;
	private static PreparedStatement pr;
	private static ResultSet rs;
	
	private static String url ="jdbc:oracle:thin:@localhost:1521/xepdb1";
	private static String user ="NEWLEC";
	private static String pass ="admin";
	private static String driver = "oracle.jdbc.driver.OracleDriver";
	
	public List<Notice> getList(int page,String field, String query) throws SQLException{
		String sql = "SELECT * FROM NOT2_VIEW WHERE "+field+" LIKE ? AND NUM BETWEEN ? AND ? ";
		
		getConn();
		pr = conn.prepareStatement(sql);
		pr.setString(1, "%"+query+"%");
		pr.setInt(2, (page-1)*10+1);
		pr.setInt(3, page*10);
		rs = pr.executeQuery();
		
		List<Notice> list = new ArrayList<>();
		while(rs.next()) {
			int id = rs.getInt("ID");
			String title = rs.getString("title");
			String writerid = rs.getString("WRITER_ID");
			Date regDate = rs.getDate("REGDATE");
			String content = rs.getString("CONTENT");
			int hit = rs.getInt("hit");
			String files = rs.getString("FILES");
			//결과 컬럼 대소 구분 안함 
			Notice not = new Notice(id,title,writerid,regDate,content,hit,files);
			list.add(not);
		}
		CloseAll();
		return list;
	}
	
	public int insert(Notice notice) throws SQLException {
		String title=notice.getTitle();
		String writer_id =notice.getWriter_id();
		String content=notice.getContent();
		String files =notice.getFiles();
		
		
		String sql = "INSERT INTO NOTICE ("
				+ "    title,"
				+ "    writer_id,"
				+ "    content,"
				+ "    files"
				+ ") VALUES (?,?,?,?)";
		
		getConn();

		pr = conn.prepareStatement(sql);
		pr.setString(1, title);
		pr.setString(2, writer_id);
		pr.setString(3, content);
		pr.setString(4, files);
		int cnt = pr.executeUpdate();
	
		CloseAll();
		return cnt;
	}
	public int update (Notice notice) throws SQLException{
		

		String title=notice.getTitle();
		String writer_id =notice.getWriter_id();
		String content=notice.getContent();
		String files = notice.getFiles();
		int id = notice.getId();
		
		String sql = 
		"UPDATE NOTICE SET TITLE=?,CONTENT=?,FILES=? WHERE ID =?";
		
		getConn();
	//	st = conn.createStatement();
		pr = conn.prepareStatement(sql);
		pr.setString(1, title);
		pr.setString(2,content);
		pr.setString(3, files);
		pr.setInt(4, id);
		int cnt = pr.executeUpdate();
		
		
		CloseAll();
		return cnt;
	}
	public int delete (int id)throws SQLException{
	
		
		String sql = 
		"DELETE NOTICE WHERE ID =?";
		getConn();
	
		pr = conn.prepareStatement(sql);
		pr.setInt(1, id);
		int cnt = pr.executeUpdate();
		return cnt;
	}
	
	
	
	private static void getConn() {
		
		try {
        
		Class.forName(driver);
		conn = DriverManager.getConnection(url,user,pass);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private static void CloseAll() {
		
			try {
				if(rs != null)
				rs.close();
				if(pr != null)
				pr.close();
				if(conn != null)
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
	}
	//scalat
	public int getCount() throws SQLException {
		String sql = "SELECT COUNT(ID) count FROM NOTICE";
		int result =0;
		getConn();
		pr = conn.prepareStatement(sql); 
		rs = pr.executeQuery();
		
		if(rs.next())
	   result = rs.getInt("count");
		
		CloseAll();
		return result;
	}
	
	
	
}


