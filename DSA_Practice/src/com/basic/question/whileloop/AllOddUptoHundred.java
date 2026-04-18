package com.basic.question.whileloop;

public class AllOddUptoHundred {
	public static void main(String[] args) {
		int a =0;
		while(a<=100) {
			// agar yahan increment hoga to 101 print ho jayega
			if(a%2!=0) {
				System.out.println(a);
			}
			a++; // 99
		}
	}
}
