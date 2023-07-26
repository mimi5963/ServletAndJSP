package kr.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberLogoutController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//세션종료방법
		// 1. 세션을 가져와서 강제종료
		//2 브라우저 종료
		//3 세션만료시간까지 기다리기
		String ctx = request.getContextPath();
		request.getSession().invalidate();
	
		return "redirect:"+ctx+"/memberList.do";
	}

}
