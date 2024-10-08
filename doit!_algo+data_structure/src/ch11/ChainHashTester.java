package ch11;

//Q1-1.체인법에 의한 해시 사용 예(key 회원번호 → 이름 변경)

import java.util.Scanner;

class ChainHashTester {
	static Scanner stdIn = new Scanner(System.in);

	//--- 데이터(회원번호＋이름) ---//
	static class Data {
		static final int NO   = 1;        // 번호를 읽어 들일까요?
		static final int NAME = 2;        // 이름을 읽어 들일까요?

		private Integer no;                      // 회원번호(키값)
		private String  name;                    // 이름

		//--- 키값 ---//
		/* 실제 hashCode값은 ChainHash 클래스에서 계산하고, 여기서는 대상이 되는 key만 전달 */
		String keyCode() {
			return name;
		}

		//--- 회원번호 반환 ---// 
		public String toString() {
            return Integer.toString(no);
        }

		//--- 데이터를 읽어 들임 ---//
		void scanData(String guide, int sw) {
			System.out.println(guide + "할 데이터를 입력하세요.");

			if ((sw & NO) == NO) {
				System.out.print("번호: ");
				no = stdIn.nextInt();
			}
			if ((sw & NAME) == NAME) {
				System.out.print("이름: ");
				name = stdIn.next();
			}
		}
	}

	//--- 메뉴 열거형 ---//
	enum Menu {
		ADD(      "추가"),
		REMOVE(   "삭제"),
		SEARCH(   "검색"),
		DUMP(     "표시"),
		TERMINATE("종료");

		private final String message;            // 표시할 문자열

		static Menu MenuAt(int idx) {            // 순서가 idx번째인 열거를 반환
			for (Menu m : Menu.values())
				if (m.ordinal() == idx)
					return m;
			return null;
		}

		Menu(String string) {                // 생성자(constructor)
			message = string;
		}

		String getMessage() {                // 표시할 문자열을 반환
			return message;
		}
	}

	//--- 메뉴 선택 ---//
	static Menu SelectMenu() {
		int key;
		do {
			for (Menu m : Menu.values())
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
			System.out.print(" : ");
			key = stdIn.nextInt();
		} while (key < Menu.ADD.ordinal() || key > Menu.TERMINATE.ordinal());

		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Menu menu;                                // 메뉴 
		Data data;                                // 추가용 데이터 참조
		Data temp = new Data();        // 읽어 들일 데이터

		ChainHash<String, Data> hash = new ChainHash<String, Data>(13);

		do {
			switch (menu = SelectMenu()) {
			case ADD :                               // 추가
				data = new Data();
				data.scanData("추가", Data.NO | Data.NAME);
				hash.add(data.keyCode(), data);
				break;

			case REMOVE :                       // 삭제
				temp.scanData("삭제", Data.NO);
				hash.remove(temp.keyCode());
				break;

			case SEARCH :                       // 검색
				temp.scanData("검색", Data.NO);
				Data t = hash.search(temp.keyCode());
				if (t != null)
					System.out.println("그 키를 갖는 데이터는 " + t + "입니다.");
				else
					System.out.println("해당 데이터가 없습니다.");
				break;

			case DUMP :                            // 표시
				hash.dump();
				break;
			}
		} while (menu != Menu.TERMINATE);
	}
}

