package jw.pr.pojo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jw.pr.model.MemberDAO;
import jw.pr.model.MemberVO;

public class MemberUpdateController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ctx = request.getContextPath();
		int num = Integer.parseInt(request.getParameter("num"));
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		MemberVO member = new MemberVO();
		member.setNum(num);
		member.setAge(age);
		member.setEmail(email);
		member.setPhone(phone);
		MemberDAO dao = new MemberDAO();
		int cnt = dao.MemberUpdate(member);
		String nextPage =null;
		if(cnt>0) {
			nextPage ="redirect:"+ctx+"/memberList.do";
		}else {
			throw new ServletException("업데이트 실패");
		}
		return nextPage;
	}

}
