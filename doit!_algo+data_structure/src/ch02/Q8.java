package ch02;

import java.util.Scanner;

public class Q8 {

	static int[][] mdays = {
			{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
			{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
	};

	// 서기 year년은 윤년인가?
	static int isLeap(int year) {
		return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
	}

	static int dayOfYear(int y, int m, int d) {
		while(m > 1) {
			d += mdays[isLeap(y)][m-2];
			m--;
		}
		return d;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int retry;

		System.out.println("그 해의 경과 일수를 구합니다.");

		do {
			System.out.print("년? ");
			int year = sc.nextInt();
			System.out.print("월? ");
			int month = sc.nextInt();
			System.out.print("일? ");
			int day = sc.nextInt();

			System.out.println(String.format("%s일이 경과되었습니다.", dayOfYear(year, month, day)));
			System.out.print("다시 하시겠습니까? (예: 1 | 아니오: 0)");
			retry = sc.nextInt();
		} while (retry == 1);
		
		System.out.println("프로그램이 종료되었습니다.");
		sc.close();
	}
}
