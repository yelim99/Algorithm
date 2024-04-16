package BOJ;

import java.util.Scanner;

public class Main_11048_이동하기 {
	
	static int n, m;
	static int[][] map;
	static int cnt;
	

	public static void main(String[] args) {
		/* 문제) 11048_이동하기
		 * 
		 */
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		map = new int[n][m];
		int[][] dp = new int[n+1][m+1];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j] = sc.nextInt();
				dp[i+1][j+1] = map[i][j];
			}
		}
		
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				dp[i][j] = Math.max(Math.max(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1])+dp[i][j];
			}
		}

		System.out.println(dp[n][m]);
		
	}
	

}