package ch04;

public class IntDeque {
	/*
	 * Deque
	 * 1) 정의: 큐의 양방향으로 데이터 삽입 및 삭제가 가능한 구조
	 * 2) 특징
	 *   -> (스택 + 큐) 둘의 특성을 모두 가짐
	 *   -> index에 따른 데이터 검색 불가
	 * 3) 구현 클래스
	 *   ⓐ ArrayDeque
	 *   ⓑ ConcurrentLinkedDeque
	 *   ⓒ LinkedBlockingDeque
	 *   ⓓ LinkedList
	 */

	private int max;
	private int num1;
	private int num2;
	private int[] deque;

	//생성자
	public IntDeque(int a) {
		max = a;
		num1 = num2 = 0;
		try {
			deque = new int[max];
		}catch(OutOfMemoryError e) {
			max = 0;
		}
	}

	//앞으로 데이터 삽입
	public int addFirst(int b) {
		if(num1 + num2 >= max) throw new IllegalStateException();
		deque[num1++] = b;
		return b;
	}

	//뒤로 데이터 삽입
	public int addLast(int b) {
		if(num1 + num2 >= max) throw new IllegalStateException();
		deque[max-1-num2++] = b;
		return b;
	}
	
	//앞에서 데이터 제거
	public int removeFirst() {
		if(num1 <= 0) throw new IllegalStateException();
		return deque[num1--];	
	}

	//뒤에서 데이터 제거
	public int removeLast() {
		if(num2 <= 0) throw new IllegalStateException();
		return deque[max-1-num2--];	
	}
	
	//가장 앞의 데이터 엿보기
	public int peekFirst() {
		if(num1 <= 0) throw new IllegalStateException();
		return deque[num1];
	}
	
	//가장 뒤의 데이터 엿보기
	public int peekLast() {
		if(num2 <= 0) throw new IllegalStateException();
		return deque[max-1-num2];
	}
	
	//전체 데이터 수
	public int size() {
		return num1+num2;
	}
}
