package ch06;

import java.util.Scanner;
import java.util.Arrays;

public class Q09 {
	static int count1;
	static int count2;
    //--- 셸 정렬 VER1---//
    static int shellSort(int[] a, int n) {
        for (int h = n / 2; h > 0; h /= 2)
            for (int i = h; i < n; i++) {
                int j;
                int tmp = a[i];
                for (j = i - h; j >= 0 && a[j] > tmp; j -= h) {
                    a[j + h] = a[j];
                    count1++;
                }
                a[j + h] = tmp;
            }
        return count1;
    }
    
    //--- 셸 정렬 VER2 ---//
    /*
     * 증분값 h에 적용되는 수열(점화식)에 따라 쉘 정렬의 효율성이 달라짐
     * 시간 복잡도: O(n⁴∕³) ~ O(n²)
     */
    static int shellSort2(int[] a, int n) {
        int h;
        for (h = 1; h < n; h = h * 3 + 1)
            ;

        for ( ; h > 0; h /= 3)
            for (int i = h; i < n; i++) {
                int j;
                int tmp = a[i];
                for (j = i - h; j >= 0 && a[j] > tmp; j -= h) {
                    a[j + h] = a[j];
                    count2++;
                }
                a[j + h] = tmp;
            }
        return count2;
    }    

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("셸 정렬 비교");
        System.out.print("요솟수: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }
        int[] y = x.clone();
        System.out.println("y : "+Arrays.toString(y));
        
        int ver1 = shellSort(x, nx);            // 배열 x를 셸정렬
        int ver2 = shellSort2(y, nx);
        System.out.println("ver1 : "+ver1+", ver2 : "+ver2);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "]=" + x[i]);
    }
}
