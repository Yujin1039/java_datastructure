package ch06;

import java.util.Scanner;
import java.util.Arrays;

public class Q07 {
	/*
	 * < 보초법을 활용한 단순 삽입 정렬 >
	 * - 기능 : 배열의 맨 앞칸 → min 값 저장
	 * - 장점 : for문의 조건식에서 조건 2개 → 조건 1개 로 축소 가능
	 *        ▶ 배열(인덱스 0)에 min 값이 저장되어있으므로 
	 */
	
	//--- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1]; 
        a[idx1] = a[idx2]; 
        a[idx2] = t;
    }

    //--- 단순 삽입 정렬 (보초법) ---//
    static void insertionSort(int[] a, int n) {
    	for (int i = 2; i < n; i++) {            
            int tmp = a[0] = a[i];
            int j = i;
            for ( ; a[j - 1] > tmp; j--) {
                a[j] = a[j-1];
            }
            a[j] = a[0];
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("단순 선택 정렬");
        System.out.print("요솟수: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx+1];

        for (int i = 1; i <= nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        insertionSort(x, nx+1);            // 배열 x를 단순삽입정렬

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 1; i < nx+1; i++)
            System.out.println("x[" + i + "]=" + x[i]);
        
        stdIn.close();
    }		
}
