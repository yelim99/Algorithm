package 순열_조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15656 {
	
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int[] arr;
	static int[] sel;

	public static void main(String[] args) throws IOException {
		// N과 M (7)
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		arr = new int[n];
		sel = new int[m];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		dfs(0);
		System.out.println(sb);

	}
	
	static void dfs(int idx) {
		if (idx==m) {
			for(int x : sel) {
				sb.append(x).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<n; i++) {
			sel[idx] = arr[i];
			dfs(idx+1);
		}
	}

}
