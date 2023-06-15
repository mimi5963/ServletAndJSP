package jw.pr.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private void getConn() {
		String url="jdbc:mysql://localhost:3306/test2?characterEncoding=UTF-8&serverTimeZone=UTC";
		String id="root";
		String pass="admin12345";
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection(url, id, pass);
	}catch(Exception e) {e.printStackTrace();}
	}
	
	
	public List<MemberVO> memberList(){
		String sql ="SELECT * FROM member2";
		List<MemberVO> list = new ArrayList<>();
		MemberVO member;
		getConn();
		try {
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int num = rs.getInt("num");
				String id = rs.getString("id");
				String pass = rs.getString("pass");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				member = new MemberVO(num,id,pass,name,age,email,phone);
				list.add(member);
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeConn();
		}
		
		
		return list;
	}
	
	public MemberVO memberContent(int num) {
		String sql ="SELECT * FROM member2 WHERE num=?";
		getConn();
		MemberVO member=null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			while(rs.next()) {
			String id = rs.getString("id");
			String pass = rs.getString("pass");
			int age = rs.getInt("age");
			String name = rs.getString("name");
			String email = rs.getString("email");
			String phone = rs.getString("phone");
			member = new MemberVO(num,id,pass,name,age,email,phone);
			}
		}catch(Exception e) {e.getStackTrace();
		
		}finally {
			closeConn();
		}
		return member;
	}
	public int memberInsert(MemberVO vo) {
		String sql ="INSERT INTO member2(id,pass,name,age,email,phone) values(?,?,?,?,?,?)";
		getConn();
		int cnt=-1;
		try {
		
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPass());
			ps.setString(3, vo.getName());
			ps.setInt(4, vo.getAge());
			ps.setString(5, vo.getEmail());
			ps.setString(6, vo.getPhone());
			cnt = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeConn();
		}
		
		return cnt;
	}
	public int memberDelete(int num) {
		String sql="DELETE FROM member2 WHERE num=?";
		int cnt=-1;
		getConn();
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, num);
			cnt = ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeConn();
		}
		
		return cnt;
	}
	
	public int MemberUpdate(MemberVO vo) {
		String sql = "UPDATE member2 SET age=?,email=?,phone=? WHERE num=?";
		getConn();
		int cnt=-1;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, vo.getAge());
			ps.setString(2, vo.getEmail());
			ps.setString(3, vo.getPhone());
			ps.setInt(4, vo.getNum());
			cnt = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeConn();
		}
		return cnt;
	}
	
	
	private void closeConn() {
		try {
		if(rs != null) rs.close();
		if(ps != null) ps.close();
		if(conn != null) conn.close();
		}catch(Exception e) {e.printStackTrace();}
	}
	
}
