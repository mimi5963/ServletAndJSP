package ex1;

import java.sql.SQLException;

import com.newlecture.app.console.NoticeConsole;

public class Program5 {

	public static void main(String[] args) throws SQLException {
		NoticeConsole cons = new NoticeConsole();
		int page;
		EXIT:while(true) {
		cons.printNoticeList();
		int menu = cons.inputNoticeMenu();
		
		switch(menu){
			case 1:  //상세
				break;
			case 2: 
				//page--;// 이전
				cons.movePrevList();
				break;
			case 3: //다음
				cons.moveNextList();
				//page++;
				break;
			case 4: //글쓰기
				break;
			case 5: //검색
				cons.inptSearchWord();
			
				break;
			case 6:
				System.out.println("Bye~~");
				break EXIT;
			default:
				System.out.println("<<사용방법>> 메뉴는1~6까지만 입력할 수 있습니다.");
				break;
		}
		
		}
	}

}
