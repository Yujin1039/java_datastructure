package ch01;

import java.util.Scanner;

public class Q17 {
	static void npira(int n) {
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n-i;j++) {
				System.out.print(" ");
			}
			for(int j=1;j<=2*i-1;j++) {
				System.out.print(i%10);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		
		do {
			System.out.print("단 수:");
			n = sc.nextInt();
		}while(n < 0);
		
		npira(n);
		sc.close();
	}
}
