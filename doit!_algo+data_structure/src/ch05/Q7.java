package ch05;

import java.util.Stack;

public class Q7 {
	static void move(int no,int from,int to) {
		Stack<int[]> stack = new Stack<>();

		while(true) {
			if(no > 0) {
				int[] arr1 = new int[] {no,from,to};
				stack.push(arr1);
				no -= 1;
				to = 6 - from - to;
				continue;
			}
			
			int[] arr2 = stack.pop();
			System.out.printf("원반 %d를(을) %d번 기둥에서 %d번 기둥으로 옮김\n",arr2[0],arr2[1],arr2[2]);
			int[] arr3 = stack.pop();
			System.out.printf("원반 %d를(을) %d번 기둥에서 %d번 기둥으로 옮김\n",arr3[0],arr3[1],arr3[2]);
			System.out.printf("원반 %d를(을) %d번 기둥에서 %d번 기둥으로 옮김\n",arr2[0],arr2[2],arr3[2]);
			
			if(!stack.isEmpty()) {
				int[] arr4 = stack.pop();
				System.out.printf("원반 %d를(을) %d번 기둥에서 %d번 기둥으로 옮김\n",arr4[0],arr4[1],arr4[2]);
				no = arr3[0];
				from = arr3[2];
				to = arr4[2];
			}else {
				break;
			}
		}		
	}

	public static void main(String[] args) {
		move(5,1,3);
	}
}
