package W6_BOJ_9663_NQueen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[] value;
//	static boolean[][] check;
	static int cnt;

	public static void main(String[] args) throws IOException {
		/* 문제) N-Queen
		 * N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.
		 * N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		value = new int[n];
		
	}
	
	static void queen(int depth) {
		if (depth == n) {
			cnt++;
			return;
		}
		
//		for(int i=0; i<n; i++) {
//			if (possible(depth)) {
//				queen(depth+1);
//			}
//		}
	}
	
//	static boolean possible(int col) {
//		for(int i=0; i<col; i++) {
//			if(value[i] == col) {
//				return false;
//			}
//			
//			// 대각선 확인
//		}
//	}

}
