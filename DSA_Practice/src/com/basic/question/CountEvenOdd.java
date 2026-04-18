package com.basic.question;

public class CountEvenOdd {
	public static void main(String [] args)
	{
		int[] arr = {1,2,3,4,5,6,9};
		int even = 0,odd=0;
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i]%2==0)
			{
				even++;
			}
			else {
				odd++;
			}
		}
		int result[] = {even,odd};
		for(int i=0; i<result.length; i++) {
		System.out.println(result[i]);
		
		}
	}
	}
	


