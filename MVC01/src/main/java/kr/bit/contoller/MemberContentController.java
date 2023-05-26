package kr.bit.contoller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;


@WebServlet("/memberContent.do")
public class MemberContentController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		
		MemberDAO dao = new MemberDAO();
		MemberVO mem_inf = dao.memberContents(num);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		
		pw.println("<html>");
		pw.println("<head>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<form action='/MVC01/memberUpdate.do' method='post'>");
		
		pw.println("<input type='hidden' name='num' value='"+mem_inf.getNum()+"' />");
		pw.println("<table>");
		pw.println("<tr>");
		pw.println("</tr>");
		if(mem_inf != null) {
			
			pw.println("<tr>");
			pw.println("<td colspan='2'>"+mem_inf.getName()+"회원의 상세보기</td>");
			pw.println("</tr>");
			
			pw.println("<tr>");
			pw.println("<td>번호</td>");
			pw.println("<td>"+mem_inf.getNum()+"</td>");
			pw.println("</tr>");
			
			pw.println("<tr>");
			pw.println("<td>아이디</td>");
			pw.println("<td>"+mem_inf.getId()+"</td>");
			pw.println("</tr>");
			
			pw.println("<tr>");
			pw.println("<td>비밀번호</td>");
			pw.println("<td>"+mem_inf.getPass()+"</td>");
			pw.println("</tr>");
			
			pw.println("<tr>");
			pw.println("<td>이름</td>");
			pw.println("<td>"+mem_inf.getName()+"</td>");
			pw.println("</tr>");
			
			pw.println("<tr>");
			pw.println("<td>나이</td>");
			pw.println("<td><input type='text' name='age' value='"+mem_inf.getAge()+"'></td>");
			pw.println("</tr>");
			
			pw.println("<tr>");
			pw.println("<td>이메일</td>");
			pw.println("<td><input type='text' name='email' value='"+mem_inf.getEmail()+"'></td>");
			pw.println("</tr>");
			
			pw.println("<tr>");
			pw.println("<td>전화번호</td>");
			pw.println("<td><input type='text' name='phone' value='"+mem_inf.getPhone()+"'></td>");
			pw.println("</tr>");
			
		}else {
			pw.println("<tr>");
			pw.println("<td> 일치하는 회원이 없습니다. </td>");
			pw.println("</tr>");
		}
		pw.println("<tr>");
		pw.println("<td colspan='2' align='center'>");
		pw.println("<input type= 'submit' value='수정'/>");
		pw.println("<input type= 'reset' value='취소'/>");
		pw.println("<a href ='/MVC01/memberList.do'>돌아가기</a>");
		pw.println("</td>");
		pw.println("<tr>");
		pw.println("</table>");
		pw.println("</form>");
		pw.println("</body>");
		pw.println("</html>");
	}

}
