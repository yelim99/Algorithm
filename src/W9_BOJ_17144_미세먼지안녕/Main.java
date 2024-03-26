package W9_BOJ_17144_미세먼지안녕;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int R, C, t;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int cnt;
	static int[][] copied;

	public static void main(String[] args) throws IOException {
		/* 문제)
		 * 
		 */ 
		
		/*
3 3 1
0 30 7
-1 10 0
-1 0 20 
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		arr = new int[R][C];
		visited = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		copied = new int[R][C];
		for(int i=0; i<R; i++) {
			copied[i] = arr[i].clone();
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if (!visited[i][j] && copied[i][j] > 0) {
					bfs(i, j, copied[i][j]);
//					dfs(i, j);
				}
			}
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}

	}
	
	static void dfs(int r, int c) {
		visited[r][c] = true;
		
		for(int d=0; d<4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if (nr>=0 && nr<R && nc>=0 && nc<C) {
				if (!visited[nr][nc] && arr[nr][nc]!=-1) {
					cnt++;
					arr[nr][nc] += copied[r][c]/5;
					arr[r][c] -= copied[r][c]/5;
//					visited[nr][nc] = true;
					dfs(nr, nc);
				}
			}
		}
	}
	
	// 미세먼지 확산
	static void bfs(int r, int c, int quan) {
		Queue<Dust> q = new LinkedList<>();
		q.offer(new Dust(r, c, quan));
		
		visited = new boolean[R][C];
		
		while(!q.isEmpty()) {
			Dust cur = q.poll();
			
			for(int d=0; d<4; d++) {
				int nr = cur.x+dr[d];
				int nc = cur.y+dc[d];
				
				if (nr>=0 && nr<R && nc>=0 && nc<C) {
					if (!visited[nr][nc] && arr[nr][nc]!=-1) {
						cnt++;
						arr[nr][nc] += cur.w/5;
						arr[cur.x][cur.y] -= cur.w/5; 
						visited[nr][nc] = true;
						q.add(new Dust(nr, nc, copied[nr][nc]));
					}
				}
			}
		}
		
		
	}

	
	static class Dust {
		int x;
		int y;
		int w;
		
		public Dust(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}
	}
}
