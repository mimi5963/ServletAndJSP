package jw.pr.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jw.pr.model.MemberDAO;



public class MemberDeleteController extends HttpServlet {
	 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		
		System.out.print("delete num="+num);
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.memberDelete(num);
		System.out.print("cnt="+cnt);
		if(cnt>0) {
			response.sendRedirect("/PRT/memberList.do");
		}else{
			throw new ServletException("삭제실패");
			
		}
	}

}
