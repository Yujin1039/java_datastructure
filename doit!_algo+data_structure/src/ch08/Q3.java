package ch08;

import java.util.Scanner;

public class Q3 {
	static int cmp = 0;
	
	static int kmpMatch(String txt,String pat) {
		int pt = 1; //skip 배열용 커서, txt 커서
		int pp = 0; //pat 커서
		int[] skip = new int[pat.length()+1]; // 접두사~접미사간 최대 일치 길이 저장 배열
		
		while(pt != pat.length()) {
			if(pat.charAt(pt) == pat.charAt(pp)) {
				skip[++pt] = ++pp;
			}else if(pp == 0) {
				skip[++pt] = 0;
			}else {
				pp = skip[pp]; 
			}
		}
		
		pt = pp = 0;
		boolean j = true;
		int k = 0;
		while(pt != txt.length() && pp != pat.length()) {
			if(j) {
				System.out.printf("%d ",k);
			}else {
				System.out.printf(String.format("%%%ds ",String.valueOf(cmp).length())," ");
			}
			System.out.println(txt);
			
			System.out.printf(String.format("%%%ds ",String.valueOf(cmp).length()+pt)," ");
			if(txt.charAt(pt) == pat.charAt(pp)) {
				System.out.println("+");
				System.out.printf(String.format("%%%ds ",String.valueOf(cmp).length()+pt-pp)," ");
				pt++;
				pp++;
				j = false;
			}else {
				System.out.println("|");
				System.out.printf(String.format("%%%ds ",String.valueOf(cmp).length()+pt-pp)," ");
				if(pp == 0) {
					pt++;			
				}else {
					//pt++; 
					pp = skip[pp]; 
				}
				j = true;
				k++;
			}
			cmp++;
			System.out.println(pat);
			System.out.println();
		}
		return pp == pat.length() ? pt - pp: -1;
	}
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("텍스트: ");
        String s1 = stdIn.next();                     // 텍스트용 문자열

        System.out.print("패  턴: ");
        String s2 = stdIn.next();                    // 패턴용 문자열

        int idx = kmpMatch(s1, s2);    // 문자열 s1에서 문자열 s2를 KMP법으로 검색
        
        System.out.println("비교를 총 "+cmp+"번 했습니다.");
        if (idx == -1)
            System.out.println("텍스트 안에 패턴이 없습니다.");
        else {
            // 일치하는 문자 바로 앞까지 반각(1바이트)문자의 개수를 구함
            int len = 0;
            for (int i = 0; i < idx; i++)
                len += s1.substring(i, i + 1).getBytes().length;
            len += s2.length();

            System.out.println((idx + 1) + "번째 문자부터 일치합니다.");
            System.out.println("텍스트: " + s1);
            System.out.printf(String.format("패  턴: %%%ds\n", len), s2);
        }
    }	
}
