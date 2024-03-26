package W9_BOJ_16236_아기상어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
	
	static int n;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int time;

	public static void main(String[] args) throws IOException {
		/* 문제) 아기 상어
		 * 
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		visited = new boolean[n][n];
		
		// 입력 받기
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		
		System.out.println(time);
		

	}
	
	static void bfs() {
		Queue<Shark> q = new LinkedList<>();
		visited = new boolean[n][n];
		int cnt = 0;	// 같은 사이즈 물고기
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if (map[i][j]==9) {
					q.offer(new Shark(i, j, 2));
				}
			}
		}
		
		while(!q.isEmpty()) {
			Shark cur = q.poll();
			
			for(int d=0; d<4; d++) {
				int nr = cur.r+dr[d];
				int nc = cur.c+dc[d];
				
				if (nr>=0 && nr<n && nc>=0 && nc<n) {
					if (!visited[nr][nc] && map[nr][nc]<=cur.size) {
						// 상어의 크기보다 작은 물고기면 잡아먹기
						if (map[nr][nc]!=0 && cur.size>map[nr][nc]) {
							time++;
							cnt++;
							map[nr][nc] = 0;
							visited[nr][nc] = true;
							q.add(new Shark(nr, nc, cur.size));
						}
						// 크기가 같은 물고기면 지나가
						else if (map[nr][nc]==0 || cur.size==map[nr][nc]) {
							time++;
							visited[nr][nc] = true;
							q.add(new Shark(nr, nc, cur.size));
						}
					}
				}
				
				if (cnt==cur.size) {
					cur.size++;
					cnt = 0;
				}
			}
		}	// while 끝
		
	}
	
	
	static class Shark {
		int r;
		int c;
		int size;
		
		public Shark(int r, int c, int size) {
			this.r = r;
			this.c = c;
			this.size = size;
		}
	}

}
