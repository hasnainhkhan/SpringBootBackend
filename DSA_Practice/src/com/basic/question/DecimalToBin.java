package com.basic.question;
import java.util.*;
public class DecimalToBin {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number to find bin");
		int n = sc.nextInt();
		decToBin(n);
		sc.close();
		
	} 
	static void decToBin(int n) {
		StringBuilder bin = new StringBuilder();
		while(n>0) {
			int bit = n%2;
			bin.append((char) ('0'+bit));
			n/=2;
		}
		String num = bin.reverse().toString();
		System.out.print(num);
	}
}
