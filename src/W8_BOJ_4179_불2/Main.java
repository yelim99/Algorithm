package W8_BOJ_4179_불2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int r, c;
	static char[][] map;
	static boolean[][] visited;
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		/* 문제) 불!
		 * 불은 매 분마다 네 방향으로 확산
		 * 지훈이는 미로의 가장자리에 접한 공간에서 탈출
		 * 지훈이와 불은 벽이 있는 공간은 통과하지 못함.
		 * 
		 * #: 벽
		 * .: 지나갈 수 있음
		 * J: 지훈이 초기위치
		 * F: 불이 난 공간
		 * 
		 * 가장 빠른 탈출시간 출력
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
//		st = new StringTokenizer(br.readLine());
		
		map = new char[r][c];
		int ans = 0;
		
		for(int i=0; i<r; i++) {
			String s = br.readLine();
			for(int j=0; j<c; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if (map[i][j] == 'J') {
					// bfs 호출
					ans = moveBfs(i, j);
				}
				else if (map[i][j] == 'F') {
					// bfs 호출
					fireBfs(i, j);
				}
				
				for(int a=0; a<r; a++) {
					for(int b=0; b<c; b++) {
						System.out.print(map[a][b]);
					}
					System.out.println();
				}
				System.out.println("------------");
			}
		}
		
		
		
		if (ans==0) {
			System.out.println("IMPOSSIBLE");
		}
		else {
			System.out.println(ans);
		}
	
	}
	
	static int moveBfs(int x, int y) {
		visited = new boolean[r][c];
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] {x, y, 0});
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int d=0; d<4; d++) {
				int nr = cur[0]+dr[d];
				int nc = cur[1]+dc[d];
				int var = cur[2];
				
				if (nr<0 || nr>=r || nc<0 || nc>=c) continue;
				if (visited[nr][nc]) continue;
				if (map[nr][nc]=='#' || map[nr][nc]=='F') continue;
				if (nr==0 || nr==r-1 || nc==0 || nc==c-1) {
					return var+1;
				}
				visited[nr][nc] = true;
				q.add(new int[] {nr, nc, var+1});
			}
		}
		return 0;
	}
	
	
	static void fireBfs(int x, int y) {
		visited = new boolean[r][c];
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] {x, y});
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int d=0; d<4; d++) {
				int nr = cur[0]+dr[d];
				int nc = cur[1]+dc[d];
				
				if (nr<0 || nr>=r || nc<0 || nc>=c) continue;
				if (visited[nr][nc]) continue;
				if (map[nr][nc]!='#') {
					map[nr][nc] = 'F';
				}
				visited[nr][nc] = true;
				q.add(new int[] {nr, nc});
			}
		}
	}

}
