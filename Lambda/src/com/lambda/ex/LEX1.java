package com.lambda.ex;

import java.util.Arrays;

public class LEX1 {

	public static void main(String[] args) {
		
		//람다식은 근데 어디 들어갈 수 있냐?
//		int[] arr = new int[] {1,2,3,4,5};
//		int max = new Object() {int max(int a, int b ){return a>b ? a: b;}}.max(1, 2);
//		System.out.println(max);
//		
//		int sum = new Myfunc() {
//			public int sum(int[] arr){ 
//			int sum=0;
//			for(int i: arr) {
//				sum+=i;
//			}
//			return sum;
//		}
//		}.sum(arr);
//		
//		System.out.println(sum);
		int i=10;
		Myfunc f22 = () -> System.out.println(i);
		Myfunc f1 = ()->System.out.println("f1 run"); 
		Myfunc f2 = new Myfunc() {
			public void run() {
				System.out.println("f2 run");
			}
		};
		Myfunc f3= LEX1.getMyFunc();
		f1.run();
		f2.run();
		f3.run();
		f22.run();
		LEX1.execute(f3);
		LEX1.execute(f2);
		LEX1.execute(f1);
		
		
	}
	
	static void execute(Myfunc f) {f.run();}
	static Myfunc getMyFunc() {
		Myfunc f = () -> {System.out.println("f3 run");};
		return f;
	}
}
