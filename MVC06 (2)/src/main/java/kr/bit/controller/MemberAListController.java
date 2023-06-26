package kr.bit.controller;

import java.io.IOException;
import java.util.*;
import kr.bit.model.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class MemberAListController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//gson은 json - 객체 
		Gson g = new Gson();
		List<MemberVO> list = new ArrayList<>();
		MemberDAO dao = new MemberDAO();
		list = dao.memberList();
		response.setContentType("text/html;charset=utf-8");
	    response.getWriter().print(g.toJson(list));
		
		
		return null;
	}

}
