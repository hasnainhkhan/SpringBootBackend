package com.basic.question;
import java.util.Scanner;
public class AddTwoNumber {
		
		static String numbers;
		
	
	public static void main(String [] args) {
		//create scanner class object
		Scanner sc = new Scanner(System.in); 
		
		System.out.println("Enter the number");
		//use to take inut from user
		numbers = sc.nextLine();
		//split using space
//		String[] words = numbers.split(" ");
//		//array create same size of words
//		int [] numarray = new int[words.length]; 
//		for(int i=0; i<words.length; i++) {
//			numarray[i] =Integer.parseInt( words[i]);
//			sum += numarray[i];
//			
//		}
//		System.out.println("Sum:"+sum);
		
		int result [] = sumOfNumber(numbers);
		int avg = avarageNumber(numbers);
//		System.out.println(result[0]);
		System.out.println(avg + "avg ");
		
		
		
	}
	
	static int [] sumOfNumber(String numers) {
		int sum = 0;
		String [] numberList = numbers.split(" ");
		int [] arrayData = new int[numberList.length];
		for(int i = 0; i<numberList.length;i++) {
			arrayData[i] = Integer.parseInt(numberList[i]);
			sum +=arrayData[i];
		}
		return new int [] {sum , numberList.length};
		
		
	}
	
	public static int avarageNumber(String numbers) {
		
		int [] sum = sumOfNumber(numbers);
		int avarage = sum[0]/sum[1];
		System.out.println(sum[1] + " length");
		System.out.println(sum[0] + " sum");
		return avarage;
	}
}
