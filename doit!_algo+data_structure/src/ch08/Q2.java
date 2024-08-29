package ch08;

import java.util.Scanner;

public class Q2 {
	static int bfMatchLast(String txt, String pat) {
		int pt = txt.length() - 1;
		int pp = pat.length() - 1;
		
		while(pt != -1 && pp != -1) {
			if(txt.charAt(pt) == pat.charAt(pp)) {
				pt--;
				pp--;
			}else {
				pt = pt + pat.length() -2 - pp;
				pp = pat.length() - 1;
			}
		}
		
		return pt < -1 ? -1 : pt+1;
	}
	
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("텍스트: ");
        String s1 = stdIn.next();                     // 텍스트용 문자열

        System.out.print("패 턴: ");
        String s2 = stdIn.next();                     // 패턴용 문자열

        int idx = bfMatchLast(s1, s2);    // 문자열 s1에서 문자열 s2를 브루트-포스법으로 검색

        if (idx == -1)
            System.out.println("텍스트 안에 패턴이 없습니다.");
        else {
            // 일치하는 문자 바로 앞까지의 문자 개수를 반각 문자로 환산하여 구함
            int len = 0;
            for (int i = 0; i < idx; i++)
                len += s1.substring(i, i + 1).getBytes().length;
            len += s2.length();

            System.out.println("마지막으로 나온 인덱스는 "+ idx + " 입니다.");
            System.out.println("텍스트: " + s1);
            System.out.printf(String.format("%s: %%%ds\n", "패 턴",len), s2);
        }
    }
}
