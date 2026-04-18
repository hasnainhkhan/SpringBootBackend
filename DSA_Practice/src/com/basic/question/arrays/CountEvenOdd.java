/**
 * 
 */
package com.basic.question.arrays;

public class CountEvenOdd {

	public static void main(String[] args) {
		int arr [] = {23,65,78,92};
		int [] evenOdd = countEvenOdd(arr);
		System.out.println(evenOdd[0]+" "+evenOdd[1]);
	}
	static int [] countEvenOdd(int [] numbers){
		int even=0, odd = 0;
		if(numbers.length != 0) {
			int a=0;
			while(a<numbers.length) {
				if(numbers[a]%2==0) {
					even++;
				}
				else {
					odd++;
				}
				a++;
			}
		}
		return new int[] {even , odd};
	}
	

}
