package com.jw.apps;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	@RequestMapping("/memberList.do")
	public String memberList() { //request,response 받을 필요 없음, 예외 안던져도됨 
		
		return "memberList";
	}
	@RequestMapping("/memberInsert.do")
	public String memberInsert() { //request,response 받을 필요 없음, 예외 안던져도됨 
		
		return "redirect:/memberList.do";
	}
	@RequestMapping("/memberRegister.do")
	public String memberRegister() { //request,response 받을 필요 없음, 예외 안던져도됨 
		
		return "memberRegister";
	}
	

}
