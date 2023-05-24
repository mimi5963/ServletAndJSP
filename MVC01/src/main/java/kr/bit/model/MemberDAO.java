package kr.bit.model;
//JDBC -> mybatis, JPA으로 넘어감 
import java.sql.*;
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
		}
		return cnt;
		
	}
	
	
}
