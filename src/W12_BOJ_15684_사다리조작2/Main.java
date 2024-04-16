package W12_BOJ_15684_사다리조작2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, m, h;	// 세로선, 가로선, 가로선 개수
	static int[][] ladder;
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		/* 문제) 15684_사다리조작
		 * 
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		ladder = new int[h+1][n+1];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			ladder[a][b] = 1;
		}
		
		for(int i=0; i<=3; i++) {
			dfs(1, 0, i);
		}
		
		if (answer==Integer.MAX_VALUE) {
			answer = -1;
		}
		System.out.println(answer);
		
	}
	
	static void dfs(int r, int cnt, int size) {
		if (cnt == size) {
			if (go()) {
				answer = Math.min(answer, size);
			}
			return;
		}
		
		for(int i=r; i<=h; i++) {
			for(int j=1; j<n; j++) {
				if (ladder[i][j]==1 || ladder[i][j-1]==1 || ladder[i][j+1]==1) {
					continue;
				}
				ladder[i][j] = 1;
				dfs(i, cnt+1, size);
				ladder[i][j] = 0;
			}
		}
	}
	
	static boolean go() {
		for(int i=1; i<=n; i++) {
			int cur = i;
			int s = 1;
			while(s <= h) {
				if (ladder[s][cur] == 1) {
					cur++;
					s++;
				}
				else if (ladder[s][cur-1] == 1) {
					cur--;
					s++;
				}
				else {
					s++;
				}
			}
			if (i != cur) return false;
		}
		return true;
	}

}
