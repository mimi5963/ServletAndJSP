package kr.bit.model;
import java.io.InputStream;
// JDBC->myBatis
import java.sql.*;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
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
 
}


