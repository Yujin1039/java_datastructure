package ch02;

import java.util.Arrays;
import java.util.Scanner;

public class Q2 {
	static void swap(int[] x,int y,int z) {
		int t= x[y];
		x[y] = x[z];
		x[z] = t;
	}
	
	static void reverse(int[] x) {		
		for(int i=0;i<x.length/2;i++) {// 나누기2를 해야함을 망각
			String y = Arrays.toString(x);
			System.out.println(y);
			System.out.println("a["+i+"]과 "+"a["+(x.length-1-i)+"]를 교환합니다.");//Q.배열명 가져오기
			swap(x,i,x.length-1-i);
		}
		System.out.println(Arrays.toString(x));
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("요소 수:");
		int n = sc.nextInt();
		
		int[] a = new int[n];
		
		for(int i=0;i<n;i++) {
			System.out.print((1+i)+"번째 요소의 값:");
			a[i] = sc.nextInt();
		}
		
		reverse(a);
		System.out.println("역순 정렬을 마쳤습니다.");
		sc.close();
	}

}
