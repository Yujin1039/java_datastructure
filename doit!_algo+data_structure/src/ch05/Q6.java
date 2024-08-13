package ch05;

public class Q6 {
	// int → char 변환: (char), Character.forDigit()
	
	//ASCII 변환 연산
	/* -> char '1' ≠ ASCII상 1
	 * char형 변수 + (해당 변수의 ASCII값)
	 */
	
	static void move(int no,int from,int to) {
		if(no > 1) {
			move(no-1,from,6-from-to);
		}
		System.out.printf("원반 %d를(을) %c기둥에서 %c기둥으로 옮김\n",no,(char) from+'A'-1,(char) to+'A'-1);
		
		if(no > 1) {
			move(no-1,6-from-to,to);
		}
	}
	
	public static void main(String[] args) {
		move(3,1,3);
	}
}
