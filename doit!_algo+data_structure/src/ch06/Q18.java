package ch06;

import java.util.Arrays;
import java.util.Scanner;

public class Q18 {
	static void countingSort(int[] a, int n, int max) {
		int[] f = new int[max+1];/* 목적 : 배열 a의 값 = 배열 f의 인덱스 */
		int[] b = new int[n];
		
		//1단계 - 도수분포표 만들기
		System.out.println("[1단계]");
		for(int i=0;i<n;i++) {
			f[a[i]]++;
			System.out.println("배열 f: "+Arrays.toString(f));
		}
		//2단계 - 누적도수분포표 만들기
		System.out.println("[2단계]");
		for(int i=1;i<f.length;i++) {
			f[i] += f[i-1]; 
			System.out.println("배열 f: "+Arrays.toString(f));
		}
		//3단계 - 목적 배열 만들기
		System.out.println("[3단계]");
		for(int i=n-1;i>=0;i--) {
			b[--f[a[i]]] = a[i];
			System.out.println("배열 f: "+Arrays.toString(f));
			System.out.println("배열 b: "+Arrays.toString(b));
		}
		//4단계 - 배열 복사하기
		System.out.println("[4단계]");
		for(int i=0;i<n;i++) a[i] = b[i];
	}

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("도수 정렬");
        System.out.print("요솟수: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            do {
                System.out.print("x[" + i + "]: ");
                x[i] = stdIn.nextInt();
            } while (x[i] < 0);
        }

        int max = x[0];
        for (int i = 1; i < nx; i++)
            if (x[i] > max) max = x[i];

        countingSort(x, nx, max);        // 배열 x를 도수정렬

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "]=" + x[i]);
    }
}
