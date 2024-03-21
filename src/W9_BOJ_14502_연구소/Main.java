package W9_BOJ_14502_연구소;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m;
	static int[][] map;
	static int[][] copyMap;
	static boolean[][] visited;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int safe;
	static int safeMax = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		/* 문제) 연구소
		 * 
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		// 지도 입력 받기
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		wallDfs(0);
		
		System.out.println(safeMax);
		
	}

	// 탐색하면서 벽 세우는 dfs
	static void wallDfs(int wall) {
		
		// 벽이 3개 세워졌으면 bfs 호출
		if (wall == 3) {
			bfs();
			return;
		}
		
		// 지도 돌면서 벽 설치해주고 재귀호출
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					wallDfs(wall+1);
					map[i][j] = 0;	// dfs 한번 쭉 끝나면 다시 값 돌려주기
				}
			}
		}

	}
	
	// 바이러스 전파하는 bfs
	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		visited = new boolean[n][m];
		
		// 바이러스가 있는 곳 큐에 넣어주기
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if (map[i][j]==2) {
					q.add(new int[] {i, j});
				}
			}
		}
		
		// 주형 says "동시성문제" 피하기 위한 배열 복사
		copyMap = new int[n][m];
		for(int i=0; i<n; i++) {
			copyMap[i] = map[i].clone();
		}
		
		// bfs 돌려주기
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int d=0; d<4; d++) {
				int nr = cur[0]+dr[d];
				int nc = cur[1]+dc[d];
				
				if (nr>=0 && nr<n && nc>=0 && nc<m) {
					if (!visited[nr][nc] && copyMap[nr][nc]==0) {
						// 복사 배열의 [nr][nc]에 2 넣어주기
						copyMap[nr][nc] = 2;
						// 큐에 값 저장
						q.add(new int[] {nr, nc});
						// 방문체크
						visited[nr][nc] = true;
					}
				}
			}
		}
		
		// 안전영역 구하기
		safe = 0;	// 영역 개수 초기화
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				
				// 복사 배열의 값이 0이면 영역 개수 1 증가
				if (copyMap[i][j]==0) {
					safe++;
				}
			}
		}
		
		// 최대값 갱신
		safeMax = Math.max(safeMax, safe);
	}
	
}
