package W7_BOJ_1939_중량제한;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		/* 문제) 중량제한
		 * 
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] graph = new int[n+1][n+1];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a][b] = c;
			graph[b][a] = c;
		}
		
		st = new StringTokenizer(br.readLine());
		int f1 = Integer.parseInt(st.nextToken());
		int f2 = Integer.parseInt(st.nextToken());
		
		int max = 0;
		
		
		
		System.out.println(max);

	}

}
