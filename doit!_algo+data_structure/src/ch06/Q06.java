package ch06;

import java.util.Scanner;

public class Q06 {
	//--- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1]; 
        a[idx1] = a[idx2]; 
        a[idx2] = t;
    }

    //--- 단순 선택 정렬 print ---//
    static void selectionSort(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            int min = i;                // 아직 정렬되지 않은 부분에서 가장 작은 요소의 인덱스를 저장
            for (int j = i + 1; j < n; j++)
                if (a[j] < a[min])
                    min = j;
            for(int j=0;j<n;j++) {
            	if(j == min) System.out.print(" + ");
            	else if(j == i) System.out.print(" * ");
            	else System.out.print("   ");
            }
            System.out.println();            
            for(int j=0;j<n;j++) {
            	System.out.printf(" %d ",a[j]);
            }
            swap(a, i, min);           // 아직 정렬되지 않은 부분의 첫 요소와 가장 작은 요소를 교환
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("단순 선택 정렬");
        System.out.print("요솟수: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        selectionSort(x, nx);            // 배열 x를 단순선택정렬

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "]=" + x[i]);
        
        stdIn.close();
    }	
}
