package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12865 {

	public static void main(String[] args) throws IOException {
		/* 문제) 평범한 배낭
		 * 
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n+1][2];
		
		// 물건의 무게와 가치 입력받기
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// dp 배열 생성
		int[][] dp = new int[n+1][k+1];
		
		// 순회하면서 최대값 비교하며 갱신
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=k; j++) {
				int weight = arr[i][0];	// 현재 물건의 무게
				int value = arr[i][1];	// 현재 물건의 가치
				
				// 넣을 수 있는 무게이면
				if(j>=weight) {
					// 지금 무게를 유지하는 것과 새로운 물건을 넣었을 때의 무게 비교하여 최대값 비교
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight]+value); 
				}
				// 아니면
				else {
					// 이전 무게 유지
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		System.out.println(dp[n][k]);
	}

}
