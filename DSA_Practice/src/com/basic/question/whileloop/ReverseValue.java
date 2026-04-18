package com.basic.question.whileloop;

public class ReverseValue {
	
	public static void main(String[] args) {
		
		int num = 10001100;
		int rev = 0;
		 while(num > 0) {
	            int digit = num % 10;   // last digit nikala
	            rev = rev * 10 + digit; // reverse me add kiya
	            num = num / 10;         // last digit hata diya
	        }
		System.out.println(rev);
	}
}
