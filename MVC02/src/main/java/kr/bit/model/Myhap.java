package kr.bit.model;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;


@WebServlet("/test01.jsp")
public class Myhap extends HttpServlet {
	final PageContext pageConext=null;
	javax.servlet.http.HttpSession session = null;
	final javax.servlet.ServletContext application =null;
	//내장객체들
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//서비스 로직 <%%>
		int sum=0;
		for(int i=1; i<=10;i++) sum += i;
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.write("<html>");
	}
	
	
	
	
	public int hap(int s, int e) {
		int sum =0;
		for(int i=s; i<=e; i++) sum+=i;
		return sum;
	}

}
