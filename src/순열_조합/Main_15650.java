package 순열_조합;

import java.util.Scanner;

public class Main_15650 {
	
	static int n, m;
	static int[] arr;
	static boolean[] visited;
	static int[] sel;

	public static void main(String[] args) {
		// N과 M (2)
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr = new int[m];
		visited = new boolean[n];
		
		comb(0, 0);
		
	}
	
	static void comb(int cnt, int idx) {
		if (idx == m) {
			for(int x : arr) {
				System.out.print(x+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=cnt; i<n; i++) {
			if (!visited[i]) {
				arr[idx] = i+1;
				visited[i] = true;
				comb(i+1, idx+1);
				visited[i] = false;
			}
		}
	}

}
