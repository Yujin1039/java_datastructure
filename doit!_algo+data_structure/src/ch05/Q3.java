package ch05;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Q3 {
	//방법3) 재귀 + 함수(답지)
	//--- 정숫값 x, y의 최대 공약수를 비재귀적으로 구하여 반환 ---//
	static int gcd(int x, int y) {
		while (y != 0) {
			int temp = y;
			y = x % y;
			x = temp;
		}
		return (x);
	}

	//--- 요솟수가 n인 배열 a의 모든 요소의 최대 공약수를 구합니다 ---//
	static int gcdArray(int a[], int start, int no) {
		if (no == 1)
			return a[start];
		else if (no == 2)
			return gcd(a[start], a[start + 1]);
		else
			return gcd(a[start], gcdArray(a, start + 1, no - 1));
	}
	
	static int gcdArray(int[] a) {		
		//방법2) 재귀를 사용한 방법
		Arrays.sort(a);
		if(Arrays.binarySearch(a, 0) == -1) {
			for(int i=1;i<a.length;i++) {
				a[i] = a[i] % a[0];
			}
			return gcdArray(a);
		}else {
			List<Integer> list = Arrays.stream(a)
									   .boxed()
									   .collect(Collectors.toList());
			return a[list.lastIndexOf(0)+1];
		}
		
		//방법1) 반복문 사용
		/*
		while(Arrays.binarySearch(a, 0) == -1) {
			Arrays.sort(a);
			System.out.println(Arrays.toString(a));
			for(int i=1;i<a.length;i++) {
				a[i] = a[i] % a[0];
			}
			Arrays.sort(a);
			System.out.println("after divide - "+Arrays.toString(a));
		}
		int e = 1;
		for(int d:a) {
			if(d != 0) {
				e = d; break;
			}
		}
		return e;
		*/
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);		
		System.out.print("입력할 숫자의 개수를 작성하세요 : ");
		int b = stdIn.nextInt();
		int[] c = new int[b];
		
		System.out.println("입력한 값의 최대공약수를 구합니다.");
		for(int i=0;i<c.length;i++){
			System.out.print("1이상의 정수를 입력하세요 : "); 
			b = stdIn.nextInt();
			if(b < 1) {
				i--;
				continue;
			}else {
				c[i] = b;
			}			
		}
		/*Arrays.sort(c);*/
		
		System.out.printf("배열의 숫자들의 최대공약수는 %d 입니다.",gcdArray(c));
		stdIn.close();
	}
}
