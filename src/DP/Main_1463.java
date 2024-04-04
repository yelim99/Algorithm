package DP;

import java.util.Scanner;

public class Main_1463 {

	public static void main(String[] args) {
		/* 문제) 1로 만들기
		 * 1. x가 3으로 나누어 떨어지면 3으로 나눈다.     
		 * 2. x가 2로 나누어 떨어지면 2로 나눈다.
		 * 3. 1을 뺀다.
		 * 
		 * 위 연산 세 개를 적절히 사용하여 1을 만들려고 할 때 연산 횟수의 최소값
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] dp = new int[n+1];
		dp[1] = 0;
		
		for(int i=2; i<=n; i++) {
			// 1로 뺀 값 저장해주고
			dp[i] = dp[i-1]+1;
			
			// 2로 나누어 떨어지면 현재 값과 2로 나눈 dp값을 비교
			if (i%2 == 0) {
				dp[i] = Math.min(dp[i], dp[i/2]+1);
			}
			// 3으로 나누어 떨어지면 현재 값과 3으로 나눈 dp값을 비교
			if (i%3 == 0) {
				dp[i] = Math.min(dp[i], dp[i/3]+1);
			}
		}
		
		System.out.print(dp[n]);

	}

}
