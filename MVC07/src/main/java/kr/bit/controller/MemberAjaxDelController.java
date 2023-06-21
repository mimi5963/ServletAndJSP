package kr.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.*;

public class MemberAjaxDelController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
	int num=Integer.parseInt(request.getParameter("num"));
		
		MemberDAO dao=new MemberDAO();
		int cnt=dao.memberDelete(num);
		
		response.getWriter().print(cnt);
		//형식적으로 response해준것 cnt를 가지고 뭘 하진않음 memberList()자체가 매개변수도없으~
		
		// TODO Auto-generated method stub
		return null;
	}

}
