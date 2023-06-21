package kr.bit.controller;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.bit.model.*;
public class MemberAjaxListController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<MemberVO> list;
		MemberDAO dao = new MemberDAO();
		list =dao.memberList();
		//Gson API -- list to json
		Gson g = new Gson();
		String json = g.toJson(list);
		//$.ajax() -->json
		response.setContentType("text/json;charset=euc-kr");
		response.getWriter().print(json);
		
		
		return null;
	}

}
