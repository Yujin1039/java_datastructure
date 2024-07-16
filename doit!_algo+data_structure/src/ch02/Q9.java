package ch02;

import java.util.Scanner;

public class Q9 {
	static int[][] mdays = {
			{31,28,31,30,31,30,31,31,30,31,30,31},
			{31,29,31,30,31,30,31,31,30,31,30,31}
	};
	
	static int isLeap(int y) {
		if(y % 4 == 0 && y % 100 != 0 || y % 400==0) {
			return 1;
		}
		return 0;
	}
	
	static int leftDayOfYear(int y, int m, int d) {
		int days = mdays[isLeap(y)][m-1] - d;
		while(m < 12) {
			days += mdays[isLeap(y)][m];
			m++;
		}
		return days;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int retry;

		System.out.println("그 해의 남은 일수를 구합니다.");

		do {
			System.out.print("년? ");
			int year = sc.nextInt();
			System.out.print("월? ");
			int month = sc.nextInt();
			System.out.print("일? ");
			int day = sc.nextInt();

			System.out.println(String.format("%d년이 %s일이 남았습니다.",year,leftDayOfYear(year, month, day)));
			System.out.print("다시 하시겠습니까? (예: 1 | 아니오: 0)");
			retry = sc.nextInt();
		} while (retry == 1);
		
		System.out.println("프로그램이 종료되었습니다.");
		sc.close();
	}

}
