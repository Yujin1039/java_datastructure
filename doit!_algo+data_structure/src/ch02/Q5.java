package ch02;

import java.util.Arrays;
import java.util.Scanner;

public class Q5 {
	static void rcopy(int[] a, int[] b) {
		int num = a.length > b.length ? b.length:a.length;
		for(int i=0;i<num;i++) {
			a[i] = b[b.length-1-i];
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("배열 a의 요소 수:");
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i<a.length;i++) {
			System.out.print((i+1)+"번째 요소의 값:");
			a[i] = sc.nextInt();
		}
		
		System.out.print("배열 b의 요소 수:");
		int m = sc.nextInt();
		int[] b = new int[m];
		for(int i=0;i<b.length;i++) {
			System.out.print((i+1)+"번째 요소의 값:");
			b[i] = sc.nextInt();
		}
		
		rcopy(a,b);
		System.out.println("a = "+Arrays.toString(a));
		System.out.println("b = "+Arrays.toString(b));
		sc.close();
	}
}
