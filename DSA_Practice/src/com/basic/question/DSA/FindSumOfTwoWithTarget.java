package com.basic.question.DSA;

public class FindSumOfTwoWithTarget {
	public static void main(String [] args)
	{
		int[] arr = {1,3,5,7,10,15,25,60};
		int target = 20;
		int left = 0; // from zero
        int right = arr.length - 1; //last element
        
		while(left<right) {
			int current_sum = arr[left]+arr[right];
			if(current_sum==target) {
				System.out.print(left + " " + right);
				return;
			}else if(current_sum<target) {
				left++;
			}else {
				right--;
			}
		}
	}
}
