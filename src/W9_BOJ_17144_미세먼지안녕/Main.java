package W9_BOJ_17144_미세먼지안녕;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int R, C, t;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] copied;
	static int airR;

	public static void main(String[] args) throws IOException {
		/* 문제) 미세먼지 안녕!
		 * 
		 */ 
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		visited = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) {
					airR = i;	// 공기청정기가 있는 행 저장 (아래행이 저장되겠쥬)
				}
			}
		}
		
		
		for(int i=0; i<t; i++) {
			copied = new int[R][C];
			for(int j=0; j<R; j++) {
				copied[j] = map[j].clone();
			}
			bfs();
			move(airR);
		}
		
		int sum = 0;
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] != -1) {
					sum+=map[i][j];
				}
			}
		}
		
		System.out.println(sum);

	}
	
	
	// 미세먼지 확산
	static void bfs() {
		Queue<Dust> q = new LinkedList<>();
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if (copied[i][j] > 0) {
					q.offer(new Dust(i, j, copied[i][j]));
				}
			}
		}
		
		while(!q.isEmpty()) {
			Dust cur = q.poll();
			int cnt = 0;
			
			for(int d=0; d<4; d++) {
				int nr = cur.x+dr[d];
				int nc = cur.y+dc[d];
				
				if (nr>=0 && nr<R && nc>=0 && nc<C) {
					if (map[nr][nc]!=-1) {
						cnt++;
						map[nr][nc] += cur.dust/5;
					}
				}
			}
			map[cur.x][cur.y] -= (cur.dust/5) * cnt; 
		}
		
		
	}
	
	
	// 공기청정기 작동
	static void move(int air) {
		int upAir = air-1;	// 공기청정기 윗부분 행
		
		for(int i=upAir-1; i>0; i--) {
			map[i][0] = map[i-1][0];
		}
		for(int i=0; i<C-1; i++) {
			map[0][i] = map[0][i+1];
		}
		for(int i=0; i<upAir; i++) {
			map[i][C-1] = map[i+1][C-1];
		}
		for(int i=C-1; i>0; i--) {
			map[upAir][i] = map[upAir][i-1];
		}
		
		// 공기청정기 들어갔다 나와서 정화됨
		map[upAir][1] = 0;
		
		
		// 아랫부분
		for(int i=air+1; i<R-1; i++) {
			map[i][0] = map[i+1][0];
		}
		for(int i=0; i<C-1; i++) {
			map[R-1][i] = map[R-1][i+1];
		}
		for(int i=R-1; i>air; i--) {
			map[i][C-1] = map[i-1][C-1]; 
		}
		for(int i=C-1; i>0; i--) {
			map[air][i] = map[air][i-1];
		}
		
		map[air][1] = 0;
	}

	
	static class Dust {
		int x;
		int y;
		int dust;
		
		public Dust(int x, int y, int dust) {
			this.x = x;
			this.y = y;
			this.dust = dust;
		}
	}
}
