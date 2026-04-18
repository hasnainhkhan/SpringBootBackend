package com.basic.question.DSA;
public class SortArrayDuchNationalFlag {
    public static void main(String[] args) {
        int arr[] = {2,1,0,1,0,1,0,2,1};
        int left = 0, mid = 0, right = arr.length - 1;

        while(mid <= right) {
            if(arr[mid] == 0) {
                int temp = arr[left];
                arr[left] = arr[mid];
                arr[mid] = temp;
                left++;
                mid++;
            } else if(arr[mid] == 2) {
                int temp = arr[mid];
                arr[mid] = arr[right];
                arr[right] = temp;
                right--;
            } else {
                mid++;
            }
        }

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}