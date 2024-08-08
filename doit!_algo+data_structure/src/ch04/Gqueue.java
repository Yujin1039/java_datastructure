package ch04;

public class Gqueue<E> {
	private int max; //큐 용량
	private int num; //현재 데이터 수
	private int front;
	private int rear;
	private E[] que;
	
	//생성자
	public Gqueue(int capacity){// 생성자에서 제네릭 타입을 붙이지 않음
		num = front = rear = 0;
		try {
			max = capacity;
			/*제너릭 타입 배열 생성 불가 -> 형 변환*/
			que = (E[]) new Object[max];
		}catch(OutOfMemoryError e) {
			max = 0;
		}
	}
	
	//enque
	public E enque(E a) {
		if(num >= max) throw new IllegalStateException();
		que[rear++] = a;
		num++;
		if(rear == max) rear = 0;
		return a;
	}
	
	//deque
	public E deque() {
		if(num <= 0) throw new IllegalStateException();
		num--;
		E b = que[front++];
		if(front == max) front = 0;
		return b;
	}
	
	//peek
	public E peek() {
		if(num <= 0) throw new IllegalStateException();
		return que[front];
	}
	
	//clear
	public void clear() {
		num = front = rear = 0;
	}
	
	public int indexOf(E c) {
		if(num <= 0) throw new IllegalStateException();
		for(int i=0;i<num;i++) {
			int idx = (front + i) % max;
			if(que[idx].equals(c)) return idx;
		}
		return -1;
	}
	
	public int getCapacity() {
		return max;
	}
	
	public int size() {
		return num;
	}
	
	public boolean isEmpty() {
		return num <= 0;
	}
	
	public boolean isFull() {
		return num >= max;
	}
	
	public void dump() {
		if(num <= 0) {
			System.out.println("큐가 비었습니다.");
		}else {
			for(int i=0;i<num;i++) {
				System.out.println(que[(front+i)%max]+" ");
			}
			System.out.println();
		}
		
	}
}
