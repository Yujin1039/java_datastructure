package ch06;

import java.util.Scanner;

public class Q01 {
	static void swap(int a,int b,int[] arr) {
		int t = arr[a];
		arr[a] = arr[b];
		arr[b] = t;
	}
	
	//내가 작성한 코드는 "버블 정렬"이 아닌 "선택 정렬" -> 재작성 
	static void bubbleSort(int n,int[] arr) {
		for(int i=1;i<n;i++) {
			for(int j=i;j<n;j++) {
				if(arr[j-1] > arr[j]) {
					swap(j-1,j,arr);
				}
			}
		}
		/*
		for(int i=1;i<n;i++) {
			for(int j=i;j<n;j++) {
				if(arr[i-1] > arr[j]) {
					swap(i-1,j,arr);
				}
			}
		}*/
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("버블 정렬(버전2)");
		System.out.print("요솟수 : ");
		int n = sc.nextInt();
		int[] x = new int[n];
		
		for(int i=0;i<x.length;i++) {
			System.out.printf("x[%d] : ",i);
			x[i] = sc.nextInt();
		}
		
		bubbleSort(n,x);//버블 정렬
		
		System.out.println("오름차순으로 정렬했습니다.");
		for(int i=0;i<x.length;i++) {
			System.out.printf("x[%d] : %d\n",i,x[i]);
		}
		
		sc.close();
	}
}
