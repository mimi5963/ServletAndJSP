package com.newlec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/add.do")
public class AddController extends HttpServlet{
	
	
	public void service(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		String v_ = request.getParameter("v");
		String bu = request.getParameter("button");
		//ServletContext application = request.getServletContext();
		HttpSession session = request.getSession();
		
		Cookie[] cookies = request.getCookies();
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		
		int v= 0;
		
		if(!v_.equals("")) v =Integer.parseInt(v_);
		
		//계산
		if(bu.equals("=")) {
			
			//int x = (Integer)session.getAttribute("value");
			
			int x=0;
			for(Cookie c: cookies) 
			if(c.getName().equals("value")) {
				x = Integer.parseInt(c.getValue());
				break;
			}
		
			
			int y = v; //=눌렀을때 전달된 숫자 
			//어플리케이션에 저장되어있던 오퍼레이터
			//String op =(String)session.getAttribute("bu");
			String op="";
			for(Cookie c: cookies) 
				if(c.getName().equals("bu")) {
					op = c.getValue();
					break;
				}
			
			int result =0;
			
			if(op.equals("+")) {
				result =x+y;
			}
			else result =x-y;
			
			pw.write(result+"");
		}
		//값저장
		else {
			//맵형태로 저장
//		session.setAttribute("value", v);
//		session.setAttribute("bu", bu);
			
		Cookie valcookie = new Cookie("value",String.valueOf(v));
		Cookie opcookie = new Cookie("bu",bu);
		response.addCookie(valcookie);
		response.addCookie(opcookie);
		response.sendRedirect("/newl/add.html");
		
		}
		
		
		
	}

}
