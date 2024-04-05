package S7_IM_A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution_2105 {
	
	static int n;
	static int[][] map;
	static int[] dr = {1, 1, -1, -1};
	static int[] dc = {1, -1, -1, 1};
	static boolean[][] visited;
	static List<Integer> sel;
	static int max;
	static int firstR;
	static int firstC;

	public static void main(String[] args) {
		/* 문제) 디저트 카페
		 * 
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			n = sc.nextInt();
			
			map = new int[n][n];
			
			// 지도 입력 받기
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			// 최대값 0으로 초기화
			max = 0;
			
			// 사각형 만들려면 아래 2칸, 옆은 한 칸 여유 있어야 함.
			// 범위 정해주고 사각형 만들 수 있는 행, 열까지 반복 돌면서 dfs 호출
			for(int i=0; i<n-2; i++) {
				for(int j=0; j<n-1; j++) {
					
					// 처음 좌표 저장
					firstR = i;
					firstC = j;
					
					visited = new boolean[n][n];
					sel = new ArrayList<>();	// 방문한 숫자 저장할 리스트
					visited[i][j] = true;	// 방문 체크
					sel.add(map[i][j]);	// 현재 좌표 숫자 저장
					
					// dfs 호출
					dfs(1, i, j, 0);
					
				}
			}
			
			// 가능한 경로가 없으면 -1 저장
			if (max == 0) max = -1;
			
			System.out.printf("#%d %d%n", t, max);
			
		}	// 테케 끝

	}
	

	// dfs 메소드(탐색한 좌표 개수, 좌표, 이동방향)
	static void dfs(int cnt, int r, int c, int dir) {
		
		// 이동 방향이 방금 이동한 방향과 같거나, 그 다음 방향이어야 함. (우하-좌하-좌상-우상)
		for(int d=dir; d<4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			// 범위 내에 있을 때
			if (nr>=0 && nr<n && nc>=0 && nc<n) {
				// 처음 좌표와 같고(사각형 만들고 다시 돌아옴), 최소 3번이상 탐색했으면 최대값 비교 후 리턴
				if (nr == firstR && nc == firstC && cnt > 2) {
					max = Math.max(max, cnt);
					return;
				}
				
				// 방문한 적이 없고, sel에 저장된 숫자와 겹치지 않으면
				if (!visited[nr][nc] && !sel.contains(map[nr][nc])) {
					visited[nr][nc] = true;		// 방문체크
					sel.add(map[nr][nc]);		// sel에 숫자 저장
					dfs(cnt+1, nr, nc, d);		// dfs(탐색횟수+1, 좌표, 이동방향)
					visited[nr][nc] = false;	// 방문 초기화
					sel.remove(sel.size()-1);	// sel에서 값 빼주기(초기화)
				}
			}
			
		}
		
	}
	
	

}
