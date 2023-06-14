package kr.bit.model;
import java.io.InputStream;
// JDBC->myBatis
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mysql.jdbc.PreparedStatement;
public class MemberDAO {
 private static SqlSessionFactory sqlSessionFactory; 
 	//초기화 블럭
 	static {
 		try {
 		String resource = "kr/bit/mybatis/config.xml";
 		InputStream inputStream = Resources.getResourceAsStream(resource); //파일 읽기 위한 io
 		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
 		}catch(Exception e) {e.printStackTrace();}
 		
 		}
 	//회원전체 리스트보기 
 	public List<MemberVO> memberList() {
 		//connection+statement => sqlSession
 		SqlSession session =sqlSessionFactory.openSession();
 		List<MemberVO> list = session.selectList("memberList");//여러개를 가지고 오겠구나 생각
 		//sql명령문이 필요한데 어케 넣을려나?
 		//mybatis는 sql과 자바코드 이어준다고 했잖아 sql문은 mapper파일에 있어
 		//mapper파일에 있는 sql을 selectList에 넣어주자 selectList에는 뭔가 key값같은게..
 		session.close();
 		return list;
 		
 	}
 	//Insert
 	public int memberInsert(MemberVO vo) {
 		SqlSession session =sqlSessionFactory.openSession();
 		int cnt =session.insert("memberInsert", vo); //파라미터1은 sql id, 뒤는 객체 ->알아서해준대..
 		session.commit(); //insert작업같은것은 커밋해줭쥐
 		session.close();
 		return cnt;
 	}
 	// 회원삭제 
 	public int memberDelete(int num) {
 		SqlSession session =sqlSessionFactory.openSession();
 		int cnt = session.delete("memberDelete", num);
 		session.commit();
 		session.close();
 		return cnt;
 	}
 	
 	//회원 상세보기
 	public MemberVO memberContent(int num) {
 		SqlSession session =sqlSessionFactory.openSession();
 		MemberVO vo = session.selectOne("memberContent", num);
 		session.close();
 		return vo;
 	}
 	
 	//업데이트 
 	public int memberUpdate(MemberVO vo) {
 		SqlSession session =sqlSessionFactory.openSession();
 		int cnt = session.update("memberUpdate", vo);
 		session.commit();
 		session.close();
 		return cnt;
 	}
}


