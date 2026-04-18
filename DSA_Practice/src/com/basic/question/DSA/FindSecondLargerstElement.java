package com.basic.question.DSA;

import java.util.Scanner;

public class FindSecondLargerstElement {
	
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		String arStr[] = sc.nextLine().split(".");
		int [] arr = new int[arStr.length];
		for(int i=0; i<arStr.length;i++) {
			arr[i] =Integer.parseInt(arStr[i]); 
		}
		
		int max1 = secondLargestElement(arr);
		System.out.print(max1);
		
		
	}
	static int secondLargestElement(int [] arr) {
		int max1 , max2;
		if(arr[0] > arr[1]) {
			max2 = arr[1];
			max1 = arr[0];
		}else {
			max1 = arr[1];
			max2 = arr[0];
		}
		for(int i=2;i<arr.length;i++) {
			if(arr[i]>max1) {
				max2 = max1;
				max1 = arr[i];
			}else if(arr[i]>max2) {
				max2= arr[i];
			}
		}
		return max1;
	}
}
