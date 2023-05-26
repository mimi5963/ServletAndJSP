package kr.bit.contoller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;


@WebServlet("/memberList.do")
public class MemberListController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//클라이언트 요청 받기 
		//2. 회원 전체 리스트 가져오기 (Model연동)
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberVO> list = dao.getMemberList();
		
		
		//3. 회원 전체 리스트를 HTML로 만들어서 응답하기
		//System.out.println(list);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		
		out.println("<table border ='1'>");
		out.println("<thead>");
		out.println("<tr>");
		out.println("<th>번호</th>");
		out.println("<th>아이디</th>");
		out.println("<th>비밀번호</th>");
		out.println("<th>이름</th>");
		out.println("<th>나이</th>");
		out.println("<th>이메일</th>");
		out.println("<th>전화번호</th>");
		out.println("<th>삭제</th>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody>");
		for(MemberVO m : list) {
		    out.println("<tr>");
		    out.println("<td>"+m.getNum() +"</td>");
		    out.println("<td><a href='/MVC01/memberContent.do?num="+m.getNum()+"'>"+m.getId() +"</a></td>");
		    out.println("<td>"+m.getPass() +"</td>");
		    out.println("<td>"+m.getName() +"</td>");
		    out.println("<td>"+m.getAge() +"</td>");
		    out.println("<td>"+m.getEmail() +"</td>");
		    out.println("<td>"+m.getPhone() +"</td>");
		    out.println("<th><a href='/MVC01/memberDelete.do?num="+m.getNum()+"'>삭제</a></th>");
		    out.println("</tr>");
		}
		  
		out.println("</tbody>");
		out.println("<tr>");
		out.println("<td colspan='8' align='right'>");
		out.println("<a href='member/memberRegister.html'>회원가입</a>");
		out.println("</td>");	
		out.println("</tr>");
		out.println("</table>");
		
		out.println("</body>");
		out.println("</html>");
		
	}

}
