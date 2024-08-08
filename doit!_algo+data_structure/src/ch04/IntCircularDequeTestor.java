package ch04;

public class IntCircularDequeTestor {
	public static void main(String[] args) {
		
		IntCircularDeque icd = new IntCircularDeque(4);
		
		icd.addFirst(5);
		icd.addFirst(3);
		icd.addLast(7);
		icd.addLast(10);
		
		System.out.println("size : "+icd.size());
		System.out.println(icd.removeLast());
		System.out.println("size : "+icd.size());
		System.out.println(icd.removeFirst());
		System.out.println("size : "+icd.size());
		System.out.println(icd.removeLast());
		System.out.println(icd.removeFirst());
		
		/*
		IntDeque id = new IntDeque(3);
		id.addFirst(5);
		id.addLast(9);
		
		System.out.println(id.size());
		System.out.println(id.removeFirst());
		System.out.println(id.size());
		System.out.println(id.removeFirst());
		System.out.println(id.size());
		*/
	}
}
