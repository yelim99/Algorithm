package W10_BOJ_14503_로봇청소기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
	
	static int n, m;
	static int r, c, d;
	static int[][] graph;
	static boolean[] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

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
		 *  0->3, 3->2, 2->1, 1->0
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
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
		
		int cnt = 0;
		
		while(true) {
			// 1. 현재 칸이 아직 청소되지 않은 경우 현재 칸 청소
//			if(graph[r][c] == 0) {
//				graph[r][c] = 2;
//				cnt++;
//			}
			
			graph[r][c] = 2;
			cnt++;
			
			// 주변 4칸 중 청소되지 않은 빈 칸이 있는지 확인
			boolean check = false;
			for(int x=0; x<4; x++) {
				int nr = r+dr[x];
				int nc = c+dc[x];
				
				if (nr>=0 && nr<n && nc>=0 && nc<m) {
					if(graph[nr][nc] == 0) {
						check = true;
					}
				}
			}
			
			// 2. 청소되지 않은 빈 칸이 없는 경우
			if (!check) {
				if (d==0) {
					if (graph[r+1][c] == 0) {
						r++;
						continue;
					}
					else break;
				}
				else if (d==1) {
					if (graph[r][c-1] == 0) {
						c--;
						continue;
					} else break;
				}
				
				else if (d==2) {
					if (graph[r-1][c] == 0) {
						r--;
						continue;
					} else break;
				}
				
				else {
					if (graph[r][c+1] == 0) {
						c++;
						continue;
					} else break;
				}
			}
			
			// 청소되지 않은 빈 칸이 있는 경우
			else {
				// 반시계 방향으로 90도 회전
				d -= 1;
				if (d<0) d=3;
				
				// 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진
				if (d==0) {
					if (graph[r-1][c]==0) {
						r--;
						continue;
					}
				}
				else if (d==1) {
					if (graph[r][c+1]==0) {
						c++;
						continue;
					}
				}
				else if (d==2) {
					if (graph[r+1][c]==0) {
						r++;
						continue;
					}
				}
				else {
					if (graph[r][c-1]==0) {
						c--;
						continue;
					}
				}
			}
			
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(graph[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println(cnt);

	}

}
