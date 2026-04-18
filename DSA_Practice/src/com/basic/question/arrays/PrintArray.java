package com.basic.question.arrays;

import java.util.Scanner;

public class PrintArray {
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		String arr[] = sc.nextLine().split(" ");
		sc.close();
//		String [] ArrayList = arr.split(" ");
		int [] finalArray = new int [arr.length];
		
		for(int i = 0; i<finalArray.length;i++) {
			finalArray[i] = Integer.parseInt(arr[i]);
		}
		printArray(finalArray);
	}
	static void printArray(int [] finalArray) {
		
		System.out.print("[");
		for(int i = 0; i<=finalArray.length-1; i++) {
			System.out.print(finalArray[i]+",");
		}
		System.out.print("]");
	}
}
