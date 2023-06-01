package kr.bit.contoller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;


@WebServlet("/memberList.do")
public class MemberListController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//클라이언트 요청 받기 
		//2. 회원 전체 리스트 가져오기 (Model연동)
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberVO> list = dao.getMemberList();
		
		//객체바인딩
	    request.setAttribute("mlist", list);
	    //RequestDispatcher 연결
	    RequestDispatcher rd = request.getRequestDispatcher("member/memberList.jsp");
	    rd.forward(request, response);
	    
		
	}

}
