package com.lambda.ex;

@FunctionalInterface
interface Myfunc3{
	void myM();
}

public class Lex3 {

	int val =10;
	
	class Inner {
		int val=20;
		void method(int i) {
			int val =30;
			
			Myfunc3 f = () -> {
				System.out.println("i = "+ i);
				System.out.println("val="+val);
				System.out.println(" this.val="+ ++this.val);
				System.out.println(" outer.val ="+ Lex3.this.val);
			};
			
			f.myM();
		
		}
	}
	
	public static void main(String[] args) {
		Lex3 l = new Lex3();
		Lex3.Inner li = l.new Inner();
		li.method(100);
	}

}
