package com.basic.question.whileloop;

public class Factorial {
	
	public static void main(String[] args) {
		
		int  a =5;
		int fact = 1;
		while(a>0) {
			fact = fact*a;
			a--;
		}
		System.out.println(fact);
	}
}
