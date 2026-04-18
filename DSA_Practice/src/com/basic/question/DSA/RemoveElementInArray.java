package com.basic.question.DSA;

public class RemoveElementInArray {
	
	public static void main(String[] args) {
		int arr[] = {1,3,5,6,4,0,3,6,1,5};
		int target = 0;
		int a = arr.length;
		for(int i = 0; i<a; i++) {
			if(arr[i]==target) {
				for(int j = i; j<a-1;j++) {
					arr[j] = arr[j+1];
				}
				a--;
				break;
				
			}
		}
		System.out.print("{");
		for(int i = 0; i<a; i++) {
			System.out.print(arr[i]+",");
			
		}
		System.out.println("}");
	}
}
