package ch03;

public class Q3 {
	static int searchIdx(int[] a, int n, int key, int[] idx) {
		int count = 0;
		for(int i=0;i<n;i++) {
			if(a[i] == key) {
				idx[count++] = i;
			}			 
		}
		return idx.length;
	}
}
