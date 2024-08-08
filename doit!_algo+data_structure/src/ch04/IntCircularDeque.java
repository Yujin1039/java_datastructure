package ch04;

//원형 큐로 작성
public class IntCircularDeque {
	private int[] deque;
	private int max;
	private int num;
	private int front;
	private int rear;

	//생성자
	public IntCircularDeque(int a) {
		max = a;
		front = rear = num = 0;
		try {
			deque = new int[max];
		}catch(OutOfMemoryError e) {
			max = 0;
		}
	}
	
	/*
	 * 원형 큐에서는 index 자체에 오류가 발생하지않도록 처리하는 
	 */
	
	/*num값 수정 까먹음*/
	//뒤에서 데이터 삽입
	public int addLast(int b) {
		if(num >= max) throw new IllegalStateException("Deque is full");
		deque[rear++] = b;
		num++;
		if(rear >= max) rear = 0;
		return b;
	}

	//앞에서 데이터 제거
	public int removeFirst() {
		if(num <= 0) throw new IllegalStateException("Deque is empty");
		int c = deque[front++];	
		num--;
		if(front >= max) front = 0;
		return c;
	}
	
	//앞에서 데이터 삽입
	/* 1) front 프인터 이동 후 값 대입 
	 * 2) 1번을 고려해, front <= 0일 때 가장 마지막 index로 이동
	 */
	public int addFirst(int b) {
		if(num >= max) throw new IllegalStateException("Deque is full");
		//if(front <= 0) front = max;
		//deque[front-- -1] = b;
		front = (front-1+max) % max;
		deque[front] = b;	
		num++;
		return b;
	}
	
	//뒤에서 데이터 제거
	/* 1) rear 프인터 이동 후 값 대입 
	 * 2) 1번을 고려해, rear <= 0일 때 가장 마지막 rear로 이동
	 */
	public int removeLast() {
		if(num <= 0) throw new IllegalStateException("Deque is empty");
		//if(rear <= 0) rear = max;
		//int c = deque[rear-- -1];
		rear = (rear-1+max) % max;
		int c = deque[rear];
		num--;
		return c;
	}

	//가장 앞의 데이터 엿보기
	public int peekFirst() {
		if(num <= 0) throw new IllegalStateException("Deque is empty");
		return deque[front];
	}

	//가장 뒤의 데이터 엿보기
	public int peekLast() {
		if(num <= 0) throw new IllegalStateException("Deque is empty");
		return deque[rear];
	}

	//전체 데이터 수
	public int size() {
		return num;
	} 
}
