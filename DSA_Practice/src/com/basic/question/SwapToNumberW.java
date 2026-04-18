package com.basic.question;

import java.util.Scanner;

public class SwapToNumberW {
	
	 	int a;
	 	int b;
		SwapToNumberW(int a,int b){
	 		this.a=a;
	 		this.b=b;
	 	}
		public static void main(String [] args)
		{
//			swap to number without third variable
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter value of a");
			System.out.println("Enter value of b");
			int a = sc.nextInt();
			int b = sc.nextInt();
//			SwapToNumberW result = swapToNumberWithoutThirdVariable(a,b);
//			System.out.println("A: "+result.a);
//			System.out.println("B: "+ result.b);
			swapToNumberUsingTemp(a,b);
		}
		static SwapToNumberW swapToNumberWithoutThirdVariable(int a ,int b) {
			a = a+b;
			b=a-b;
			a = a-b;
			
			return new SwapToNumberW(a , b);
		}
		static void swapToNumberUsingTemp(int a,int b) {
			int temp = 0;
			temp = a;
			a = b;
			b = temp;
			System.out.println("A:"+a);
			System.out.println("B:"+b);
		}
}
