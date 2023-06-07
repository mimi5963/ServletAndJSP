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

import kr.bit.controller.Controller;
import kr.bit.controller.MemberContentController;
import kr.bit.controller.MemberDeleteController;
import kr.bit.controller.MemberInsertController;
import kr.bit.controller.MemberListController;
import kr.bit.controller.MemberRegisterController;
import kr.bit.controller.MemberUpdateController;
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
			Controller control = new MemberListController();
			String nextPage = control.requestHandelr(request, response);
			RequestDispatcher rd = request.getRequestDispatcher(nextPage);
			rd.forward(request, response);
					
		}else if(command.equals("/memberInsert.do")) {
			Controller control = new MemberInsertController();
			String nextPage = control.requestHandelr(request, response);
			if(nextPage !=null) {
				response.sendRedirect(nextPage);
			}
		}else if(command.equals("/memberRegister.do")) {
			Controller control = new MemberRegisterController();
			String nextPage = control.requestHandelr(request, response);
			RequestDispatcher rd = request.getRequestDispatcher(nextPage);
			rd.forward(request, response);
			
		}else if (command.equals("/memberContent.do")) {
			
			
			Controller control = new MemberContentController();
			String nextPage = control.requestHandelr(request, response);
			RequestDispatcher rd = request.getRequestDispatcher(nextPage);
			rd.forward(request, response);
			
			
		}else if (command.equals("/memberUpdate.do")) {
			
			Controller control = new MemberUpdateController();
			String nextPage = control.requestHandelr(request, response);
			response.sendRedirect(nextPage);
		
		}else if (command.equals("/memberDelete.do")) {
			//클라이언트를 통해 num값 넘어옴 이를 DAO에 넘겨야하는데
			//DAO에 Delete(num을 받아서) 삭제해주는 메서드 짜면 되는거아닐까?
			
			Controller control = new MemberDeleteController();
			String nextPage = control.requestHandelr(request, response);
			response.sendRedirect(nextPage);
			
		}
		
		
		
	}

}
