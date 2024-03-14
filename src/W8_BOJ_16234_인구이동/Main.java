package W8_BOJ_16234_인구이동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int n, L, R;
	static int[][] population;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int sum;
	static List<Integer> list;
//	static int days;

	public static void main(String[] args) throws IOException {
		/* 문제) 인구 이동
		 * 국경선을 공유하는 두 나라의 인구 차이가 L명 이상, R명 이하라면, 두 나라가 공유하는 국경선을 오늘 하루 동안 연다.
		 * 위의 조건에 의해 열어야하는 국경선이 모두 열렸다면, 인구 이동을 시작한다.
		 * 국경선이 열려있어 인접한 칸만을 이용해 이동할 수 있으면, 그 나라를 오늘 하루 동안은 연합이라고 한다.
		 * 연합을 이루고 있는 각 칸의 인구수는 (연합의 인구수) / (연합을 이루고 있는 칸의 개수)가 된다. 편의상 소수점은 버린다.
		 * 연합을 해체하고, 모든 국경선을 닫는다.
		 * 
		 * 각 나라의 인구수가 주어졌을 때, 인구 이동이 며칠 동안 발생하는지 구하는 프로그램을 작성하시오.
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		population = new int[n][n];
		visited = new boolean[n][n];
		
		list = new ArrayList<>();
		
		// 인구 수 입력받아서 저장
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				population[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		
		System.out.println(move());
		System.out.println(list);
		
	}

	// dfs 탐색하면서 국경선 열 수 있는지 확인
	static void dfs(int r, int c) {
		if (r<0 || r>=n || c<0 || c>=n) return;
		
		for(int d=0; d<4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			// 범위 안에 있고, 차가 조건에 부합하다면 방문 표시
			if (nr>=0 && nr<n && nc>=0 && nc<n) {
				int diff = Math.abs(population[r][c]-population[nr][nc]);
				if (L <= diff && R >= diff) {
					visited[r][c] = true;
					list.add(population[r][c]);
					
					// 이미 방문한 곳이면 넘어가기
					if (!visited[nr][nc]) {
						dfs(nr, nc);
					}
				}
			}
		}
	}
	
	static int move() {
		int days = 0;
		while(true) {
			boolean check = false;
			visited = new boolean[n][n];
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(!visited[i][j]) {
						dfs(i, j);
						if (list.size()>1) {
							for(int x : list) {
								sum += x;
							}
							int avg = sum/list.size();
							population[i][j] = avg;
							check = true;
						}
					}
				}
			}
			if (!check) {
				return days;
			}
			days++;
			
			
			
		}
		
		
	}

}
