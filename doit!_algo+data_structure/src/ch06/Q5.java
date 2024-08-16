package ch06;

import java.util.Scanner;

public class Q5 {
    //--- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1]; 
        a[idx1] = a[idx2]; 
        a[idx2] = t;
    }

    //---양방향 버블 정렬 (= 칵테일 정렬, 세이커 정렬)---//
    /* 초안) k의 업데이트 방식, 반복문 내의 조건 때문에 올바르게 작동 X
     * -> 나의 의도는 k가 1씩 증가하여 정렬하는 것이지만,
     *    실제 k는 "k = last;"로 마지막 교환 위치 지표로 사용하고 있어 내가 원하는대로 사용 불가
     */
    static void bubbleSort(int[] a, int n) {
		int left = 0;
		int right = n - 1;
		int last = right;

		while (left < right){
			for (int j = right; j > left; j--){
				if (a[j - 1] > a[j]){
					swap(a, j - 1, j);
					last = j;
				}
			}
			left = last;

			for (int j = left; j < right; j++){
				if (a[j] > a[j + 1]){
					swap(a, j, j + 1);
					last = j;
				}
			}
			right = last;
		}
        /*
        int k = 0;                               // a[k]보다 앞쪽은 정렬을 마침
        while (k < n - 1) {
            int last = n - 1;                    // 마지막으로 교환한 위치
            if(k % 2 != 0) {
            	for (int j = n - 1; j > k; j--) {
                    if (a[j - 1] > a[j]) {
                        swap(a, j - 1, j);
                        last = j;
                    }
            	}
            }else {
            	for (int j = 0; j < n-1; j++) {
                    if (a[j] > a[j+1]) {
                        swap(a, j, j+1);
                        last = j;
                    }
            	}
            }
            k = last;
        }
        */
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("단순교환정렬(버블정렬)");
        System.out.print("요솟수 : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        bubbleSort(x, nx);                // 배열 x를 단순교환정렬

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "]=" + x[i]);
    }
}
