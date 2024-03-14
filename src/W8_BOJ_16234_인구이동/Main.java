package W8_BOJ_16234_인구이동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int n, l, r;
	static int[][] population;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int sum;
	static List<Integer> list;

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
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
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
		
		
		
		

	}
	
	static void move() {
		
		while(true) {
			boolean check = false;
			
			
			
		}
		
		
	}
	
	static void search(int r, int c) {
		for(int d=0; d<4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if (nr>=0 && nr<n && nc>=0 && nc<n) {
				if (l <= Math.abs(population[r][c]-population[nr][nc]) 
					&& r >= Math.abs(population[r][c]-population[nr][nc])) {
					visited[r][c] = visited[nr][nc] = true;
					list.add(population[nr][nc]);
					search(nr, nc);
				}
			}
		}
	}

}
