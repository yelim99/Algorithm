package WEEK_19;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_4485_녹색옷젤다 {
	
	static int n;
	static int[][] map;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	static int[][] coins;

	public static void main(String[] args) {
		/* 문제) 4485_녹색 옷 입은 애가 젤다지?
		 * 
		 * 다익스트라
		 */
		
		Scanner sc = new Scanner(System.in);
		int idx = 1;	// 정답 출력 위한 idx
		
		while (true) {
			n = sc.nextInt();	// 동굴 크기
			
			// 입력 받은 값이 0이면 끝내기
			if (n==0) break;
			
			// 초기화
			map = new int[n][n];
			coins = new int[n][n];	// 최단 경로로 누적되는 coin
			
			// max값으로 채우기
			for(int i=0; i<n; i++) {
				Arrays.fill(coins[i], Integer.MAX_VALUE);
			}
			
			
			// 도둑루피 map
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			// 다익스트라 메소드 불러오기
			move();
			
			int ans = coins[n-1][n-1];
			
			System.out.printf("Problem %d: %d%n", idx, ans);
			idx++;
		}

	}
	
	// 다익스트라
	static void move() {
		// 우선순위 큐 생성
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2]-o2[2]);
		// 첫 값은 같은 값
		coins[0][0] = map[0][0];
		// 큐에 넣어주기
		pq.add(new int[] {0, 0, map[0][0]});
		
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int r = cur[0];
			int c = cur[1];
			int coin = cur[2];
			
			for(int d=0; d<4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				
				if (nr>=0 && nr<n && nc>=0 && nc<n) {
					// 최소값 비교해서 갱신, 큐에 넣어주기
					if (coins[nr][nc] > map[nr][nc]+coin) {
						coins[nr][nc] = map[nr][nc]+coin;
						pq.add(new int[] {nr, nc, coins[nr][nc]});
					}
				}
			}
		}
	}

}
