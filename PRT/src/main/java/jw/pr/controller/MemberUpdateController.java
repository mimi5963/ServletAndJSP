package jw.pr.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jw.pr.model.*;


@WebServlet("/memberUpdate.do")
public class MemberUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		MemberVO member = new MemberVO();
		member.setNum(num);
		member.setAge(age);
		member.setEmail(email);
		member.setPhone(phone);
		MemberDAO dao = new MemberDAO();
		int cnt = dao.MemberUpdate(member);
		
		if(cnt>0) {
			response.sendRedirect("/PRT/memberList.do");
		}else {
			throw new ServletException("업데이트 실패");
		}
		
	}
}
