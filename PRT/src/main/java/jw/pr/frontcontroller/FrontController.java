package jw.pr.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jw.pr.pojo.*;


@WebServlet("*.do")
public class FrontController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//모든요청 
		String url = request.getRequestURI();
		//contextpath(/PRT)
		String ctx = request.getContextPath();
		//(/요청.do)
		String command = url.substring(ctx.length());
		String nextPage=null;
		Controller cr =null;
		
		HandlerMapping mp = new HandlerMapping();
		cr = mp.getController(command);
		nextPage = cr.requestHandler(request, response);
		
		if(nextPage != null) {
		if(nextPage.contains("redirect:")) {
			response.sendRedirect(nextPage.split(":")[1]);

		}else {
			//아닐시 forward
			RequestDispatcher rd = request.getRequestDispatcher(ViewResolver.getPath(nextPage));
			rd.forward(request, response);
		}
		
		}
		
		
	}

}
