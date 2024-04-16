package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2178_미로탐색 {

	static int n, m;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int cnt;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		/* 문제) 2178_미로탐색
		 * 
		 */
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			String s = sc.next();
			for(int j=0; j<m; j++) {
				map[i][j] = s.charAt(j)-48;
			}
		}
		
		cnt = 0;
		
		bfs(0, 0);
		visited[0][0] = true;
		
		System.out.println(map[n-1][m-1]);

	}
	
	static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		
		
		q.add(new int[] {r, c});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int d=0; d<4; d++) {
				int nr = cur[0]+dr[d];
				int nc = cur[1]+dc[d];
				
				if (nr>=0 && nr<n && nc>=0 && nc<m) {
					if (!visited[nr][nc] && map[nr][nc] == 1) {
						cnt++;
						visited[nr][nc] = true;
						q.add(new int[] {nr, nc});
						map[nr][nc] = map[cur[0]][cur[1]]+1;
					}
				}
			}
		}
		
	}

}
