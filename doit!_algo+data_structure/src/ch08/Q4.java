package ch08;

import java.util.Scanner;

public class Q4 {
	static int cmp = 0; //비교 횟수
	static int bmMatch(String txt,String pat) {
		int pt = 0;
		int pp;
		int[] skip = new int[Character.MAX_VALUE+1];
		
		//건너뛰기 표
		for(int i=0;i<skip.length;i++) {
			skip[i] = pat.length();
		}
		for(;pt<pat.length();pt++) {
			skip[pat.charAt(pt)] = pat.length() - pt - 1;			
		}
		
		//검색
		while(pt < txt.length()) {
			pp = pat.length() -1;
						
			System.out.printf("%2d ",pt-pp);
			System.out.println(txt);
			while(txt.charAt(pt) == pat.charAt(pp)) {
				System.out.println(" ".repeat(3+pt)+"+");
				System.out.println(" ".repeat(3+pt-pp)+pat);
				System.out.println();
				if(pp == 0) return pt;
				pt--; pp--; cmp++;
				System.out.println(" ".repeat(3)+txt);
			}
			System.out.println(" ".repeat(3+pt)+"|");
			System.out.println(" ".repeat(3+pt-pp)+pat);
			pt += (skip[txt.charAt(pt)] > pat.length() - pp) ? skip[txt.charAt(pt)] : pat.length() - pp;
			cmp++;
		}
		return -1;
	}
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.printf("%3s: ","텍스트");
        String s1 = stdIn.next();                     // 텍스트용 문자열

        System.out.printf("%3s: ","패 턴");
        String s2 = stdIn.next();                     // 패턴용 문자열

        int idx = bmMatch(s1, s2);                    // 문자열 s1에서 문자열 s2를 BM법으로 검색
        
        System.out.println("비교를 총 "+cmp+"회 하였습니다.");
        if (idx == -1)
            System.out.println("텍스트 안에 패턴이 없습니다.");
        else {
            // 일치하는 문자 바로 앞까지 반각(1바이트) 문자의 개수를 구합니다
            int len = 0;
            for (int i = 0; i < idx; i++)
                len += s1.substring(i, i + 1).getBytes().length;
            len += s2.length();

            System.out.println((idx + 1) + "번째 문자부터 일치합니다.");
            System.out.println("텍스트: " + s1);
            System.out.printf(String.format("%3s: %%%ds\n", "패 턴",len), s2);
        }
    }
}
