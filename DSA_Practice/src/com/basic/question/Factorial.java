package com.basic.question;
import java.util.Scanner;
public class Factorial {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int res=1 , i;
		System.out.println("Enter the number");
		int num = sc.nextInt();
		for(i = 2; i<=num; i++) {
			res *=i;
			
		}
		System.out.println(res);
	}
}
