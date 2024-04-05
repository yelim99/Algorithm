package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11053 {

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
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[n];
		
		for(int i=0; i<n; i++) {
			dp[i] = 1;
			
			for(int j=0; j<i; j++) {
				if (arr[i]>arr[j] && dp[j]>=dp[i]) {
					dp[i] = dp[j]+1;
				}
			}
		}
		int max = 0;
		for(int i=0; i<n; i++) {
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
		
	}

}
