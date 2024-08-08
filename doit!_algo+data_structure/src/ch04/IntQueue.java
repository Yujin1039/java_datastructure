package ch04;

public class IntQueue {
	private int[] que;
	private int capacity;
	private int num;
	private int front;
	private int rear;
	
	//큐가 비었을 때 예외처리
	public class EmptyQueueException extends RuntimeException{
		//생성자 -> RuntimeException 생성자의 기능을 따름
		public EmptyQueueException() {};
	}
	
	//큐가 다 찼을 때 예외처리
	public class OverflowQueueException extends RuntimeException{
		public OverflowQueueException() {};
	}
	
	//생성자
	/* OutOfMemoryError 처리 */
	public IntQueue(int maxlen) {
		num = front = rear = 0;
		capacity = maxlen;
		try {
			que = new int[capacity];
		}catch(OutOfMemoryError e) {
			capacity = 0;
		}
	}
	
	//큐에 데이터 삽입(인큐)
	public int enque(int a) throws OverflowQueueException{
		if(num >= capacity) throw new OverflowQueueException();
		que[rear++] = a;
		num++;
		if(rear == capacity) {
			rear = 0;
		}
		return a;
	}
	
	//큐에서 데이터 제거(디큐)
	public int deque() throws EmptyQueueException{
		if(num <= 0) throw new EmptyQueueException();
		int b = que[front++];
		num--;
		if(front == capacity) {
			front = 0;
		}
		return b;
	}
	
	//큐에서 데이터 피크
	/* peek시, 가장 앞의 데이터부터 확인 (뒤 X) */
	public int peek() throws EmptyQueueException{
		if(num <= 0) throw new EmptyQueueException();
		return que[front];
	}
	
	//큐 인덱스 검색
	public int indexOf(int c) throws EmptyQueueException{
		if(num <= 0) throw new EmptyQueueException();
		for(int i=0;i<num;i++) {
			int idx = (front+i)%capacity;
			if(que[idx] == c) {
				return idx;
			}
		}
		return -1;
	}
	
	//큐 요소 위치 검색
	public int search(int x) throws EmptyQueueException{
		if(num <= 0) throw new EmptyQueueException();
		for(int i=0;i<num;i++) {
			int idx = (front+i)%capacity;
			if(que[idx] == x) {
				return i+1;
			}
		}
		return 0;
	}
	
	//큐 비우기
	public void clear() {
		num = front = rear = 0;
	}
	
	//큐 용량 반환
	public int capacity() {
		return capacity;
	}
	
	//큐의 데이터 수 반환
	public int size() {
		return num;
	}
	
	//큐 비었는지 여부 확인
	public boolean isEmpty() {
		return num <= 0;
	}
	
	//큐가 가득 찼는지 확인
	public boolean isFull() {
		return num >= capacity;
	}
	
	//큐의 데이터 출력 (front → rear)
	public void dump() {
		if(num <= 0) {
			System.out.println("큐가 비었습니다.");
		}else {
			for(int i=0;i<num;i++) {
				/* 나누는 수 : 현재 데이터 수가 아닌, 배열의 길이 */
				int d = (front + i) % capacity;
				System.out.println(que[d]+" ");				
			}
			System.out.println();
		}
	}
}
