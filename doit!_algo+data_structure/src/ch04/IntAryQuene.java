package ch04;

public class IntAryQuene {
	private int max;
	private int num;
	private int[] que;
	
	//생성자
	public IntAryQuene(int max) {
		num = 0;
		this.max = max;
		try {
			que = new int[max];
		}catch(OutOfMemoryError e) {
			max = 0;
		}
	}
	//메서드의 앞 부분은 에러 처리 필수, 뒷 부분은 에러 처리 필요 X
	
	//enque(add, offer)
	public int enque(int a){
		if(num >= max) throw new IllegalStateException();
		que[num++] = a;
		return a;
	}
	
	//deque(remove, poll) <- 스택방식으로 풂
	public int deque() {
		if(num <= 0) throw new IllegalStateException();
		int b = que[0];
		num--;
		/*Q: i+1이 인덱스를 벗어나면? 
		  A: for문 시작전 num값 조정*/
		for(int i=0;i<num;i++) {
			que[i] = que[i+1];
		}
		return b;
	}
	
	//데이터 들여다보기(element, peek)
	public int element() {
		if(num <= 0) throw new IllegalStateException();
		return que[num -1];
	}
	
	//검색
	//--- 큐에서 검색하여 인덱스(찾지 못하면 –1)를 반환 ---//
	/* 예외 처리 필수 */
	public int indexOf(int b) {
		if(num <= 0) throw new IllegalStateException();
		for(int i=0;i<num;i++) {
			if(que[i] == b) return i;
		}
		return -1;
	}
	
	//기타
	public void clear() {
		/* 큐를 아예 제거하는게 아니라 비우기만 하므로 max값 조정 X */
		//max = 0;
		num = 0;
	}
	
	public int getCapacity() {
		return max;
	}
	
	public int size() {
		return num;
	}
	
	/* boolean형 : return 비교연산식 */
	public boolean isEmpty() {
		return num <= 0;
	}
	
	public boolean isFull() {
		return num == max;
	}
	
	public void dump() {
		if(num <= 0) {
			System.out.println("큐가 비어있습니다.");
		}else{
			for(int i=0;i<num;i++) {
				System.out.print(que[i]+" ");
			}
			System.out.println();
		}		
	}
}
