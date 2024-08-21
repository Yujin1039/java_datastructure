package ch06;

import java.util.Scanner;
import java.util.Stack;

public class Q14 {
	//--- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];  
		a[idx1] = a[idx2];  
		a[idx2] = t;
	}
	
	//단순 삽입정렬
	static void insertionSort(int[] a, int left, int right) {
		for(int i=left+1;i<=right;i++) {
			int tmp = a[i];
			int j;
			for(j=i-1;j>=left && a[j] > tmp;j--) {
				a[j+1] = a[j];
			}		
			a[j+1] = tmp;
		}
	}
	
	//중앙값의 인덱스 선택하기
	static int selectMid(int[] x,int a,int b,int c) {
		if(x[a] > x[b]) swap(x,a,b);
		if(x[b] > x[c]) swap(x,b,c);
		if(x[a] > x[b]) swap(x,a,b);
		return b;
	}
	
	//--- 퀵 정렬(재귀 버전) ---//
	static void quickSort(int[] a, int left, int right) {
		if(right - left >= 9) {
			insertionSort(a,left,right);
		}else {			
			int pl = left;                   // 왼쪽 커서
			int pr = right;                  // 오른쪽 커서
			int x = (pl + pr) / 2;        	 // 가운데 요소
			int mid = selectMid(a,left,right,x);
			
			do {
				while (a[pl] < a[mid]) pl++;
				while (a[pr] > a[mid]) pr--;
				if (pl <= pr)
					swap(a, pl++, pr--);
			} while (pl <= pr);
			
			if(pr - left >= right - pl) {
				int temp;
				temp = left; left = pl; pl = temp;
				temp = right; right = pr; pr = temp; 
			}
			
			if (left < pr)  quickSort(a, left, pr);
			if (pl < right) quickSort(a, pl, right);
		}
	}

	//--- 퀵 정렬(비재귀 버전)---//
	static void quickSort2(int[] a, int left, int right) {
		Stack<Integer> lstack = new Stack<>();
		Stack<Integer> rstack = new Stack<>();

		lstack.push(left);
		rstack.push(right);

		while (lstack.isEmpty() != true) {
			int pl = left  = lstack.pop();        // 왼쪽 커서
			int pr = right = rstack.pop();        // 오른쪽 커서
			int x = (left + right) / 2;        	// 가운데 요소
			int mid = selectMid(a, pl, pr, x);

			do {
				while (a[pl] < mid) pl++;
				while (a[pr] > mid) pr--;
				if (pl <= pr)
					swap(a, pl++, pr--);
			} while (pl <= pr);       

			if(pr - left >= right - pl) {
				int temp;
				temp = left; left = pl; pl = temp;
				temp = right; right = pr; pr = right; 
			}
			if (left < pr) {
				lstack.push(left);           // 왼쪽 그룹 범위의
				rstack.push(pr);             // 인덱스를 푸시
			}
			if (pl < right) {
				lstack.push(pl);             // 오른쪽 그룹 범위의
				rstack.push(right);          // 인덱스를 푸시
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("퀵 정렬");
		System.out.print("요솟수 : ");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];

		for (int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = stdIn.nextInt();
		}

		quickSort(x, 0, nx - 1);			// 배열 x를 퀵 정렬

		System.out.println("오름차순으로 정렬하였습니다.");
		for (int i = 0; i < nx; i++)
			System.out.println("x[" + i + "]＝" + x[i]);
	}	
}
