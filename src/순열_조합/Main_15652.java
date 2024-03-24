package 순열_조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15652 {
	
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		// N과 M (4)
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[m];

		dfs(0, 0);
		System.out.println(sb);
	}
	
	static void dfs(int cnt, int idx) {
		if (idx == m) {
			for(int x : arr) {
				sb.append(x).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=cnt; i<n; i++) {
			arr[idx] = i+1;
			dfs(i, idx+1);
		}
	}

}
