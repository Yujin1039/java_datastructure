package ch02;

import java.util.Random;

public class Q1 {
	static int maxOf(int[] a) {
		int max = a[0];
		for(int i=0;i<a.length;i++) {
			if(max < a[i]) max = a[i];
		}
		return max;
	}
	public static void main(String args[]) {
		Random rd = new Random();
		
		int num = 1 + rd.nextInt(10);
		System.out.println("사람수:"+num);
		int[] height = new int[num];
		
		System.out.println("키의 값은 아래와 같습니다.");
		for(int i=0;i<height.length;i++) {
			height[i] = 100 + rd.nextInt(100);
			System.out.println("height["+i+"]: "+height[i]);
		}
		System.out.println("최댓값은 "+maxOf(height)+"입니다.");
	}
}