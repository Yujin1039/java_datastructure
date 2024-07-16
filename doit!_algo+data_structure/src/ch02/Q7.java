package ch02;

import java.util.Scanner;

public class Q7 {
	static String cardConv(int x,int r) {
		String num = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String conv = "";
		char cv;
		System.out.println(String.format("%2d|%10d",r,x));
		while(x > 0) {
			cv = num.charAt(x%r);
			conv += cv;
			x /= r;
			System.out.println(String.format("%2s+----------", " "));
			if(x != 0) {
				System.out.println(String.format("%2d|%10d ··· %s",r,x,cv));
			}else {
				System.out.println(String.format("%3s%10d ··· %s"," ",x,cv));
			}						 
		}
		
		return conv;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("10진수를 기수 변환합니다.");
		
		int n;
		do {
			System.out.print("변환하는 음이 아닌 정수:");
			n = sc.nextInt();
		}while(n < 0);
		
		int m;
		do {
			System.out.print("어떤 진수로 변환할까요?(2~36):");
			m = sc.nextInt();
		}while(m < 2 || m > 36);
		
		String ar = cardConv(n,m);
		
		char[] arr = ar.toCharArray();
		char[] reArr = new char[arr.length];
		for(int i=0;i<arr.length;i++) {
			reArr[i] = arr[arr.length-1-i];
		}
		
		String reStr = new String(reArr);
		System.out.println(m+"진수로 "+reStr+"입니다.");
		sc.close();
	}

}
