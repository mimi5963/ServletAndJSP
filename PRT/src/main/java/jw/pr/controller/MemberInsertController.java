package jw.pr.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jw.pr.model.*;

@WebServlet("/memberInsert.do")
public class MemberInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 수집
		request.setCharacterEncoding("utf-8");
		
		String id= request.getParameter("id");
		String pass= request.getParameter("pass");
		String name= request.getParameter("name");
		int age= Integer.parseInt(request.getParameter("age"));
		String email= request.getParameter("email");
		String phone= request.getParameter("phone");
		
		MemberVO vo = new MemberVO(id,pass,name,age,email,phone);
		MemberDAO dao = new MemberDAO();
		
		int cnt = dao.memberInsert(vo);
		
		if(cnt >0) {
			response.sendRedirect("/PRT/memberList.do");
		}else {
			throw new ServletException("입력실패!");
		}
		
		
	}

}
