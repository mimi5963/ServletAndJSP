package com.lambda.ex;

public interface sddssd {
	
 public default int max(int a,int b) {
	 return a;
 }
 public int min (int a, int b);
}

class s implements sddssd{
	int s=10;
	public static void main (String[] args) {
		s s = new s();
		s.max(0, 0);
	}

	@Override
	public int min(int a, int b) {
		int result =this.s + a;
		return 0;
	}
	
}


