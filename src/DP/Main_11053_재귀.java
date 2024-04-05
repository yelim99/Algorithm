package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11053_재귀 {
	
	static int[] arr;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		/* 문제) 가장 긴 증가하는 부분 수열
		 * 수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.
		 * 예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 
		 * 가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[n];
		
		for(int i=0; i<n; i++) {
			LIS(i);
		}
		
		// 최대값 찾기
		int max = 0;
		for(int i=0; i<n; i++) {
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
		
	}
	
	static int LIS(int num) {
		
		// 저장된 dp값이 없는 경우 1로 초기화
		// 최소길이가 1이니까
		if (dp[num]==0) {
			dp[num] = 1;
		}
		
		// 역방향으로 돌면서 값 대소 비교하고, 앞의 값이 더 작으면 dp에 그 이전 dp값에 1 더해준다.
		for(int i=num-1; i>=0; i--) {
			if (arr[i] < arr[num]) {
				dp[num] = Math.max(dp[num], LIS(i)+1);
			}
		}
		
		return dp[num];
	}

}
