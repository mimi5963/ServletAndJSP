package com.lambda.ex;
import java.util.Arrays;
import java.util.function.*;
public class Lex5 {

	public static void main(String[] args) {
		//기본형 함수 인터페이스 
		
		//IntSupperlier s = () -> (int)
		IntSupplier s = () -> (int)(Math.random()*100)+1;
		IntConsumer c = i -> System.out.println(i+" ");
		IntPredicate p = i -> i%2==0;
		IntUnaryOperator op = i -> i/10*10;
		Function<Integer,Integer> ops = i -> i/10*10;
		
		int[] arr = new int[10];
		
		makeRandomList(s,arr);
		System.out.println(Arrays.toString(arr));
		printEvenNum(p,c,arr);
		int[] newarr = doSometing(op,arr);
		System.out.println(Arrays.toString(newarr));
		
		int[] sarr = doSometing2(ops,arr);
		System.out.println(Arrays.toString(sarr));
	}

	private static int[] doSometing(IntUnaryOperator op, int[] arr) {
		int[] newArr= new int[arr.length];
		
		for(int i=0; i<newArr.length;i++)
			newArr[i] = op.applyAsInt(arr[i]);
		return newArr;
	}
	private static int[] doSometing2(Function<Integer,Integer> op, int[] arr) {
		int[] newArr= new int[arr.length];
		
		for(int i=0; i<newArr.length;i++)
			newArr[i] = op.apply(arr[i]); 
		return newArr;
	}

	private static void printEvenNum(IntPredicate p, IntConsumer c, int[] arr) {
		System.out.println("[");
		for(int i : arr) {
			if(p.test(i))
				c.accept(i);
		}
		System.out.println("]");
	}

	private static void makeRandomList(IntSupplier s, int[] arr) {
		for(int i=0; i<arr.length;i++)
			arr[i] = s.getAsInt();
		
	}

	
}
