package com.jang.app.ui;

import com.jang.app.console.NoticeConsole;

public class program {

	public static void main(String[] args) throws Exception {
		NoticeConsole nc = new NoticeConsole();
		
		SE:while(true) {
		nc.printAll();
		int select = nc.menu();
		
		switch(select) {
		
		case 1: //상세보기
			break;
		case 2: // 이전페이지
			nc.prePage();
			break;
		case 3: // 다음페이지
			nc.nextPage();
			break;
		case 4: // 글추가
			break;
		case 5: // 검색
			nc.serch();
			break;
		case 6://종료 
			System.out.println("bye!!");
		    break SE;
		default :
			System.out.println("선택은 정수로 1~6만 가능합니다.");
		}
		}
	}

}
