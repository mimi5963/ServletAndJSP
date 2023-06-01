package kr.bit.contoller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;


@WebServlet("/memberInsert.do")
public class MemberInsertController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 파라미터 수집(vo)에 묶어주기 
		//request로 넘어온 값을 인코딩 해줘야함 
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		MemberVO vo = new MemberVO(id,pass,name,age,email,phone);
		//vo를 DAO에 넘겨서 DB에 INSERT하자
		
		//model과 연결 (DAO)
		MemberDAO dao = new MemberDAO();
		int cnt = dao.memberInsert(vo);
		PrintWriter out = response.getWriter();
		if(cnt>0) { //가입성공
			response.sendRedirect("/MVC03/memberList.do");
			 //DB 서버 실행되있어야함
		}else {//가입실패 
			throw new ServletException("not insert");
		}
		
		
	}

}
