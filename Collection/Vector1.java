package Collection;

import java.util.List;
import java.util.Vector;

public class Vector1 {

    public static void main (String[] args){

        List<Board> list = new Vector<>();
        Thread th1 = new Thread(new BoardTask(list));
        Thread th2 = new Thread(new BoardTask2(list));

        th1.start();
        th2.start();

        try{
            th1.join();
            th2.join();
        }catch (Exception e){}


        int size = list.size();
        System.out.println("총 객체 수:" +size);
        System.out.println();
    }

}

class Board {
    String title;
    String content;
    String Auth;

    Board(String title, String content, String Auth){
        this.title = title;
        this.content = content;
        this.Auth = Auth;
    }
}

class BoardTask implements Runnable{
    private List<Board> list;
    BoardTask(List<Board> list){
        this.list = list;
    }
    @Override
    public void run() {
        if(this.list != null)
            for(int i=1; i<=1000;i++)
                list.add(new Board("제목"+i,"내용"+i,"글쓴이"+i));
    }
}

class BoardTask2 implements Runnable{
    private List<Board> list;
    BoardTask2(List<Board> list){
        this.list = list;
    }
    @Override
    public void run() {
        if(this.list != null)
            for(int i=1001; i<=2000;i++)
                list.add(new Board("제목"+i,"내용"+i,"글쓴이"+i));
    }
}