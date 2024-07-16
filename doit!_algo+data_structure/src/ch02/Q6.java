package ch02;

import java.util.Scanner;

public class Q6 {
	//x=변환할 수, r=기수, d=변환된 수의 배열
	static int cardConv(int x, int r, char[] d) {
		String ord = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int i;
		for(i=0;x>0;i++) {
			d[i] = ord.charAt(x % r);
			x = x/r;
		}		
		//int z = Integer.parseInt(Arrays.toString(d));
		return i;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int no;//변환하는 정수
		int cd;//기수
		int dno;//변환 후의 자리수
		int retry;//재실행 여부
		char[] cno = new char[32];//변환된 수를 저장하는 배열

		System.out.println("10진수를 기수 변환합니다.");
		do {
			do {
				System.out.print("변환할 음이 아닌 정수:");
				no = sc.nextInt();
			}while(no < 0);

			do {
				System.out.print("어떤 진수로 변환할까요? (2~36) :");
				cd = sc.nextInt();
			}while(cd < 2 || cd >36);

			dno = cardConv(no,cd,cno);
			
			System.out.print(cd+"진수로는 ");
			for(int i=dno-1;i>=0;i--) {
				System.out.print(cno[i]);
			}
			System.out.println("입니다.");

			do {
				System.out.print("한 번 더 할까요?(1:예,0:아니오):");
				retry = sc.nextInt();
			}while(retry != 0 && retry != 1);
		}while(retry == 1);
		sc.close();
	}

}
