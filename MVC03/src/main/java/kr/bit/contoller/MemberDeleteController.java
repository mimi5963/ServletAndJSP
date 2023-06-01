package kr.bit.contoller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;


@WebServlet("/memberDelete.do")
public class MemberDeleteController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//클라이언트를 통해 num값 넘어옴 이를 DAO에 넘겨야하는데
		//DAO에 Delete(num을 받아서) 삭제해주는 메서드 짜면 되는거아닐까?
		int num = Integer.parseInt(request.getParameter("num"));
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.DeleteMember(num);
		if(cnt >0) {
		response.sendRedirect("/MVC03/memberList.do");
		}else {
			throw new ServletException("not insert");
		}
	}

}
