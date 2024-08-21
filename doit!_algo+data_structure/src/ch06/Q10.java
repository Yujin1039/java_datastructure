package ch06;

import java.util.Arrays;
import java.util.Scanner;

public class Q10 {
	static void swap(int[] a,int idx1,int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	
	static void quickSort(int[] a,int left,int right) {
		int pl = left;
		int pr = right;
		int mid = (left + right)/2;
		
		do {
			while(a[pl] < a[mid]) pl++;
			while(a[pr] > a[mid]) pr--;
			if(pl <= pr) {//Q 조건문
				swap(a,pl++,pr--);
			}
		}while(pl <= pr);
		
		if(left < pr) quickSort(a,left,pr);
		if(pl < right) quickSort(a,pl,right);
	}
	
	static void quickSort(int[] a, int n) {
		if(n > 1) quickSort(a,0,n-1);			
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

        System.out.println("퀵 정렬");
        System.out.print("요솟수: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }

        quickSort(x,nx);            // 배열 x를 퀵정렬

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "]=" + x[i]);
        
        stdIn.close();
	}
}
