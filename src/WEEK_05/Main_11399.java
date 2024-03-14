package WEEK_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11399 {

	public static void main(String[] args) throws IOException {
		/* 문제) ATM
		 * 줄을 서 있는 사람의 수 N과 각 사람이 돈을 인출하는데 걸리는 시간 Pi가 주어졌을 때, 
		 * 각 사람이 돈을 인출하는데 필요한 시간의 합의 최솟값을 구하는 프로그램을 작성하시오.
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[n];
		int[] sum = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		sum[0] = arr[0];
		int ans = sum[0];
		
		for(int i=1; i<n; i++) {
			sum[i] = sum[i-1]+arr[i];
			ans += sum[i];
		}
		
		System.out.println(ans);
		
	}

}
