package com.basic.question.whileloop;

public class SumOfAllEven {
	public static void main(String[] args) {
		int a=0;
		int sum = 0;
		while(a<=100) {
			if(a%2==0) {
				sum +=a;
			}
			a++;
		}
		System.out.println(sum);
	}
}
