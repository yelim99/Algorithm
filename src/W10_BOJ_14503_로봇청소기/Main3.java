package W10_BOJ_14503_로봇청소기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3 {
	
	static int n, m;
	static int r, c, d;
	static int[][] graph;
	static int[] dr = {-1, 0, 1, 0};	// 북-동-남-서
	static int[] dc = {0, 1, 0, -1};
	static int cnt = 1;

	public static void main(String[] args) throws IOException {
		/* 문제) 로봇 청소기
		 * 로봇 청소기가 있는 방은 n*m 크기의 직사각형
		 * 청소기는 바라보는 방향이 있으며, 이 방향은 동서남북 중 하나이다.
		 * 가장 북쪽의 서쪽 칸 (0, 0) / 가장 남쪽의 동쪽 (n-1, m-1)
		 * 좌표 (r, c)는 북쪽에서 (r+1)번 째에 있는 줄의 서쪽에서 (c+1)번째 칸을 가리킨다.
		 * 
		 * 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
		 * 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
		 * 	- 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로
		 *  - 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춤
		 * 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
		 * 	- 반시계 방향으로 90도 회전
		 *  - 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진
		 *  - 1번으로 돌아가기
		 *  
		 *  d: 0-북, 1-동, 2-남, 3-서
		 *  반시계방향 회전: 
		 *  0->3, 3->2, 2->1, 1->0
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		graph = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		clean(r, c, d);
		
		System.out.println(cnt);

	}
	
	
	static void clean(int x, int y, int dir) {
		// 현재 칸 청소
		graph[x][y] = -1;

		for(int i=0; i<4; i++) {
			// 반시계 방향으로 회전
			dir = (dir+3)%4;
			
			// 탐색
			int nr = x+dr[dir];
			int nc = y+dc[dir];
			
			// 범위 내에 있고 청소가 안되어있으면
			if (nr>=0 && nr<n && nc>=0 && nc<m) {
				if (graph[nr][nc]==0) {
					// 카운트 증가, 재귀호출
					cnt++;
					clean(nr, nc, dir);
					// 여기서 리턴 해주어야 엄한데 청소 안함
					return;
				}
			}
			
		}
		
		// 후진
		int back = (dir+2)%4;
		
		// 탐색
		int br = x+dr[back];
		int bc = y+dc[back];
		
		// 범위 내에 있고, 벽이 아니면 후진
		if (br>=0 && br<n && bc>=0 && bc<m && graph[br][bc]!=1) {
			clean(br, bc, dir);
		}
		
		
	}

}
