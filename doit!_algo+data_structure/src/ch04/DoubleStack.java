package ch04;

import java.util.EmptyStackException;

//에러 발생 조건!! (포인터)
public class DoubleStack {
	private int capacity;
	private int ptr1,ptr2;//배열이 1개이므로, ptr1 >= 0, ptr2 <= capacity-1 로 시작
	private int[] stk;

	/*
	 * Enum 사용 이유
	 * : 사용하지 않을 경우, 변수명을 따로 지정해야하는데 변수명 접근시 발생하는 오류↓ 
	 */

	//Enum
	public enum doubleHead{
		STK1,STK2;
	}

	//생성자
	public DoubleStack(int capacity) {
		this.capacity = capacity;
		ptr1 = 0;
		ptr2 = capacity - 1;
		try {
			stk = new int[capacity];
		}catch(OutOfMemoryError e) {//메모리가 부족할 때 발생하는 에러
			capacity = 0;
		}
	}

	//push
	/*enum 변수로 사용하기 - "enum.상수명" */
	public int push(doubleHead dh,int a) {
		//배열의 길이가 짝수인 경우, 조건이 "포인터2 + 1"을 경계값으로 지정해야함
		if(ptr1 >= ptr2 + 1) throw new StackOverflowError();		
		switch(dh) {
		case STK1:
			stk[ptr1++] = a; break;
		case STK2:
			stk[ptr2--] = a; break;
		}
		return a;
	}

	//pop
	public int pop(doubleHead dh) {
		int x = 0;	
		switch(dh) {
		case STK1:
			if(ptr1 <= 0) throw new EmptyStackException();	
			x = stk[ptr1--];
		case STK2:
			if(ptr2 >= capacity) throw new EmptyStackException();	
			x = stk[ptr2++];
		}
		return x;
	}

	//peek
	public int peek(doubleHead dh) {
		int y = 0;
		switch(dh) {
		case STK1:
			if(ptr1 <= 0) throw new EmptyStackException();	
			y = stk[ptr1]; break;
		case STK2:
			if(ptr2 >= capacity) throw new EmptyStackException();	
			y = stk[ptr2]; break;
		}
		return y;
	}

	//search
	/* STK2 조건 잘못 씀, switch~case문 반드시 break문 필수(return과 무관)*/
	public int search(doubleHead dh,int b) {
		switch(dh) {
		case STK1:
			for(int i=ptr1;i>=0;i--) {
				if(stk[i] == b) return ptr1 + 1 - i;
			}
			break;
		//index 범위 : ptr2 ~ capacity이므로 index - (포인터) + 1 을 기준으로 반복문 진행
		case STK2:
			for(int i=ptr2;i<capacity;i++) {
				if(stk[i] == b) return i - ptr2 + 1;
			}
			break;
		}
		return -1;
	}
	
	//기타
	public void clear(doubleHead dh) {
		switch(dh) {
		case STK1:
			ptr1 = 0; break;
		case STK2:
			ptr2 = 0; break;
		}
	}
	
	public int capacity() {
		return this.capacity;
	}
	
	public int size(doubleHead dh) {
		int sz = 0;
		switch(dh) {
		case STK1:
			sz = ptr1; break;
		case STK2:
			sz = ptr2; break;
		}
		return sz;
	}
	
	public boolean isEmpty(doubleHead dh) {
		boolean flag = true;
		switch(dh) {
		case STK1:
			if(ptr1 == 0) flag = false; break;
		case STK2:
			if(ptr2 == 0) flag = false; break;
		}
		return flag;
	}
	
	public boolean isFull() {
		boolean flag = false;
		if(ptr1 >= ptr2 + 1) flag = true;
		return flag;
	}
	
	/* 스택 empty조건: " <= 0" 
	 * break절: if~else문 바깥에 작성!!
	 */
	public void dump(doubleHead dh) {
		switch(dh) {
		case STK1:
			if(ptr1 <= 0) System.out.println("스택이 비어있습니다.");
			else {
				for(int i=ptr1;i>=0;i--) {
					System.out.println(stk[i]+" ");
				}
				//break;
			}
			break;
		case STK2:
			if(ptr2 <= 0) System.out.println("스택이 비어있습니다.");
			else {
				for(int i=ptr2;i<capacity;i++) {
					System.out.println(stk[i]+" ");
				}
				//break;
			}
			break;
		}		
	}
}
