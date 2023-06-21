package kr.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.bit.model.*;
public class MemberDoubleCheckController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		MemberDAO dao = new MemberDAO();
		String dbDouble = dao.memberCheck(id);
		//sql결과로 YES or NO거 dbDouble에 담김
		response.getWriter().print(dbDouble);
		//ajax()함수에 callback함수(dbCheck)로 응답이 된다.
		
		
		//널처리해서 화면전환 막기
		return null;
	}

}
