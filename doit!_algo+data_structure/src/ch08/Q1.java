package ch08;

import java.util.Scanner;

public class Q1 {
	static int bfMatch(String s1, String s2) {
		int pp = 0; //pat 커서
		int pt = 0; //txt 커서
		int i = 0;  //검색 회차
		int j = 0;  //검색 시작 여부 확인
		int k = 0;  //검색 횟수
		
		for(;pt < s1.length() && pp < s2.length();i++) {
			System.out.printf("%d ",i);
			while(pp < s2.length()) {
				k++;
				String space = " ".repeat(String.valueOf(i).length()+1);
				String space2 = space + " ".repeat(pt);
				String space3 = space + " ".repeat(i);
				if(j == 0) {
					System.out.println(s1);
					j++;
				}else {
					System.out.println(space+s1);
				}
				
				System.out.print(space2);
				System.out.println(s1.charAt(pt) == s2.charAt(pp) ? "+":"|");
				System.out.println(space3+s2);
				System.out.println();
				
				if(s1.charAt(pt) == s2.charAt(pp)) {
					pt++;
					pp++;
				}else {
					pt = pt + 1 - pp;
					pp = 0;
					break;
				}					
			}
			j = 0;
		}		
		return k;
	}
	
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("텍스트: ");
        String s1 = stdIn.next();                     // 텍스트용 문자열

        System.out.print("패  턴: ");
        String s2 = stdIn.next();                     // 패턴용 문자열

        int num = bfMatch(s1, s2);    // 문자열 s1에서 문자열 s2를 브루트-포스법으로 검색

        if (num <= 0)
            System.out.println("텍스트 안에 패턴이 없습니다.");
        else {
            System.out.println("비교를 총 "+num+"회 하였습니다.");
        }
    }
}
