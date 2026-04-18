package com.basic.question.practice;

public class ProductAllNumber {
	
	public static void main(String[] args) {
		int a = 1;
		int product = 1;
		while(a<100) {
			product = product*a;
			a++;
		}
		System.out.println(product);
	}
}
