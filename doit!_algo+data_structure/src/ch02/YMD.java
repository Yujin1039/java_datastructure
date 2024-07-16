package ch02;

import java.util.Scanner;

public class YMD {

	int y;
	int m;
	int d;

	static int[][] mdays = {
			{31,28,31,30,31,30,31,31,30,31,30,31},
			{31,29,31,30,31,30,31,31,30,31,30,31}
	};

	static int isLeap(int year) {
		return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
	}

	YMD(int y,int m,int d){
		this.y = y;
		this.m = m;
		this.d = d;
	}

	YMD after(int n) {
		YMD af = new YMD(this.y,this.m,this.d);
		af.d += n;
		while(mdays[isLeap(af.y)][af.m -1] < af.d) {
			af.d -= mdays[isLeap(af.y)][af.m-1];
			af.m++;
			if(af.m > 12) {
				af.m -= 12;
				af.y++;
			}
		}
		return af;			
	}
	
	YMD before(int n) {
		YMD bf = new YMD(this.y,this.m,this.d);
		bf.d -= n;
		while(bf.d < 0) {
			bf.d += mdays[isLeap(bf.y)][bf.m-2];
			bf.m--;
			if(bf.m < 0) {
				bf.m += 12;
				bf.y--;
			}
		}
		return bf;
	}



	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		System.out.print("연도는?");
		int y = sc.nextInt();
		System.out.print("월은?");
		int m = sc.nextInt();
		System.out.print("일자는?");
		int d = sc.nextInt();
		System.out.print("전 또는 후를 선택하세요.(전:0,후:1)");
		int check = sc.nextInt();
		System.out.print("원하는 n일 전/후는?");
		int n = sc.nextInt();

		YMD today = new YMD(y,m,d);
		System.out.printf("오늘은 %d년 %d월 %d일 입니다.\n",today.y,today.m,today.d);
		if(check == 1) {
			YMD dif = today.after(n);		
			System.out.printf("%d일 후는 %d년 %d월 %d일 입니다.",n,dif.y,dif.m,dif.d);
		}else {
			YMD dif = today.before(n);		
			System.out.printf("%d일 전은 %d년 %d월 %d일 입니다.",n,dif.y,dif.m,dif.d);
		}
		
		sc.close();
	}

}
