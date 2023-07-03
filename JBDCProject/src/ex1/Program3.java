package ex1;


import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program3 {
	private static Connection conn;
	private static Statement st;
	private static PreparedStatement prs;
	private static ResultSet rs;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		String title="TEST23";
		String writer_id ="newlec";
		String content="haha3";
		String files = "";
		int id = 25;
		
		String sql = 
		"DELETE NOTICE WHERE ID =?";
		
		getConn();
	//	st = conn.createStatement();
		prs = conn.prepareStatement(sql);
		prs.setInt(1, id);
		int cnt = prs.executeUpdate();
		
		System.out.println(cnt);
	}
	
	
	
	
	private static void getConn() {
		String url ="jdbc:oracle:thin:@localhost:1521/xepdb1";
		String user ="NEWLEC";
		String pass ="admin";
		try {
        
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url,user,pass);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private static void CloseAll() {
		
			try {
				if(rs != null)
				rs.close();
				if(st != null)
				st.close();
				if(conn != null)
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
	}
}
