package com.newlec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/notice-reg")
public class noticeController extends HttpServlet{
	
	
	public void service(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(title);
		pw.write(content);
		
	}

}
