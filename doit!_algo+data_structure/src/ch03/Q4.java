package ch03;
//mid값 변경을 까먹어서 진행이 안됨
/*
 * String.format("%%%ds", 3*mid),"+"
  -> ⓐ %s,%d 등은 1번에 1개의 값만 매핑 가능
  -> ⓑ "%%"와 같이 연속 2개 이상 사용하는 경우, (매핑할 값+1)개 만큼 % 개수 필요
 */
public class Q4 {
	static void printBinSearch(int[] a,int find) {
		int j=0;
		int start = 0;
		int end = a.length-1;
		int mid = (start+end)/2;
		System.out.print("   |");
		for(int i=0;i<a.length;i++) {
			System.out.printf("  %d",i);
		}
		System.out.print("\n---+");
		System.out.printf("%s","-".repeat(a.length*3));
		System.out.println();
		
		for(j=start;j<=end;j++) {
			System.out.print("   | <-");
			System.out.printf(String.format("%%%ds", 3*mid),"+");
			System.out.printf(String.format("%%%ds", 3*(mid-1)+1)," ");
			System.out.print("-> \n");
			System.out.printf("%3d|",mid);
			for(int i=0;i<a.length;i++) {
				System.out.printf("  %d",a[i]);
			}
			System.out.println();
			System.out.println("   |");
			if(a[mid] > find) {
				end = mid;
			}else if(a[mid] < find) {
				start = mid;
			}else {
				break;
			}
			mid = (start+end)/2;
		}
		System.out.printf("%d는 x[%d]에 있습니다.",find,mid);
	}
	public static void main(String[] args) {
		int[] x = {1,2,3,5,6,8,9};
		int y = 2;
		printBinSearch(x,y);
	}
}
