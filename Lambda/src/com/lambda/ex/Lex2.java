package com.lambda.ex;


@FunctionalInterface
interface Myfunc2{
	void myM();
}

public class Lex2 {
//람다식 형변환
Myfunc2 f = () -> {};
Object obj = (Myfunc)(()->{});
//굳이라는 생각이..

	
}
