package com.basic.question.DSA;

public class RemoveDuplicate {
	
	public static void main(String[] args) {
		int arr [] = {0,1,2,2,2,3,4,5,6,6,7};
		int temp [] = new int[arr.length];
		int j=0;
		for(int i = 0; i<arr.length-1; i++) {
			if(arr[i] !=arr[i+1]) {
				temp[j] = arr[i];
				j++;
			}
		}
		for(int i = 0; i<j; i++)
		System.out.print(temp[i] +" ");
	}
}
