package W9_BOJ_2146_다리만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[][] map;
	static boolean[][] visited;
	static boolean[][] Qvisited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int num = 1;
	static int cnt;
	static int ans;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		/* 문제) 다리 만들기
		 * 
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		visited = new boolean[n][n];
		
		// 지도 입력받기
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if (!visited[i][j] && map[i][j]==1) {
					search(i, j);
					num++;
					visited = new boolean[n][n];
				}
			}
		}
		

		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}

		System.out.println(ans);
		
	}
	
	static void search(int r, int c) {
		visited[r][c] = true;
		map[r][c] = 2;
		
		for(int d=0; d<4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if (nr>=0 && nr<n && nc>=0 && nc<n) {
				if (!visited[nr][nc] && map[nr][nc]==1) {
					map[nr][nc] = 2;
					visited[nr][nc] = true;
					search(nr, nc);
				}
				else if (map[nr][nc]==0) {
					// 여기서 bfs??
//					ans = bfs(r, c);
//					map[r][c] = 1;
					ans = bfs(r, c);
				}
			}
		}
		
		
	}
	

	
	static int bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
//		visited = new boolean[n][n];
		
		// 하나씩 최소,,, 구하기?? 초기화하면서??
		
		int length = 0;
		
		q.offer(new int[] {r, c, length});
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int d=0; d<4; d++) {
				int nr = cur[0]+dr[d];
				int nc = cur[1]+dc[d];
				
				if (nr>=0 && nr<n && nc>=0 && nc<n) {
					if (!visited[nr][nc] && map[nr][nc]==0) {
						length++;
						map[nr][nc] = 7;
						q.add(new int[] {nr, nc, length});
						visited[nr][nc] = true;
					}
//					System.out.println(num+1);
					if (map[nr][nc]==2) {
//						System.out.println(99);
						cnt++;
//						min = Math.min(min, cnt);
						return cur[2];
					}
				}
			}
		}
		return length;
		// 왜자꾸 0이 나오지
		
	}

}
