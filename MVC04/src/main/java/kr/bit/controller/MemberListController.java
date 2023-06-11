package kr.bit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

public class MemberListController implements Controller{

	@Override
	public String requestHandelr(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.getMemberList();
		//member/memberList.jsp가 최종목적지니까 front로부터 request,response받았겠다.
		//객체바인딩까지는 가자
		request.setAttribute("mlist", list);
		//다음페이지는 다음과 같습니다. 뽀워딩주소
		return "memberList";
	}

	
}
