package kr.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberRegisterController implements Controller {

	@Override
	public String requestHandelr(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//그냥 리턴만하는..
		
		return "member/memberRegister.html";
	}
	
	
}
