package jw.pr.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jw.pr.model.*;


@WebServlet("/memberContent.do")
public class MemberContentController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		
		System.out.print("num"+num);
		MemberDAO dao = new MemberDAO();
		MemberVO member = dao.memberContent(num);
		
		//System.out.print(member.toString());
		
		request.setAttribute("member", member);
		RequestDispatcher rd = request.getRequestDispatcher("member/memberContent.jsp");
		rd.forward(request, response);
	}

}
