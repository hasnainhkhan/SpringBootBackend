package com.basic.question.DSA;

public class ShiftNonZeroAtEnd {
	
	public static void main(String [] args)
	{
		int arr [] = {1,0,5,6,7,9,0,3,0};
		int left = 0;
		int right = arr.length-1;
		int temp = 0;
		while(left<right) {
			if(arr[left] != 0 && arr[right] !=0) {

				left++;
				right --;
			}else if(arr[left] == 0 && arr[right] !=0) {
				temp = arr[left];
				arr[left]=arr[right];
				arr[right]=temp;
				left++;
				right --;
			}else if(arr[left] ==0 && arr[right] ==0) {
				right--;
				
			}
			else { 
				left++;
			}
			
		}
		for(int i : arr) {
			System.out.print(i + " ");
		}
	}
}
