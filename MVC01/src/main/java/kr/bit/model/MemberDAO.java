package kr.bit.model;
//JDBC -> mybatis, JPA으로 넘어감 
import java.sql.*;
public class MemberDAO {
	private Connection conn;//DB와 연결 
	private PreparedStatement ps; //conn의 sql DB에 전송
	private ResultSet rs; //select 실행결과 저장 //실행결과를 마치 이터레이터처럼
	                      //한 행씩 받아올 수 있음
	
	
	
	
}
