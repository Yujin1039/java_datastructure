package ch09;

import java.util.Comparator;

import ch09.LinkedList.Node;

public class LinkedListT<E> {
	//--- 노드 ---//
	class Node<E> {
		private E data;              // 데이터
		private Node<E> next;        // 뒤쪽 포인터(다음 노드에 대한 참조)

		//--- 생성자(constructor) ---//
		Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node<E> head;        // 머리 포인터(머리 노드에 대한 참조)
	private Node<E> tail;		 // 꼬리 포인터(꼬리 노드에 대한 참조)
	private Node<E> crnt;        // 선택 포인터(선택 노드에 대한 참조)

	//--- 생성자(constructor) ---//
	public LinkedListT() {
		head = tail = crnt = null;
	}

	//--- 머리 노드 삽입 ---//
	public void addFirst(E obj) {
		Node<E> ptr = head;                       // 삽입 전의 머리 노드
		head = crnt = new Node<E>(obj, ptr);
	}

	//--- 꼬리 노드 삽입 ---//
	public void addLast(E obj) {
		if(head == null) {
			addFirst(obj);
		}else {
			tail.next = crnt = new Node<E>(obj,null);
			tail = tail.next;
		}
		
		//A1. 변수의 참조 혼동
		//데이터의 주소만 접근가능 ≠ 데이터의 값 변경 불가
		//즉, tail에서 데이터 변동을 주면 자동으로 리스트의 마지막 데이터에도 반영됨
		/*
		Node<E> ptr = head;
		Node<E> pre = head;
		while(ptr != null) {
			pre = ptr;
			ptr = ptr.next;
		}
		tail = pre.next = crnt = new Node<E>(obj, null);
		*/
	}

	//--- 노드 검색 ---//
	public E search(E obj, Comparator<? super E> c) {
		Node<E> ptr = head;                          // 현재 스캔 중인 노드

		while (ptr != null) {
			if (c.compare(obj, ptr.data) == 0) {    // 검색 성공
				crnt = ptr;
				return ptr.data;
			}
			ptr = ptr.next;                                // 뒤쪽 노드에 주목
		}
		return null;                                       // 검색 실패
	}

	//--- 머리노드 삭제 ---//
	public void removeFirst() {
		if (head != null) {                        // 리스트가 비어있지 않으면
			head = crnt = head.next;
			/*노드 삭제 후 빈 리스트가 되면(= 원래 노드가 1개라면) tail도 업데이트 필수*/
			if(head == null) tail = null;
		}
	}

	//--- 꼬리노드 삭제 ---//
	public void removeLast() {
		if (head != null) {
			if (head.next == null)             // 노드가 하나만 있으면
				removeFirst();                 // 머리노드 삭제
			else {
				Node<E> ptr = head;
				Node<E> pre = head;
				
				//포인터의 경우, 조건을 글로 쓰면서 생각정리하기
				/* 뒤에서 2번째 요소 찾기 
				 * -> 포인터.next = null일때, 이전 포인터
				 * -> 포인터.next != null 마지막 회차의 포인터 */
				while(ptr.next != null) {
					pre = ptr;
					ptr = ptr.next;
				}
				tail = crnt = pre;
				tail.next = null;
			}
		}
	}

	//--- 노드p 삭제 ---//
	public void remove(Node p) {
		if (head != null) {
			if (p == head) {                // p가 머리 노드이면
				removeFirst();            // 머리 노드 삭제
			}else if(p == tail) {
				removeLast();
			} else {
				Node<E> ptr = head;

				while (ptr.next != p) {
					ptr = ptr.next;
					if (ptr == null) return;    // p가 리스트에 없음
				}
				ptr.next = p.next;
				crnt = ptr;
			}
		}
	}

	//--- 선택 노드 삭제 ---//
	public void removeCurrentNode() {
		remove(crnt);
	}

	//--- 전체노드 삭제 ---//
	public void clear() {
		while (head != null)        // 비게 될 때까지
			removeFirst();          // 머리 노드 삭제
		crnt = null;
	}

	//--- 선택 노드를 하나 뒤쪽으로 진행 ---//
	public boolean next() {
		if (crnt == null || crnt.next == null)
			return false;           // 나아갈 수 없음
		crnt = crnt.next;
		return true;
	}

	//--- 선택 노드 표시 ---//
	public void printCurrentNode() {
		if (crnt == null)
			System.out.println("주목노드가 없습니다.");
		else
			System.out.println(crnt.data);
	}

	//--- 전체 노드 표시 ---//
	public void dump() {
		Node<E> ptr = head;

		while (ptr != null) {
			System.out.println(ptr.data);
			ptr = ptr.next;
		}
	}
	
    public void purge(Comparator <? super E> c) {
    	Node<E> ptr = head;
    	boolean flag = false;
    	
    	while(ptr != null) {
    		Node<E> crnt = ptr.next;
    		while(crnt != null) {
    			if(c.compare(ptr.data,crnt.data) == 0) {
    				removeCurrentNode();
    				flag = true;
    			}
    		}
    		if(flag) {
    			Node<E> temp = ptr.next;
    			remove(ptr);    		
    			ptr = temp;
    		}else {
    			ptr = ptr.next;    			
    		}
    	}
    	crnt = head;
    }
    
    public E retrieve(int n) {
    	Node<E> ptr = head;
    	for(int i=0;head != null && ptr != null;i++) {
    		if(n == i) return ptr.data;
    	}
    	return null;
    }
}
