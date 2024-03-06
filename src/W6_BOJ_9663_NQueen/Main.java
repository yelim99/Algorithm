package W6_BOJ_9663_NQueen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[] colValue;
	static boolean[][] check;
	static int cnt;

	public static void main(String[] args) throws IOException {
		/* 문제) N-Queen
		 * N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.
		 * N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		colValue = new int[n];
		check = new boolean[n][n];
		
	}
	
	static void queen() {
		
	}

}
