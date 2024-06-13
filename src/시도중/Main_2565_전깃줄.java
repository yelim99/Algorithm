package 시도중;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2565_전깃줄 {

	public static void main(String[] args) throws IOException {
		/* 문제) 2565_전깃줄
		 * 
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int[][] lines = new int[n][2];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<2; j++) {
				lines[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		

	}

}
