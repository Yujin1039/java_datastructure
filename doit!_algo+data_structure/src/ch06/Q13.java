package ch06;

import java.util.Stack;

public class Q13 {
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
			//for문에서 마지막으로 저장되는 j값은 처음으로 a[j] > tmp(또는 j>=left)를 만족하지 않는 경우이므로 
			//tmp가 대입되어야할 위치는	[j+1]		
			a[j+1] = tmp;
		}
		/* 단순 선택정렬 코드 
		 * -> 선택 정렬과 삽입 정렬을 혼동함
		for(int i=right-left;i>0;i--) {
			int sd = a[right];
			for(int j=right;j>=left;j--) {
				if(a[j] > sd) {
					swap(a,j,right);
				}
			}			
		}	
		*/
	}
	
	//--- 퀵 정렬 ---//
	static void quickSort(int[] a, int left, int right) {
		if(right - left >= 9) {//뒤에서는 left,right 값이 바뀌므로 앞에서 작성하는 게 맞음 
			insertionSort(a,left,right);
		}else {			
			int pl = left;                   // 왼쪽 커서
			int pr = right;                  // 오른쪽 커서
			int x = a[(pl + pr) / 2];        // 피벗(가운데 요소)
			
			do {
				while (a[pl] < x) pl++;
				while (a[pr] > x) pr--;
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
			int x = a[(left + right) / 2];        // 피벗은 가운데 요소

			do {
				while (a[pl] < x) pl++;
				while (a[pr] > x) pr--;
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
}
