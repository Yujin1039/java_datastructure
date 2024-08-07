package ch04;

import java.util.EmptyStackException;

public class Gstack<E> {
	private int max;
	private int ptr;
	private E[] stk;
	
	//⭐ 생성자
	public Gstack(int length){
		this.max = length;
		this.ptr = 0;
		try {
			this.stk = (E[]) new Object[length];//❓
		}catch(OutOfMemoryError e) {//메모리가 부족할 때 발생하는 에러
			max = 0;
		}
		
	}
	
	/* 스택 예외 처리 */
	// 스택이 다 찼을 때 : StackOverflowError (extends RuntimeException)
	// 스택이 비었을 때 : EmptyStackException (extends RuntimeException)
	
	//✅ push : overflow 예외 처리 필수
	public E push(E e) throws StackOverflowError {
		if(ptr >= max) {
			throw new StackOverflowError();
		}
		return stk[ptr++] = e;
	}
	
	//✅ pop : 예외처리시, 포인터=0일때도 포함
	public E pop() throws EmptyStackException{
		if(ptr <= 0) {
			throw new EmptyStackException();
		}
		return stk[ptr--];
	}
	
	//✅ peek : 반환값의 index ≠ 포인터 (= 포인터-1)
	public E peek() throws EmptyStackException{
		if(ptr < 0) {
			throw new EmptyStackException();
		}
		return stk[ptr -1];
	}
	
	//✅ search : top = 1을 기준으로 한 인덱스 반환,
	//           기준점 : ptr (max 아님), index를 0일때까지 반복해서 확인할 것!
	public int search(E e) {
		for(int i = ptr -1;i >= 0;i--) {
			if(stk[i].equals(e)) return (ptr-i);
		}
		return -1;
	}
	
	//기타
	//clear ❗
	public void clear() {
		ptr = 0;
	}
	
	public int capacity() {
		return max;
	}
	
	public int size() {
		return ptr;
	}
	
	//부등호 주의!
	public boolean isEmpty(){
		return ptr <= 0;
	}
	
	//부등호 주의!
	public boolean isFull() {
		return ptr >= max;
	}
	
	public void dump() {
		if(ptr <= 0) {
			System.out.println("스택이 비어있습니다.");
		}else{
			for(int i= ptr -1;i>=0;i--) {
				System.out.println(stk[i]+" ");
			}
			System.out.println();
		}
	}
}
