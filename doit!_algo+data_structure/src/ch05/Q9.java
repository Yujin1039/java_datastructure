package ch05;

import java.util.Stack;

public class Q9 {
	static boolean[] flag_a = new boolean[8];     // 각 행에 퀸이 이미 배치되었는가?
	static boolean[] flag_b = new boolean[15];    // 대각선 ↙에 퀸이 이미 배치되었는가?
	static boolean[] flag_c = new boolean[15];    // 대각선 ↘에 퀸이 이미 배치되었는가?
	static int[] pos = new int[8];    // 각 열의 퀸의 위치

	//--- 각 열의 퀸의 위치를 출력 ---//
	static void print() {
		for (int i = 0; i < 8; i++) {
	    	 for(int j = 0;j < 8; j++) {
	    		 System.out.print(pos[i] == j ? "■ " : "□ ");
	    	 }
	    	 System.out.println();
	     }
	     System.out.println();
	}

	//--- i열의 알맞은 위치에 퀸을 배치 ---//
	/*
	 * < 재귀 흐름도 >
	 * 1. 배열 a,b,c 의 값이 모두 false 인지 확인
	 * 2. - O : 배열 pos에 j값 삽입
	 *    - X : j++ -> 1번 과정 반복
	 * 3. - i != 7 : 해당 인덱스의 배열 a,b,c 모두 true로 변경 -> (i+1)인자로 메서드 재 호출
	 *    - i == 7 : 배열 pos 출력 ->  메서드 종료 -> 해당 인덱스의 배열 a,b,c 모두 false로 변경   
	 * 
	 * < 비재귀 흐름도 >
	 * ...
	 * 3. 
	 * - i != 7 : (i+1)인자로 메서드 재 호출 => j값 stack 저장 후 j++, 
	 *                                   continue로 메서드 호출 위치로 돌아가게 지정
	 * - i == 7 : 메서드 종료 => i--, stack에서 j값 pop
	 * 
	 * <내 코드의 문제점>
	 * 퀸을 배치한 후 다음 열로 이동하고, 백트래킹할 때 이전 상태로 돌아가지 않는 알고리즘으로 짬
	 * 초안1) for문을 사용하여 j 증가시, j값이 중복되어 내가 원하는 값 사용 불가
	 * 초안2) flag_a[j], flag_b[i + j], flag_c[i - j + 7]가 모두 false가 아니면 if문 조건 불충족해서 flag를 false로 바꾸는 코드 접근 불가
	 * 초안3) while(j < 8)절에서 조건을 충족하는 j일 때와 아닐 때 j 처리가 달라야 함
	 *      조건 충족시, j=0 (i+1의 상태에서 j=0~7 확인) - 57줄
	 *      조건 충족X, j+1 - 62줄
	 * 초안4) flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = false;를 i,j 처리 후에 작성하는 이유
	 *      : i = 7일 때의 j값은 스택에 없으므로 이전 상태로 되돌린 후 flag 배열 false로 원상 복귀
	 */
	static void set(int i) {
		int j = 0;
		Stack<Integer> jstk = new Stack<>();

		while(true) {
			while (j < 8) {
				if (!flag_a[j] && !flag_b[i + j] && !flag_c[i - j + 7]) {       
					pos[i] = j;                              // 퀸을 j행에 배치함
					if (i == 7)                              // 모든 열에 배치함
						print();
					else {
						flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = true;
						jstk.push(j);
						j = 0;
						i++;
						continue;
					}
				}	
				j++;
			}
			if(jstk.isEmpty()) break;
			
			i--;				
			j = jstk.pop();	
			flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = false;
			j++;
		}
	}

	public static void main(String[] args) {
		set(0);
	}
}
