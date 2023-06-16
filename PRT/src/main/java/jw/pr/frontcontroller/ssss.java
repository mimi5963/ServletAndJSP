package jw.pr.frontcontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ssss")
public class ssss extends HttpServlet {
	
   

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = request.getRequestURI();
		String Context = request.getContextPath();
		String command = url.substring(Context.length());
		
		//command검사 if else if ~
		
		//각 분기문마다 Controller 생성 requestHandler호출 - view이름 받음 ->view검사
		
		
		
	}

}
