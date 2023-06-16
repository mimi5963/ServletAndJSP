package jw.pr.pojo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jw.pr.model.MemberDAO;
import jw.pr.model.MemberVO;

public class MemberContentController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.print("num"+num);
		MemberDAO dao = new MemberDAO();
		MemberVO member = dao.memberContent(num);
		request.setAttribute("member", member);
		String nextPage = "memberContent";
		
		return nextPage;
	}

}
