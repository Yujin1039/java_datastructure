package ch03;

import java.util.Scanner;

public class Q1 {
	static int seqSearchSen(int[] a, int n, int key) {
		for(int i=0;i<a.length;i++) {
			if(a[i] == key) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("요솟수 : ");
		int num = sc.nextInt();
		int[] x = new int[num+1];
		
		for(int i=0;i<num;i++) {
			System.out.print("x["+i+"]: ");
			x[i] = sc.nextInt();
		}
		
		System.out.print("검색할 값 : ");
		x[num] = sc.nextInt();
		
		int idx = seqSearchSen(x,num+1,x[num]);
		
		if(idx == num) {
			System.out.println("검색 결과와 일치하는 요소가 없습니다.");
		}else {
			System.out.println(x[num]+"은 x["+idx+"]에 있습니다.");
		}
		sc.close();
	}
}
