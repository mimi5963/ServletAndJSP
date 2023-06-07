package kr.bit.frontcontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;


@WebServlet("*.do")
public class MemberFrontController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr");
		
		// 클라이언트가 어떤 요청을 했는지 파악하기 
		String url=request.getRequestURI();
		// /MVC04/memberList.do 등 가져옴
		String ctx =request.getContextPath(); // /MVC04 -> context path가져옴
		//실제 요청명령 
		String command = url.substring(ctx.length()); // /memberInsert.do 등 
		
		//요청에 따른 분기 작업 
		if(command.equals("/memberList.do")) {
			//실제 로직 처리는 pojo~!
			MemberDAO dao = new MemberDAO();
			List<MemberVO> list = dao.getMemberList();
			request.setAttribute("mlist", list);
			RequestDispatcher rd = request.getRequestDispatcher("member/memberList.jsp");
			rd.forward(request, response);
					
		}else if(command.equals("/memberInsert.do")) {
			request.setCharacterEncoding("utf-8");
			String id = request.getParameter("id");
			String pass = request.getParameter("pass");
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			
			MemberVO vo = new MemberVO(id,pass,name,age,email,phone);
			//vo를 DAO에 넘겨서 DB에 INSERT하자
			MemberDAO dao = new MemberDAO();
			int cnt = dao.memberInsert(vo);
			PrintWriter out = response.getWriter();
			if(cnt>0) { //가입성공
				response.sendRedirect("/MVC04/memberList.do");
				 //DB 서버 실행되있어야함
			}else {//가입실패 
				throw new ServletException("not insert");
			}
			
		}else if(command.equals("/memberRegister.do")) {
			
			RequestDispatcher rd = request.getRequestDispatcher("member/memberRegister.html");
			rd.forward(request, response);
			
		}else if (command.equals("/memberContent.do")) {
			int num = Integer.parseInt(request.getParameter("num"));
			
			MemberDAO dao = new MemberDAO();
			MemberVO mem_inf = dao.memberContents(num);
			request.setAttribute("mem_inf", mem_inf);
			RequestDispatcher rd = request.getRequestDispatcher("/member/memberContent.jsp");
			rd.forward(request, response);
			
			
		}else if (command.equals("/memberUpdate.do")) {
			request.setCharacterEncoding("utf-8");
			//파라미터 수집 4개
			int num = Integer.parseInt(request.getParameter("num"));
			int age = Integer.parseInt(request.getParameter("age"));
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			
			MemberVO modify = new MemberVO();
			modify.setNum(num);
			modify.setAge(age);
			modify.setEmail(email);
			modify.setPhone(phone);
			
			MemberDAO dao = new MemberDAO();
			int cnt = dao.MemberUpdate(modify);
			
			if(cnt>0) { //업데이트 성공 
				response.sendRedirect("/MVC04/memberList.do"); //리스트로 돌아가기
				 //DB 서버 실행되있어야함
			}else {//업데이트 실패
				throw new ServletException("not update");
			}
			
			
		}else if (command.equals("/memberDelete.do")) {
			//클라이언트를 통해 num값 넘어옴 이를 DAO에 넘겨야하는데
			//DAO에 Delete(num을 받아서) 삭제해주는 메서드 짜면 되는거아닐까?
			int num = Integer.parseInt(request.getParameter("num"));
			
			MemberDAO dao = new MemberDAO();
			int cnt = dao.DeleteMember(num);
			if(cnt >0) {
			response.sendRedirect("/MVC04/memberList.do");
			}else {
				throw new ServletException("not insert");
			}
			
			
		}
		
		
		
	}

}
