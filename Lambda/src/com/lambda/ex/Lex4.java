package com.lambda.ex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.ToIntFunction;

public class Lex4 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<10;i++)list.add(i);
		
		//리스트 모든 요소 출력
		list.forEach(i -> System.out.println(i+","));
		System.out.println();
		
		//list에서 2또는 3의 배수 제거
		list.removeIf(i -> {return i%2 ==0 || i%3 == 0;});
		System.out.println(list);
		
		list.replaceAll(i -> i*10);
		System.out.println(list);
		
		Map<String,String> map = new HashMap<>();
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		
		//map의 모든 요소 kv로 출력
       map.forEach((x,y) -> {System.out.println("키="+x+" "+"val"+y);});
       
       //껍데기 인터페이스에 함수 정의, 이거 가지고 내부적으로 사용하는거임 x,y에 내부적으로 키와 val을 넣어주는게 
       //구현되어 있음 ex f라는 매개변수에 위에 구현내용 받아서, f.run(키,벨류) 하는거
       
       
	}

}
