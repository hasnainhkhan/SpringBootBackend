package com.basic.question.practice;

import java.util.Scanner;
public class AddTwoNumber {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String number = sc.nextLine();
		int result = addTwoNumber(number);
		System.out.println(result);
		sc.close();
	}
	static int addTwoNumber(String numbers) {
		int sum = 0;
		String regex = "[!@#$%^&*()\\\\s,.]+";
		String [] numberList = numbers.split(regex);
		int [] newNumList = new int[numberList.length];
		for(int i = 0; i<numberList.length; i++){
			newNumList[i] = Integer.parseInt(numberList[i]);
			sum = sum + newNumList[i];
			
		}
		return sum;
	}
	
}
