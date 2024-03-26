package W9_BOJ_16236_아기상어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	
	static int n;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static Fish shark;
	static int sharkSize = 2;
	static List<Fish> foodList = new ArrayList<>();
	static int cnt = 0;	// 물고기 잡아먹은 횟수
	static int result;

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
				
				if (map[i][j]==9) {
					shark = new Fish(i, j, 0);
					map[i][j] = 0;
				}
			}
		}
		
		bfs();
		
		System.out.println(result);
		

	}
	
	static void bfs() {
		Queue<Fish> q = new LinkedList<>();
//		visited = new boolean[n][n];
		q.add(shark);
		visited[shark.r][shark.c] = true;
		
		while (true) {
			while(!q.isEmpty()) {
				Fish cur = q.poll();
				int time = cur.time;
				
				for(int d=0; d<4; d++) {
					int nr = cur.r+dr[d];
					int nc = cur.c+dc[d];
					
					if (nr>=0 && nr<n && nc>=0 && nc<n && !visited[nr][nc]) {
						// 상어의 크기보다 작은 물고기면 잡아먹기
						if (map[nr][nc]!=0 && sharkSize>map[nr][nc]) {
							visited[nr][nc] = true;
							q.add(new Fish(nr, nc, time+1));
							foodList.add(new Fish(nr, nc, time+1));
						}
						
						// 비어있거나 크기가 같은 물고기면 지나가
						else if (map[nr][nc]==0 || sharkSize==map[nr][nc]) {
							visited[nr][nc] = true;
							q.add(new Fish(nr, nc, time+1));
						}
					}
					
				}
			}	// while 끝
			
			// 물고기 잡아먹기
			if (!foodList.isEmpty()) {
//				System.out.println(1);
				eat();
				
				q.clear();
				visited = new boolean[n][n];
				
				// 현재 상어 위치 큐에 추가
				q.add(shark);
				visited[shark.r][shark.c] = true;
			}
			else {
				return;
			}
		}
		
	}
	
	static void eat() {
		// 우선순위 순으로 정렬 (시간 - 위 - 왼쪽)
		foodList.sort((o1, o2) -> {
			if (o1.time == o2.time) {
				if (o1.r == o2.r) {
					return o1.c - o2.c;
				}
				return o1.r - o2.r;
			}
			return o1.time - o2.time;
		});
		
		Fish now = foodList.get(0);

		shark.r = now.r;
		shark.c = now.c;
		// 먹은 횟수
		cnt++;
		
		if (cnt==sharkSize) {
			sharkSize++;
			cnt = 0;
		}
		
		result += now.time;
		
		map[now.r][now.c] = 0;
		foodList.clear();
	}
	
	
	static class Fish {
		int r;
		int c;
		int time;
		
		public Fish(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}

}
