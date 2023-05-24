package kr.bit.contoller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.bit.model.*;

@WebServlet("/calc.do")
public class CalcController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라리언트에서 넘어오는 폼 파라메터 받기 (su1,su2)
		int su1 =  Integer.parseInt(request.getParameter("su1"));
		int su2 = Integer.parseInt(request.getParameter("su2"));
		
//		int sum =0;
//		for(int i=su1;i<=su2;i++) {
//			sum+=i;
//		}
		MyCalc my = new MyCalc();
		int sum = my.hap(su1,su2);
		PrintWriter out =response.getWriter();
		//프리젠테이션 로직 -->jsp가 담당 
		out.write("<html>");
		out.write("<head>");
		out.write("<body>");
		out.write("<table border ='1'>");
		out.write("<tr>");
		out.write("<td> TOTAL </td>");
		out.write("<td>");
		out.println(sum);
		out.write("</td>");
		out.write("</tr>");
		out.write("</table>");
		out.write("</body>");
		out.write("</head>");
		out.write("</html>");
	}

}
