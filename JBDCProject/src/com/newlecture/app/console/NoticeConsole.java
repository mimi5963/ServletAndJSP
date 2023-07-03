package com.newlecture.app.console;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.newlecture.app.entitiy.Notice;
import com.newlecture.app.service.NoticeService;


public class NoticeConsole {
	
	private int page =1;
	private NoticeService ns;
	private String inputword;
	private String searchField;
	
	public NoticeConsole() {
		ns = new NoticeService();
		page =1;
		inputword="";
		searchField="TITLE";
	}
	public void printNoticeList()  {
		//list를 가져와야함 
		List<Notice> list =null;
		int count=0;
		int lastPage=0;
		try {
			
		count = ns.getCount();
		lastPage = count/10;
		lastPage = count%10 ==0 ? lastPage:lastPage+1;
		list = ns.getList(page,searchField,inputword);
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("─────────────────────────────");
		System.out.println("<공지사항> 총 "+count+" 게시글");
		for(int i=0; i<list.size();i++ ) {
			//if(i>=listCount)break;
			 Notice no = list.get(i);
			 System.out.print(no.getId()+". ");
			 System.out.print(no.getContent()+" / ");
			 System.out.print(no.getWriter_id()+" / ");
			 System.out.println(no.getRegDate());
		}
		System.out.println("      "+page+" / "+lastPage+"Pages");
		System.out.println("─────────────────────────────");
	}

	public int inputNoticeMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.print("1.상세보기/2.이전페이지/3.다음페이지/4.쓰기/5.검색/6.종료 >");
		int menu = sc.nextInt();
		
		
		
		return menu;
		
		
		
	}
	public void movePrevList() {
		if(page ==1) {
		
			System.out.println("이전 페이지가 없습니다.");
			return;
		}
		page--;
		
		
	}
	public void moveNextList() throws SQLException {
		List<Notice> list =null;	
		int count = ns.getCount();
		int lastPage = count/10;
		
		lastPage = count%10 ==0 ? lastPage:lastPage+1;
		if(page == lastPage) {
			System.out.println("마지막페이지입니다..");
			return;
		}
		page++;
	}
	public void inptSearchWord() {
		Scanner sc = new Scanner(System.in);
		System.out.println("검색 범주(title/content/writerId)중에 하나를 입력하세요");
		System.out.print(">");
		searchField = sc.nextLine();
		System.out.print("검색어 >");
		inputword = sc.nextLine();
	
	}
	
}
