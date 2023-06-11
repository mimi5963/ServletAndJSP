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
		
		request.setCharacterEncoding("utf-8");
		
		// 클라이언트가 어떤 요청을 했는지 파악하기 
		String url=request.getRequestURI();
		// /MVC04/memberList.do 등 가져옴
		String ctx =request.getContextPath(); // /MVC04 -> context path가져옴
		//실제 요청명령 
		String command = url.substring(ctx.length()); // /memberInsert.do 등 
		String nextPage = null;
		
		Controller controller = null;
		HandlerMapping mapping = new HandlerMapping();
		controller = mapping.getController(command);
		nextPage = controller.requestHandelr(request, response);
		System.out.print(nextPage);
		//forward or redirect
		if(nextPage != null) {
			if(nextPage.indexOf("redirect:") != -1) {
				//substring
				response.sendRedirect(nextPage.split(":")[1]);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher(ViewResolver.makeView(nextPage));
				rd.forward(request, response);
			}
		}
		
		
	}

}
