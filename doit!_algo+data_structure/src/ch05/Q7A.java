package ch05;

import java.util.Stack;

//재귀 -> 비재귀 변환시, 상태값을 나타내는 인자 필수!!
public class Q7A {
	static void move(int no,int from,int to) {
		Stack<int[]> stack = new Stack<>();
		int sw = 0;

		while(true) {
			if(sw == 0 && no > 1) {
				stack.push(new int[] {sw,from,to});
				no -= 1;
				to = 6 - from - to;
				continue;
			}
			
			System.out.printf("원반 %d를(을) %d번 기둥에서 %d번 기둥으로 옮김\n",no,from,to);
			
			if(sw == 1 && no > 1) {
				stack.push(new int[] {sw,from,to});
				no -= 1;
				from = 6 - from - to;
				if (++sw == 2) sw = 0;
				continue;
			}
			
			do {
				if(stack.isEmpty()) return;
				int[] arr1 = stack.pop();
				sw = arr1[0] + 1;
				from = arr1[1];
				to = arr1[2];
				no++;
			}while(sw == 2);
		}
	}
	
	public static void main(String[] args) {
		move(3,1,3);
	}
}
