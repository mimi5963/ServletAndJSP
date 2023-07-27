package com.jw.apps;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberDAO dao;
	
	@RequestMapping("/memberList.do")
	public String memberList(Model model) { //request,response 받을 필요 없음, 예외 안던져도됨 
		List<MemberVO> list = dao.memberList();  //객체 바인딩용 객체 model은 request에 바인딩하는 것과 일맥상통 
		model.addAttribute("list", list);
		return "memberList";
	}
	@RequestMapping("/memberInsert.do")
	public String memberInsert(MemberVO vo) { 
		//인코딩을 안해줬다 (frontcontroller 직접 만들었을 땐 했는디!) ->필터를 걸어주자 
		//파라미터 수집 
		int cnt = dao.memberInsert(vo);
		
		
		return "redirect:/memberList.do";
	}
	@RequestMapping("/memberRegister.do")
	public String memberRegister() { 
		
		return "memberRegister";
	}
	@RequestMapping("/memberDelete.do")
	public String memberDelete(@RequestParam("num")int num) {
		int cnt =dao.memberDelete(num);
		
		return "redirect:/memberList.do";
	}
	@RequestMapping("/memberContent.do")
	public String memberContent(int num,Model model) {
		model.addAttribute("vo",dao.memberContent(num));
		
		return "memberContent";
	}
	
	@RequestMapping("/memberUpdate.do")
	public String memberUpdate(MemberVO vo) {
		
		
		return "redirect:/memberList.do";
	}
	

}
