package com.basic.question.practice;

public class SwapTwoNumber {
	public static void main(String [] args)
	{
		int temp=0,num_a=10,num_b=20;
//		temp=num_a;
//		num_a=num_b;
//		num_b=temp;
		num_a=num_a+num_b;
		num_b=num_a-num_b;
		num_a = num_a-num_b;
		
		System.out.println("Num_A:"+num_a + "\nNum_B:"+num_b);
		
	}
}	
