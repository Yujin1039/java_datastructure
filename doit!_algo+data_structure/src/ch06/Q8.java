package ch06;

import java.util.Arrays;
import java.util.Scanner;

public class Q8 {
	//--- 단순 삽입 정렬 ---//
	static void insertionSort(int[] a, int n) {
		int[] b;
		for (int i = 1; i < n; i++) {
			int j;
			int tmp = a[i];
			b = Arrays.copyOf(a, i);
			int idx = Arrays.binarySearch(b, tmp);
			a[i] = 0;
			int ridx = (idx+1) * -1;
			for(int k = i;k >= ridx;k--) {
				if(k == ridx) {
					a[k] = tmp;
				}else {
					a[k] = a[k-1];					
				}
			}

		}
	}
	
	//이진 검색 메서드를 사용하지 않고 직접 이진 검색 구현하기
	static void binInsertionSort(int[] a, int n) {
		for (int i = 1; i < n; i++) {
			int key = a[i];
			int pl = 0;				// 검색 범위 맨앞의 인덱스
			int pr = i - 1;			// 　 〃 　맨끝의 인덱스
			int pc;					// 　 〃 　중앙의 인덱스
			int pd;					// 삽입하는 위치의 인덱스

			do {
				pc = (pl + pr) / 2;
				if (a[pc] == key)			// 검색 성공
					break;
				else if (a[pc] < key)
					pl = pc + 1;
				else
					pr = pc - 1;
			} while (pl <= pr);
			pd = (pl <= pr) ? pc + 1 : pr + 1;

			for (int j = i; j > pd; j--)
				a[j] = a[j - 1];
			a[pd] = key;
		}
	}	

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("단순 삽입 정렬");
		System.out.print("요솟수: ");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];

		for (int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = stdIn.nextInt();
		}

		insertionSort(x, nx);        // 배열 x를 단순삽입정렬

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.println("x[" + i + "]=" + x[i]);
	}
}
