package ch03;

import java.util.Arrays;
import java.util.Scanner;

public class Q2 {
	static void printSeqSearch(int[] a,int n) {
		System.out.print("   |");
		for(int i=0;i<a.length;i++) {
			System.out.print(" "+i+" ");
		}
		System.out.println();
		System.out.print("---+"+"---".repeat(a.length)+"\n");
		
		for(int i=0;i<a.length;i++) {
			System.out.print("   |");
			System.out.print("   ".repeat(i)+" * "+"   ".repeat(a.length-1-i)+"\n");
			System.out.printf("  %d|",i);
			Arrays.stream(a).forEach(j -> System.out.print(" "+j+" "));
			System.out.println();
			if(a[i] == n) {
				System.out.println("  "+n+"은 x["+i+"]에 있습니다.");
				break;
			}
			System.out.println("   |");
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("요솟수 : ");
		int num = sc.nextInt();
		int[] x = new int[num];
		
		for(int i=0;i<num;i++) {
			System.out.print("x["+i+"]: ");
			x[i] = sc.nextInt();
		}
		
		System.out.print("탐색할 수 : ");
		int search = sc.nextInt();
		
		printSeqSearch(x,search);
		
		sc.close();
	}
}
