package ch06;

import java.util.Scanner;
import java.util.Stack;

public class Q11 {
    //--- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];  a[idx1] = a[idx2];  a[idx2] = t;
    }

    //--- 퀵 정렬(비재귀 버전)---//
    static void quickSort(int[] a, int left, int right) {
        Stack<Integer> lstack = new Stack<>();
        Stack<Integer> rstack = new Stack<>();

        int b = lstack.push(left);
        int c = rstack.push(right);
        
        //push한 값 출력
        System.out.println("각 스택에 값을 삽입합니다.");
        System.out.print("lstack push: "+b);
        System.out.print(", rstack push: "+c+"\n");

        while (lstack.isEmpty() != true) {
            int pl = left  = lstack.pop();        // 왼쪽 커서
            int pr = right = rstack.pop();        // 오른쪽 커서
            int x = a[(left + right) / 2];        // 피벗은 가운데 요소

            do {
                while (a[pl] < x) pl++;
                while (a[pr] > x) pr--;
                if (pl <= pr)
                    swap(a, pl++, pr--);
                //분할 과정 출력
                System.out.printf("a[%d] ~ a[%d]: ",left,right);
                for(int i=left;i<=right;i++) {
                	System.out.print(a[i]+" ");
                }
                System.out.println();
            } while (pl <= pr);

            if (left < pr) {
            	int d = lstack.push(left);           // 왼쪽 그룹 범위의
                int e = rstack.push(pr);             // 인덱스를 푸시
                //push한 값 출력
                System.out.println("lstack push: "+d);
                System.out.println("rstack push: "+e);
            }
            if (pl < right) {
                int d = lstack.push(pl);             // 오른쪽 그룹 범위의
                int e = rstack.push(right);          // 인덱스를 푸시
                //push한 값 출력
                System.out.println("lstack push: "+d);
                System.out.println("rstack push: "+e);
            }
            System.out.println();
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

        quickSort(x, 0, nx - 1);            // 배열 x를 퀵정렬

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "]=" + x[i]);
        stdIn.close();
    }
}
