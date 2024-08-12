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
	
	/* <구현시 고민한 점>
	 * queue 방식 데이터 삽입,제거는 되는데 stack 불가
	 * -> front,rear 포인터가 각각 addFirst,addLast 메서드와 removeFirst,removeLast 메서드에서 
	 *    포인터 이동 없이 동일한 위치에 데이터 변동이 있었기 때문
	 * -> index가 0일 때 계산식에서 ArrayIndexOutOfBoundsException 고려한 처리가 없었음 
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
		//deque[--front] = b; <- (= front-- -1)
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
		//int c = deque[--rear]; <- (= rear-- -1)
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
	/* rear = 마지막 데이터 index + 1 값이므로
	 * deque[rear]는 비어있는 값
	 * 띠라서 가장 마지막 데이터는 deque[rear -1]
	 */
	public int peekLast() {
		if(num <= 0) throw new IllegalStateException("Deque is empty");
		return deque[rear == 0 ? max-1:rear-1];
	}
	
	//--- 기타 ---//
	//배열상 실제 index 탐색
	public int indexOf(int c) {
		if(num <= 0) throw new IllegalStateException("Deque is empty");
		for(int i=0;i<num;i++) {
			int d = (front+i)%max;
			if(deque[d] == c) return d;
		}
		return -1;
	}
	
	//deque 내 순서 검색
	public int search(int x) {
		for (int i = 0; i < num; i++)
			if (deque[(i + front) % max]  == x)	// 검색 성공
				return i + 1;
		return 0;																	// 검색 실패
	}	
	
	//전체 데이터 수
	public int size() {
		return num;
	} 
}
