package WEEK_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13460_구슬탈출2 {
	
	static int n, m;
	static char[][] board;
	static boolean[][] visited;
	static boolean[][] Rcheck;	// visited말고 이거..? 각 좌표에 지금 빨간 구슬, 파란 구슬이 있는지 확인
	static boolean[][] Bcheck;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int cnt;
	
	static int Rr, Rc, Br, Bc;

	public static void main(String[] args) throws IOException {
		/* 문제) 구슬탈출2
		 * 
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		board = new char[n][m];
		visited = new boolean[n][m];
		
		// 지도 입력 받기
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<m; j++) {
				board[i][j] = s.charAt(j);
				// 빨간 공 좌표 저장
				if (board[i][j] == 'R') {
					Rr = i;
					Rc = j;
				}
				// 파란 공 좌표 저장
				else if (board[i][j] == 'B') {
					Br = i;
					Bc = j;
				}
			}
		}
		
		

	}
	
	
	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		visited = new boolean[n][m];
		
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<m; j++) {
//				if (board[i][j]=='.') {		// 얘를 넣으면 안되는디... R을 넣어보자 
//					q.add(new int[] {i, j});
//				}
//			}
//		}
		
		q.add(new int[] {Rr, Rc, 0});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int d=0; d<4; d++) {
				int Rnr = cur[0]+dr[d];
				int Rnc = cur[1]+dc[d];
				int cnt = cur[2];
				
				// 테두리가 #으로 막혀있으니까
				if (Rnr>0 && Rnr<n-1 && Rnc>0 && Rnc<m-1) {
					if (board[Rnr][Rnc]=='.') {
						visited[Rnr][Rnc] = true;
						q.add(new int[] {Rnr, Rnc, cnt});
					}
					else if (board[Rnr][Rnc]=='O') {
						visited[Rnr][Rnc] = true;
						q.add(new int[] {Rnr, Rnc, cnt+1});
					}
				}
			}
		}
	}

}
