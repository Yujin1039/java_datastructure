package ch09;

import java.util.Comparator;

public class DbLinkedList<E> {
	class Node<E>{
		private E data;
		private Node<E> pre;
		private Node<E> next;
		
		//더미 노드 생성자
		Node(){
			data = null;
			pre = next = this; // 더미노드의 포인터는 자기 자신을 가리킴
		}
		
		Node(E obj,Node<E> pre, Node<E> next){
			this.data = obj;
			this.pre = pre;
			this.next = next;
		}
	}
	
	private Node<E> head; // 머리 노드(= 더미 노드)
	private Node<E> crnt; // 선택 노드
	
	// 생성자
	public DbLinkedList(){
		head = crnt = new Node<E>(); /* 반드시 "<E>"를 써줘야 함*/
	}
	
	//리스트 비어있는지 여부
	public boolean isEmpty() {
		return head == head.next;
	}
	
	//노드 검색
	public E search(E obj,Comparator<? super E> c) {
		Node<E> ptr = head.next;
		
		while(ptr != head) {
			if(c.compare(obj,ptr.data) == 0) {
				crnt = ptr;     //선택 노드 업데이트
				return ptr.data;
			}
			ptr = ptr.next;
		}
		return null;
	}
	
	//선택 노드 표시
	public void printCurrentNode() {
		if(isEmpty()) {
			System.out.println("선택 노드가 없습니다.");
		}else {
			System.out.println(crnt.data);
		}
	}
	
	//전체 노드 표시
	public void dump() {
		Node<E> ptr = head.next;
		
		while(ptr != head) {
			System.out.println(ptr.data);
			ptr = ptr.next;
		}
	}
	
	//전체 노드 역순 표시
	public void dumpReverse() {
		Node<E> ptr = head.pre;
		
		while(ptr != head) {
			System.out.println(ptr.data);
			ptr = ptr.pre;
		}
	}
	
	//선택 노드 하나를 뒤쪽으로 진행
	public boolean next() {		
		if(crnt != head.pre) {
			crnt = crnt.next;
			return true;
		}
		return false;
	}
	
	//선택 노드 하나를 앞쪽으로 진행
	public boolean pre() {		
		if(crnt != head.next) {
			crnt = crnt.pre;
			return true;
		}
		return false;
	}
	
	//선택 노드 바로 뒤에 노드 삽입
	public void add(E obj) {
		                                           /* 새로 추가되는 노드 기준 앞,뒷 노드 생각하기*/
		crnt.next = crnt.next.pre = new Node<E>(obj,crnt,crnt.next);
		crnt = crnt.next;
	}
	
	// 머리 노드 삽입
	public void addFirst(E obj) {
		crnt = head; /* add 메서드의 crnt가 사용되는 위치 생각해서 대입*/
		add(obj);
	}
	
	// 꼬리 노드 삽입
	public void addLast(E obj) {
		crnt = head.pre;
		add(obj);
	}
	
	// 선택 노드 삭제
	public void removeCurrentNode() {
		if(!isEmpty()) {
			crnt.pre.next = crnt.next;
			crnt.next.pre = crnt.pre;
			crnt = crnt.pre;	
			/* 머리 노드를 삭제한 경우, 선택노드를 더미노드 → 첫번째 노드*/
			if(crnt == head) crnt = head.next; 
		}
	}
	
	// 노드 p 삭제
	/* 해당 노드가 존재하는지 확인해야함*/
	public void remove(Node p) {
		Node<E> ptr = head.next;
		
		while(ptr != head) {
			if(ptr == p) {
				crnt = ptr;
				removeCurrentNode();
				break;  // 반복문 종료
			}
			ptr = ptr.next;
		}
	}
	
	// 머리 노드 삭제
	public void removeFirst() {
		//remove(head.next);
		crnt = head.next;
		removeCurrentNode();
	}
	
	// 꼬리 노드 삭제
	public void removeLast() {
		crnt = head.pre;
		removeCurrentNode();
	}
	
	/* 전체 노드 삭제 */
	public void removeAll() {
		while(!isEmpty()) {
			removeFirst();
		}
	}
	
	//Q9. 서로 같은 노드를 찾아 "모두" 삭제하는 메서드
	public void purge(Comparator<? super E> c) {
		Node<E> ptr = head.next;
		boolean deleted = false;
		
		while(ptr != head) {
			crnt = ptr.next;
			while(crnt != ptr) {
				if(c.compare(ptr.data, crnt.data) == 0) {
					removeCurrentNode();
					deleted = true;
				}
				crnt = crnt.next;
			}
			if(deleted) {
				crnt = ptr;
				removeCurrentNode();
			}
			ptr = ptr.next;			
		}
		crnt = head.next;
	}
	
	//Q10. 머리 노드로부터 n개 뒤 노드의 데이터 참조를 반환하는 메서드
	public E retrieve(int n) {
		Node<E> ptr = head.next;
		
		while(n >= 0 && ptr != head) {
			if(n-- == 0) {
				crnt = ptr;
				return ptr.data;
			}
			ptr = ptr.next;
			//n--;
		}
		return null;
	}
}
