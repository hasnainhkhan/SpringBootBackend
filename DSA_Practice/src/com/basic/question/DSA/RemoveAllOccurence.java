package com.basic.question.DSA;

public class RemoveAllOccurence {
		
	public static void main(String[] args) {
		
		int arr [] = {1,3,4,5,4,3,3,2,6,3,3,3,3,0,0,0,3,0,3,0,3,0,3,0};
		
		int removeElement = 0;
		int remainElement = 0;
		for(int i=0; i<arr.length;i++)
		{
			if(arr[i]!=removeElement) {
				arr[remainElement] = arr[i];
				remainElement ++;
			
		}
		}
		System.out.println("Remain Element: "+remainElement);
		for(int i = 0; i<remainElement; i++) {
			System.out.print(arr[i]);
		}
	}
}
