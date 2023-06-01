package kr.bit.forward;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberVO;


@WebServlet("/fc.do")
public class forwardController extends HttpServlet {

       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. forward 실습 
		
		String name ="apple";
		int age = 45;
		String email ="aaa@emap.com";
		//2. 데이터를 request에 저장하고 view에서 출력하도록 하기 (result.jsp)
		// 컨트롤러에서 view로 페이지 전화나는 방법
		//1.redirect, 2 forward
		//response.sendRedirect("view/result.jsp");
		MemberVO vo = new MemberVO();
		vo.setAge(age);
		vo.setEmail(email);
		vo.setName(name);
		request.setAttribute("vo", vo);
		RequestDispatcher rd = request.getRequestDispatcher("view/result.jsp");
		rd.forward(request, response);

		
		
	}

}
