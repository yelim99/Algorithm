package W11_BOJ_23288_주사위굴리기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {0, 1, 0, -1};	// 우 하 좌 상
	static int[] dc = {1, 0, -1, 0};
	// 주사위 저장 배열?
	
	static int sum;

	public static void main(String[] args) throws IOException {
		/* 문제)
		 * 
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

	}
	
	static void check(int r, int c, int dir) {
		
	}

}
