package WEEK_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14501_퇴사 {

	public static void main(String[] args) throws IOException {
		/* 문제) 퇴사
		 * 오늘부터 N+1일째 되는 날 퇴사를 하기 위해서, 남은 N일 동안 최대한 많은 상담을 하려고 한다.
		 * 상담을 완료하는데 걸리는 기간 Ti와 상담을 했을 때 받을 수 있는 금액 Pi
		 * 얻을 수 있는 최대 수익
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int[] t = new int[n+1];
		int[] p = new int[n+1];
		int[] dp = new int[n+1];	// dp 배열 생성
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());	// 상담하는데 걸리는 시간
			p[i] = Integer.parseInt(st.nextToken());	// 상담 금액
		}
		
		// 역방향 (완료기준?)
		for(int i=n-1; i>=0; i--) {
			// 기간 내 상담 가능하다면
			if(i+t[i]<=n) {
				// 상담 안했을 때와 상담 했을 때 금액 비교
				// 다음날 금액(이미 저장된)과 상담 끝나는 날의 금액+현재 상담금액
				dp[i] = Math.max(dp[i+1], dp[i+t[i]]+p[i]);
			}
			// 상담 불가하면 다음날 금액과 같음
			else {
				dp[i] = dp[i+1];
			}
		}
		System.out.println(dp[0]);
		
		// 순방향
//		// 상담을 완료하는 날의 값에 그 날의 dp값과 현재 dp값+해당 상담 금액 중 최대값을 저장해준다. 
//		for(int i=0; i<n; i++) {
//			if (i+t[i] <= n) {
//				dp[i+t[i]] = Math.max(dp[i+t[i]], dp[i]+p[i]);
//			}
//			// 누적하여 저장해주기 위해 이전 값과 비교하여 최대값 넣어주기
//			dp[i+1] = Math.max(dp[i+1], dp[i]);
//		}
//		
//		System.out.println(dp[n]);

	}

}
