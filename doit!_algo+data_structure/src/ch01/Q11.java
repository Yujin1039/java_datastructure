package ch01;

import java.util.Scanner;

public class Q11 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("양의 정수를 입력하면 자릿수를 연산해줍니다.");
		
		int n;
		do {
			System.out.print("숫자를 입력하세요:");
			n = sc.nextInt();
		}while(n <= 0);
		
		String m = n + "";
		System.out.println("그 수는 "+m.length()+"자리입니다.");
		sc.close();
	}
}
