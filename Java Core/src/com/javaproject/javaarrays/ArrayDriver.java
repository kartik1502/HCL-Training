package com.javaproject.javaarrays;

import java.util.Scanner;

public class ArrayDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int n = sc.nextInt();
		int[] a = new int[n];
		System.out.println("Enter the array elements: ");
		for(int i = 0;i < n;i++){
			a[i] = sc.nextInt();
		}
		System.out.println("Before Sorting: ");
		for(int i = 0;i < n;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
		for(int j=0;j<a.length-1;j++){
	        int flag=0;
	        for(int i=0;i<a.length-j-1;i++){
	            if(a[i]>a[i+1]){
	                flag=1;
	                int temp=a[i];
	                a[i]=a[i+1];
	                a[i+1]=temp;
	            }
	        }
	        if(flag==0)
	            break;
	    }
		System.out.println("After Sorting: ");
		for(int i = 0;i < n;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
		sc.close();
	}
}