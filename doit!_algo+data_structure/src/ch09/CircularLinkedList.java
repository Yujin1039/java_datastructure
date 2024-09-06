package ch09;

import java.util.Comparator;

import ch09.LinkedList.Node;

public class CircularLinkedList<E> {
    //--- 노드 ---//
    class Node<E> {
        private E data;              // 데이터
        private Node<E> next;        // 뒤쪽 포인터(다음 노드에 대한 참조)

        //--- 생성자1(constructor) ---//
        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
        
      //--- 생성자2(constructor) ---//
        Node(E data) {
            this.data = data;
        }
    }
    
    private Node<E> head;        // 머리 노드
    private Node<E> tail;
    private Node<E> crnt;        // 선택 노드
    
    public CircularLinkedList() {
    	head = tail = crnt = null;
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
    
    //--- 머리 노드 삽입 ---//
    public void addFirst(E obj) {
        if(head == null) {
        	head = tail = new Node<E>(obj);
        }else {
        	Node<E> ptr = head;                       // 삽입 전의 머리 노드
        	head = tail.next = crnt = new Node<E>(obj, ptr);                	
        }
    }    
    
    //--- 꼬리 노드 삽입 ---//
    public void addLast(E obj) {
        if (head == null)                	  // 리스트가 비어있으면
        	head = tail = new Node<E>(obj);   // 머리에 삽입
        else {
            Node<E> ptr = tail;
            ptr.next = tail = crnt = new Node<E>(obj,head);
        }
    } 
    
    //--- 머리노드 삭제 ---//
    public void removeFirst() {
        if (head != null) {                        // 리스트가 비어있지 않으면
            if(head == tail) {
            	head = tail = crnt = null;
            }else {
            	head = tail = crnt = head.next;
            }
        }
    }
    
    //--- 꼬리노드 삭제 ---//
    public void removeLast() {
        if (head != null) {
            if (head.next == null)             // 노드가 하나만 있으면
                removeFirst();                 // 머리노드 삭제
            else {
                Node<E> ptr = head;            // 스캔 중인 노드
                Node<E> pre = head;            // 스캔 중인 노드의 앞쪽 노드

                while (ptr.next != null) {
                    pre = ptr;
                    ptr = ptr.next;
                }
                tail = crnt = pre;
                pre.next = head;
            }
        }
    } 
    
    //--- 노드 p 삭제 ---//
    public void remove(Node p) {
        if (head != null) {
            if (p == head)                // p가 머리 노드이면
                removeFirst();            // 머리 노드 삭제
            else if (p == tail)
            	removeLast();
            else {
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
        //crnt = null;
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
    
    // 서로 같은 노드를 찾아 "모두" 삭제하는 메서드
    public void purge(Comparator <? super E> c) {
    	boolean flag = false;
    	
    	while(head != null) {
    		Node<E> ptr = head;
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
    
    // 머리 노드로부터 n개 뒤 노드의 데이터 참조를 반환하는 메서드
    public E retrieve(int n) {
    	Node<E> ptr = head;
    	for(int i=0;head != null && ptr != null;i++) {
    		if(n == i) return ptr.data;
    	}
    	return null;
    }    
}
