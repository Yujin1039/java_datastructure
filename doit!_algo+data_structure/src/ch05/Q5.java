package ch05;

import java.util.Stack;

public class Q5 {
	//연속 2번 재귀 호출(꼬리 재귀X) 어렵다...
    static void recur3(int n) {
        Stack<Integer> stack = new Stack<>();
        Stack<Boolean> processed = new Stack<>();

        stack.push(n);
        processed.push(false);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            boolean isProcessed = processed.pop();

            if (current > 0) {
                if (isProcessed) {
                    // 재귀 호출이 모두 끝난 후 현재 값을 출력
                    System.out.println(current);
                } else {
                    // 현재 상태를 재입력하여 나중에 출력하도록 설정
                    stack.push(current);
                    processed.push(true);

                    // 재귀 호출 순서를 고려하여 역순으로 스택에 푸시
                    stack.push(current - 2);
                    processed.push(false);

                    stack.push(current - 1);
                    processed.push(false);
                }
            }
        }
    }
    
    /*
	static void recur3(int n) {
		
		if(n > 0) {
			recur3(n-1);
			recur3(n-2);
			System.out.println(n);
		}
		
		Stack<Integer> stack = new Stack<>();
		
		stack.push(n);
		
		while(!stack.isEmpty()) {
			int m = stack.peek();
			
			if(m > 1) {
				stack.push(m-1);
				stack.push(m-2);
				m -= 2;
				continue;
			}else if(m == 0){
				stack.pop();
			}
			
			System.out.println(stack.pop());
			System.out.println(stack.pop());
			
			int l = stack.peek();
			
			if(l > 
			stack.push(l-2);
			
			if(!stack.isEmpty()) {
				//int l = stack.pop();
				System.out.println(l);
				
			}
		}
				
	}
	*/
    
	public static void main(String[] args) {
		recur3(4);
	}
}
