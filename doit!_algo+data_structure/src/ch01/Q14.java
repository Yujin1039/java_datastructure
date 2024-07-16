package ch01;

import java.util.Scanner;

public class Q14 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("사각형을 출력합니다.");
		int n;
		do {
			System.out.print("단 수:");
			n = sc.nextInt();
		}while(n < 0);
		
		
		for(int i=1;i<=n;i++) {
			System.out.println("*".repeat(n));
		}
		
		sc.close();
	}
}
