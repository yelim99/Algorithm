package W5_BOJ_12865_평범한배낭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		/* 문제) 평범한 배낭
		 * 준서가 여행에 필요하다고 생각하는 N개의 물건이 있다. 
		 * 각 물건은 무게 W와 가치 V를 가지는데, 해당 물건을 배낭에 넣어서 가면 준서가 V만큼 즐길 수 있다. 
		 * 아직 행군을 해본 적이 없는 준서는 최대 K만큼의 무게만을 넣을 수 있는 배낭만 들고 다닐 수 있다. 
		 * 준서가 최대한 즐거운 여행을 하기 위해 배낭에 넣을 수 있는 물건들의 가치의 최댓값을 알려주자.
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		// 물건의 무게와 가치 저장할 배열
		int[][] arr = new int[n+1][2];
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 최대값 계산을 위한 dp 배열
		int[][] dp = new int[n+1][k+1];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=k; j++) {
				int w = arr[i][0];	// 현재 물건의 무게
				int v = arr[i][1];	// 현재 물건의 가치
				
				// 가방에 넣을 수 있는 무게일 때
				if (j>=w) {
					// 이전까지의 가치와, 들어있던 물건을 빼고 현재 물건을 넣었을 때의 가치를 비교하여 더 큰 값을 저장해준다.
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w]+v);
				}
				// 가방에 넣을 수 있는 무게가 아니면 이전까지의 최대 가치를 저장
				else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		System.out.println(dp[n][k]);

	}

}
