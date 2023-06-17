package kr.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

public class MemberLoginController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String ctx=request.getContextPath();
		//로그인에서 넘어온 값
		String user_id = request.getParameter("user_id");
		String password = request.getParameter("password");
		//vo에 담아서
		MemberVO vo = new MemberVO();
		vo.setId(user_id);
		vo.setPass(password);
		
		MemberDAO dao = new MemberDAO();
		//DB에 있는지 확인하고, user_name받아올 것 
		String user_name = dao.memberLogin(vo);
		// user_name에 값이 있으면 인증성공, 아니면 실패한거 
		
		if(user_name != null && !"".equals(user_name)) {
			//로그인 성공
			//성공상태 유지 session으로 유지
			request.getSession().setAttribute("userId", user_id);
			request.getSession().setAttribute("userName", user_name);
			
		}else {
			request.getSession().setAttribute("userId","");
			request.getSession().setAttribute("userName","");
			request.getSession().setAttribute("msg", "사용자 정보가 올바르지 않습니다.");
			
		}
		
		return "redirect:"+ctx+"/memberList.do";
	}

}
