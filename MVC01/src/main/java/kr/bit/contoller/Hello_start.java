package kr.bit.contoller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/h.do")
public class Hello_start extends HttpServlet {
	
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.클라이언트의 요청을 받는 작업(클라이언트로 넘어오는 파라미터 수집)
		//2.처리 작업 (비지니스 로직)
		
		int sum =0;
		//3.요청한 클라이언트에게 응답하는 작업 
		
	}

}
