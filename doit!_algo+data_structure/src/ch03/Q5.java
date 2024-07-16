package ch03;

public class Q5 {
	static int binSearch(int[] a,int n, int key) {
		int start = 0;
		int end = n-1;
		int mid = (start+end)/2;
		int answer = -1;
		
		for(int i=end;i>=start;i--) {
			if(a[i]==key) {
				answer = i;
			}
			
			if(a[mid] > key) {
				end = mid;
			}else if(a[mid] < key){
				start = mid;
			}
			mid = (start+end)/2;
		}
		return answer;
	}
	
	public static void main(String[] args) {
		int[] x = {1,2,3,5,5,5,7,8,10};
		int y = x.length;
		int z = 5;
		
		int sIdx = binSearch(x, y, z);
		System.out.println(sIdx);
		if(sIdx == -1) {
			System.out.println("일치하는 요소가 없습니다");
		}else{
			System.out.printf("%d는 x[%d]에 있습니다.",z,sIdx);
		}
		
	}
}
