package ch06;

import java.util.Scanner;
import java.util.Stack;

public class Q12 {
    //--- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];  
        a[idx1] = a[idx2];  
        a[idx2] = t;
    }

    //--- 퀵 정렬 ---//
    static void quickSort(int[] a, int left, int right) {
        int pl = left;                   // 왼쪽 커서
        int pr = right;                  // 오른쪽 커서
        int x = a[(pl + pr) / 2];        // 피벗(가운데 요소)

        do {
            while (a[pl] < x) pl++;
            while (a[pr] > x) pr--;
            if (pl <= pr)
                swap(a, pl++, pr--);
        } while (pl <= pr);
        
        /* 기존 방법은 좌측 → 우측 진행
         * if (left < pr)  quickSort(a, left, pr);
         * if (pl < right) quickSort(a, pl, right);        
         */
        
        int elNum1 = pr - left;
        int elNum2 = right - pl;
        
        if(elNum1 >= elNum2) {
        	if (pl < right) quickSort(a, pl, right); 
        	if (left < pr)  quickSort(a, left, pr);
        }else {
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
            
            /*
             * 기존 방식
            if (left < pr) {
                lstack.push(left);           // 왼쪽 그룹 범위의
                rstack.push(pr);             // 인덱스를 푸시
            }
            if (pl < right) {
                lstack.push(pl);             // 오른쪽 그룹 범위의
                rstack.push(right);          // 인덱스를 푸시
            }
            */
            
            int elNum1 = pr - left;
            int elNum2 = right - pl;
            
            if(elNum1 >= elNum2) {
            	if (pl < right) {
                    lstack.push(pl);             // 오른쪽 그룹 범위의
                    rstack.push(right);          // 인덱스를 푸시
                }
            	if (left < pr) {
                    lstack.push(left);           // 왼쪽 그룹 범위의
                    rstack.push(pr);             // 인덱스를 푸시
                }
            }else {
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
        int[] y = x.clone();

        quickSort(x, 0, nx - 1);            // 배열 x를 퀵정렬
        quickSort2(y, 0, nx-1);				// 배열 y를 퀵정렬(x == y)

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "]=" + x[i]);
    }
}
