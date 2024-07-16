package this_is_java;

import java.util.Scanner;

class Account{
	String accountNum;
	String accountHl;
	int balance;

	Account(String num,String holder,int balance){
		this.accountNum = num;
		this.accountHl = holder;
		this.balance = balance;
	}	
}

public class BankApplication {
	static Account findAccount(String num,Account[] bank,int count) {
		for(int i=0;i<count;i++) {
			if(bank[i].accountNum.equals(num)) {
				return bank[i];
			}
		}
		return null;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Account[] bank = new Account[100];
		int count = 0;
		while(true) {
			System.out.println("-----------------------------------");
			System.out.println("1.계좌생성|2.계좌목록|3.예금|4.출금|5.종료");
			System.out.println("-----------------------------------");
			System.out.print("선택>");
			String menuNum = sc.nextLine();
			System.out.println("--------");
			if(menuNum.equals("1")) {				
				System.out.println("계좌생성");
				System.out.println("--------");
				System.out.print("계좌번호: ");
				String num = sc.nextLine();
				System.out.print("계좌주: ");
				String holder = sc.nextLine();
				System.out.print("초기입금액: ");
				int balance = Integer.parseInt(sc.nextLine());
				bank[count++] = new Account(num,holder,balance);
				System.out.println("결과: 계좌가 생성되었습니다.");
			}else if(menuNum.equals("2")) {
				System.out.println("계좌목록");
				System.out.println("--------");
				for(int i=0;i<bank.length;i++) {
					if(bank[i]!=null) {
						System.out.printf("%s\t%s\t%d\n",bank[i].accountNum,bank[i].accountHl,bank[i].balance);
					}
				}
			}else if(menuNum.equals("3")) {
				System.out.println("예금");
				System.out.println("--------");
				System.out.print("계좌번호:");
				String num = sc.nextLine();
				System.out.print("예금액: ");
				int deposit = Integer.parseInt(sc.nextLine());
				Account account = findAccount(num, bank, count);
				if(account!=null) {
					account.balance += deposit; 
					System.out.println("입금이 성공했습니다.");
				}else {
					System.out.println("잘못된 계좌 번호를 입력했습니다.");
				}

			}else if(menuNum.equals("4")) {
				System.out.println("출금");
				System.out.println("--------");
				System.out.print("계좌번호:");
				String num = sc.nextLine();
				System.out.print("출금액: ");
				int deposit = Integer.parseInt(sc.nextLine());
				Account account = findAccount(num, bank, count);
				if(account!=null) {
					account.balance -= deposit; 
					System.out.println("출금이 성공했습니다.");
				}else {
					System.out.println("잘못된 계좌 번호를 입력했습니다.");
				}				
			}else if(menuNum.equals("5")) {
				System.out.println("프로그램 종료");
				break;
			}
		}
		sc.close();
	}	
}
