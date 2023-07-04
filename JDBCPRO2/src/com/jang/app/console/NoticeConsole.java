package com.jang.app.console;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.jang.app.model.NoticeDAO;
import com.jang.app.model.NoticeVO;

public class NoticeConsole {
	private static int page;
	private NoticeDAO dao;
	private boolean SearchOn; 
	private String Scope;
	private String Search;
	public NoticeConsole(){
		this.page = 1;
		dao = new NoticeDAO();
		SearchOn=false;
		this.Scope="";
		this.Search="";
	}
	public void printAll() throws SQLException {
		
		List<NoticeVO> list =dao.SelectALL(page);
		int totalPage = dao.getTotalPage();
		System.out.println();
		System.out.println("-----------------");
		System.out.println("<공지사항> 전체: "+totalPage);
		System.out.println("-----------------");
		for(NoticeVO vo: list) {
			System.out.print(vo.getId()+"/");
			System.out.print(vo.getContent()+"/");
			System.out.print(vo.getWriter_id()+"/");
			System.out.println(vo.getRegDate()+"/");
			
			
		}
		System.out.println("-----------------");
		totalPage = totalPage%10 ==0 ? totalPage/10 : totalPage/10+1;
		System.out.println(page +"/" +totalPage);
		System.out.println("-----------------");
		
		
	}
	public int menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1.상세보기/2.이전페이지/3.다음페이지/4.글추가/5.검색/6.종료");
		
		int result =sc.nextInt();
		
			
		return result;
	}
	
	
	public void prePage() {
		if(this.page ==1) {
			System.out.println("마지막페이지입니다.");
			return;
		}
		this.page--;
		
	}
	public void nextPage() throws SQLException {
		int totalPage=0;
		if(this.SearchOn==false) {
		 totalPage = dao.getTotalPage();
		}else {
		 totalPage = dao.getsearchPage(Scope, Search);	
		}
		totalPage = totalPage%10 ==0 ? totalPage/10 : totalPage/10+1;
		if(this.page == totalPage) {
			System.out.println("마지막페이지입니다.");
			return;
		}
		this.page++;
	}
	public void serch() throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("무엇을 찾고 싶으십니까? /title/writer_id/content");
		this.Scope = sc.nextLine();
		System.out.println("찾고 싶은 내용을 입력하세요");
		this.Search = sc.nextLine();
		this.page=1;
		
		
		EG:while(true) {
			this.SearchOn=true;
		   printSearch(page,Scope,Search);
		   int smenu = smenu();
		   switch(smenu) {
		   
		   case 1:prePage();
		          break;
		   case 2 : nextPage();
		          break;
		   case 3 : System.out.println("검색종료");
		          break EG;
		   }
		
		
		}
		this.page=1;
		this.SearchOn=false;
		
		
	}
	
	private int smenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1.이전페이지/2.다음페이지/3.돌아가기");
		
		int result =sc.nextInt();
		return result;
	}
	private void printSearch(int page, String Scope, String Search) throws SQLException {
		
		List<NoticeVO> list =dao.searchPage(page,Scope,Search);
		int totalPage = dao.getsearchPage(Scope,Search);
		System.out.println();
		System.out.println("-----------------");
		System.out.println("<검색 글 목록> 전체: "+totalPage);
		System.out.println("-----------------");
		for(NoticeVO vo: list) {
			System.out.print(vo.getId()+"/");
			System.out.print(vo.getContent()+"/");
			System.out.print(vo.getWriter_id()+"/");
			System.out.println(vo.getRegDate()+"/");
			
			
		}
		System.out.println("-----------------");
		totalPage = totalPage%10 ==0 ? totalPage/10 : totalPage/10+1;
		System.out.println(page +"/" +totalPage);
		System.out.println("-----------------");
		
	}
	
	
	
	
	

}
