package ch01;

import java.util.Scanner;

public class Q16 {
    static void spira(int n){
        for(int i=1;i<=n;i++){
            System.out.print(" ".repeat(n-i));
            System.out.println("*".repeat(2*i-1));
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        do{
            System.out.print("단 수:");
            n = sc.nextInt();
        }while(n < 0);
        
        spira(n);
        
        sc.close();
    }
}
