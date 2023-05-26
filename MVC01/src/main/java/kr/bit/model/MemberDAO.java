package kr.bit.model;
//JDBC -> mybatis, JPA으로 넘어감 
import java.sql.*;
import java.util.ArrayList;
public class MemberDAO {
	
	private Connection conn;//DB와 연결 
	private PreparedStatement ps; //conn의 sql DB에 전송
	private ResultSet rs; //select 실행결과 저장 //실행결과를 마치 이터레이터처럼
	                      //한 행씩 받아올 수 있음
	
	//데이터 베이스 연결객체 생성해야함 커넥션
	public void getConnect() {
		String URL ="jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8&serverTimeZone=UTC";
		String user="root";
		String password="admin12345";
		//mysql 드라이버를 로딩해야함 Driver Loading
		//드라이버란 데이터베이스 종류는 많은데 이걸 드라이버로 
		//드라이버 클래스 com.mysql.jdc.Driver
		try {
			//동적로딩
			Class.forName("com.mysql.jdbc.Driver");
			//드라이버를 얻고 실제 커넥션을 얻기
			conn = DriverManager.getConnection(URL,user,password); //연결완료 후 연결정보 넘김
			//그 연결정보를 받아오는게 Connetion클래스 
		} catch (Exception e) {
			e.printStackTrace();
		} //동적로딩 실행시점에서 메모리를 올림 
			
		
	}
	public int memberInsert(MemberVO vo) {
		//?sql파라미터 
		String SQL ="INSERT INTO member(id,pass,name,age,email,phone) values(?,?,?,?,?,?)";
		getConnect();
		int cnt =-1;
		//SQL문장 전송 객체 
		try {
			ps = conn.prepareStatement(SQL); //미리 컴파일 시킴(속도가 빨라서)
			//ps는 이미 컴파일 된 sql(프리컴파일) 가지고 있음 (ps한테 준거임 미리 한번 컴파일해서)
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPass());
			ps.setString(3, vo.getName());
			ps.setInt(4, vo.getAge());
			ps.setString(5, vo.getEmail());
			ps.setString(6, vo.getPhone());
			cnt = ps.executeUpdate(); // 전송(실행) ps가 채워서 진짜 보냄 (성공1,실패0)
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;
		
	}
	//회원 전체리스트 어레이리스트로 가져오기
	public ArrayList<MemberVO> getMemberList() {
		String sql = "SELECT * FROM member";
		getConnect();
		MemberVO mem;
		ArrayList<MemberVO> members= new ArrayList<>(); 
		try {
			ps = conn.prepareStatement(sql);
			rs =ps.executeQuery();
			while(rs.next()) {
			int num = rs.getInt("num");
			String id = rs.getString("id");
			String pass= rs.getString("pass");
			String name = rs.getString("name");
			int age = rs.getInt("age");
			String email = rs.getString("email");
			String phone = rs.getString("phone");
			mem = new MemberVO(num,id,pass,name,age,email,phone);
			//num들어간 생성자 있었던 이유!
			members.add(mem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		return members;
	}
	
	// 데이터베이스 연결 끊기
	public void dbClose() {
		try {
			if(rs != null)rs.close();
			if(ps != null)ps.close();
			if(conn != null)conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public int DeleteMember(int num) {
		String sql = "delete from member where num =?";
		int cnt=-1;
		getConnect();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			cnt = ps.executeUpdate(); //1 or 0

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;
	}
	
	public MemberVO memberContents(int num) {
		MemberVO content=null;
		String sql = "select * from member where num=?";
		getConnect();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			rs =ps.executeQuery();
			if(rs.next()) {
				String id = rs.getString("id");
				String pass= rs.getString("pass");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				content = new MemberVO(num,id,pass,name,age,email,phone);
			}else {
				throw new Exception();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		
		return content;
	}
	
	public int MemberUpdate(MemberVO modify) {
		String sql ="update member set age=?,email=?,phone=? where num=?";
		getConnect();
		int cnt=-1;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, modify.getAge());
			ps.setString(2, modify.getEmail());
			ps.setString(3, modify.getPhone());
			ps.setInt(4, modify.getNum());
			
			cnt = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;
	}
}
