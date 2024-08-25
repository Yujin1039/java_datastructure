package ch06;

import java.util.Scanner;

public class Q19 {
	static void fSort(int[] a, int n, int min, int max) {
		int[] f = new int[max - min + 1];
		int[] b = new int[n];

		for(int i=0;i<n;i++) f[a[i] - min]++;
		for(int i=1;i<= max - min;i++) f[i] += f[i-1];
		for(int i=n-1;i>=0;i--) b[--f[a[i] - min]] = a[i];
		for(int i=0;i<n;i++) a[i] = b[i];
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("도수 정렬");
		System.out.print("요솟수: ");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];

		for (int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "]: ");
			/* 입력받은 값이 숫자가 아닌 경우의 처리 */
			if (stdIn.hasNextInt()) {//숫자 여부 확인
                x[i] = stdIn.nextInt();
            } else {
                System.out.println("유효하지 않은 입력입니다. 정수를 입력하세요.");
                stdIn.next(); // 잘못된 입력 소비
                i--; // i를 감소시켜 다시 입력을 받도록 함
            }
		}

		int max = x[0];
		int min = x[0];
		for (int i = 1; i < nx; i++) {
			if (x[i] > max) max = x[i];
			else if (x[i] < min) min = x[i];
		}

		fSort(x, nx, min, max);        // 배열 x를 도수정렬

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.println("x[" + i + "]=" + x[i]);
	}
}
