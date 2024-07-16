package ch01;

import java.util.Scanner;

public class Q15 {
	static void triangleLB(int n) {
		for(int i=1;i<=n;i++) {
			System.out.println("*".repeat(i));
		}
	}
	
	static void triangleLU(int n) {
		for(int i=n;i>=1;i--) {
			System.out.println("*".repeat(i));
		}
	}
	
	static void triangleRU(int n) {
		for(int i=0;i<=n;i++) {
			System.out.print(" ".repeat(i));
			System.out.println("*".repeat(n-i));
		}
	}
	
	static void triangleRB(int n) {
		for(int i=1;i<=n;i++) {
			System.out.print(" ".repeat(n-i));
			System.out.println("*".repeat(i));			
		}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n;
		
		do {
			System.out.print("변의 길이를 입력하세요:");
			n = sc.nextInt();
		}while(n <= 0);
		
		triangleLB(n);		
		triangleLU(n);
		triangleRU(n);
		triangleRB(n);
		
		sc.close();
	}
}
