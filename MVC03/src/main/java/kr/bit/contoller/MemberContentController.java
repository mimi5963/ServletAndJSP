package kr.bit.contoller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;


@WebServlet("/memberContent.do")
public class MemberContentController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		
		MemberDAO dao = new MemberDAO();
		MemberVO mem_inf = dao.memberContents(num);
		//객체바인딩
		request.setAttribute("mem_inf", mem_inf);
		RequestDispatcher rd = request.getRequestDispatcher("/member/memberContent.jsp");
		rd.forward(request, response);
	}

}
