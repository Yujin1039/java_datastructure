package ch06;

import java.util.Scanner;

public class Q04 {
	static int compare = 0;
	static int swap = 0;
	
	static void swap(int a,int b,int[] arr) {
		int t = arr[a];
		arr[a] = arr[b];
		arr[b] = t;
	}
	
	//last값은 int i 레벨에서 적용!
	static void bubbleSort(int n,int[] arr) {
		int last = 0;
		for(int i=last;i<n;i++) {
			System.out.printf("패스%d:\n",(i+1));
			int exchange = 0; 
			for(int j=n-1;j>i;j--) {
				compare++;
				for(int k=0;k<n;k++) {
					System.out.printf(" %d ",arr[k]);
					if(k == j-1) {
						if(arr[k] > arr[k+1]) {
							System.out.print("+");
							swap++;							
							exchange++;
							last = k;							
						}else {
							System.out.print("-");
						}
					}else {
						System.out.print(" ");
					}									
				}
				System.out.println();
				if(arr[j-1] > arr[j]) {
					swap(j-1,j,arr);
				}
			}
			for(int k=0;k<n;k++) {
				System.out.printf(" %d ",arr[k]);
				System.out.print(" ");				
			}
			System.out.println();
			if(exchange == 0) break;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("버블 정렬(버전4)");
		System.out.print("요솟수 : ");
		int n = sc.nextInt();
		int[] x = new int[n];

		for(int i=0;i<x.length;i++) {
			System.out.printf("x[%d] : ",i);
			x[i] = sc.nextInt();
		}

		bubbleSort(n,x);//버블 정렬

		System.out.printf("비교를 %d회 했습니다.\n",compare);
		System.out.printf("교환을 %d회 했습니다.\n",swap);

		sc.close();
	}
}
