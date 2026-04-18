package com.basic.question.practice;

public class DtoBinary {
	
	public static void main(String [] args) {
		int num = 4;
		StringBuilder bin = new StringBuilder();
		while(num>0) {
		int bit = num%2;
		bin.append((char) ('0'+bit));
		num=num/2;
		
		}
		String binary = bin.reverse().toString();
		System.out.println(binary);
		
	}
}
