package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1926_그림 {
	
	static int n, m;
	static int[][] graph;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int cnt;	// 그림 개수
	static int width;	// 그림 넓이
	static int max;
	static Queue<int[]> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		/* 문제) 그림_1926
		 * 어떤 큰 도화지에 그림이 그려져 있을 때, 그 그림의 개수와, 그 그림 중 넓이가 가장 넓은 것의 넓이를 출력하여라. 
		 * 단, 그림이라는 것은 1로 연결된 것을 한 그림이라고 정의하자. 
		 * 가로나 세로로 연결된 것은 연결이 된 것이고 대각선으로 연결이 된 것은 떨어진 그림이다. 
		 * 그림의 넓이란 그림에 포함된 1의 개수이다.
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		graph = new int[n][m];
		visited = new boolean[n][m];
		
		// graph에 값 입력받기
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		max = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
//				cnt = 0;
				if (graph[i][j]==1 && !visited[i][j]) {
//					dfs(i, j);
					bfs(i, j);
					
				}
				
//				max = Math.max(max, width);
//				width = 0;
			}
		}
			
		
		System.out.println(cnt);
		System.out.println(max);

	}
	
	// bfs
	static void bfs(int r, int c) {
		q.offer(new int[] {r, c});
		visited[r][c] = true;
		cnt++;
		width = 0;
		
		while (!q.isEmpty()) {
			int[] arr = q.poll();
			width++;
			
			for(int d=0; d<4; d++) {
				int nr = arr[0]+dr[d];
				int nc = arr[1]+dc[d];
				
				if (nr<0 || nr>=n || nc<0 || nc>=m) {
					continue;
				}
				if (visited[nr][nc]) {
					continue;
				}
				if (graph[nr][nc]==1) {
					visited[nr][nc] = true;
					q.add(new int[] {nr, nc});
				}
				
			}
		}
		max = Math.max(max, width);
		
	}
	
	
	// dfs
	static void dfs(int r, int c) {
		visited[r][c] = true;
		graph[r][c] = 2;
		width++;
		
		for(int d=0; d<4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if (nr>=0 && nr<n && nc>=0 && nc<m && !visited[nr][nc] && graph[nr][nc]==1) {
				
				dfs(nr, nc);
			}
		}
	}

}
