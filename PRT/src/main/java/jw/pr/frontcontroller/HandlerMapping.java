package jw.pr.frontcontroller;

import java.util.HashMap;

import jw.pr.pojo.Controller;
import jw.pr.pojo.*;

public class HandlerMapping {
	private HashMap<String,Controller> mappings = new HashMap<>();
	
	public HandlerMapping() {
		mappings.put("/memberList.do", new MemberListController());
		mappings.put("/memberDelete.do", new MemberDeleteController());
		mappings.put("/memberInsert.do", new MemberInsertController());
		mappings.put("/memberRegister.do", new MemberRegisterController());
		mappings.put("/memberContent.do", new MemberContentController());
		mappings.put("/memberUpdate.do", new MemberUpdateController());
	}
	
	public Controller getController(String key) {
		return this.mappings.get(key);
	}
	
	
	
}
