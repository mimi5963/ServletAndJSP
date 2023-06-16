package jw.pr.pojo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jw.pr.model.MemberDAO;
import jw.pr.model.MemberVO;

public class MemberInsertController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String ctx = request.getContextPath();
		String id= request.getParameter("id");
		String pass= request.getParameter("pass");
		String name= request.getParameter("name");
		int age= Integer.parseInt(request.getParameter("age"));
		String email= request.getParameter("email");
		String phone= request.getParameter("phone");
		
		MemberVO vo = new MemberVO(id,pass,name,age,email,phone);
		MemberDAO dao = new MemberDAO();
		
		int cnt = dao.memberInsert(vo);
		String nextPage=null;
		if(cnt>0) {
			nextPage= "redirect:"+ctx+"/memberList.do";
		}
		return nextPage;
	}

}
