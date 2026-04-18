package com.basic.question;

import java.util.Scanner;

public class SumOfArray {
	
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Insert data");
		String [] name = sc.nextLine().split(",");
			int i=0;
			for(String s:name) {
				System.out.print(name[i]);
				i++;
			}
		
	}
}
