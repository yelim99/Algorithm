package DP;

import java.util.Scanner;

public class Main_11726 {

	public static void main(String[] args) {
		/* 문제) 2xN 타일링
		 * 2xN 크기의 직사각형을 1*2, 2*1 타일로 채우는 방법의 수
		 */
		
		/* 2*1 = 1
		 * 2*2 = 2
		 * 2*3 = 3
		 * 2*4 = 5
		 * 
		 * dp[i] = dp[i-1] + dp[i-2]
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] dp = new int[n+1];
		
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i=3; i<=n; i++) {
			dp[i] = dp[i-1] + dp[i-2] % 10007; 
		}
		
		System.out.println(dp[n]);

	}

}
