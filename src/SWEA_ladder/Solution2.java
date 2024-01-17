package SWEA_ladder;

import java.util.Scanner;

public class Solution2 {

	public static void main(String[] args) {
		
Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] arr = new int[100][100];
		
		// 좌우 탐색
		int[] dr = {-1, 0, 0};
		int[] dc = {0, -1, 1};
		
		int x = 99;	// x좌표 
		int y = 0;	// y좌표
		
		// 배열 요소 입력받기
		for(int r=0; r<100; r++) {
			for(int c=0; c<100; c++) {
				arr[r][c] = sc.nextInt();
				if (arr[99][c] == 2) {
					x = c;
				}
			}
		}
		
		while (y != 0) {
			for (int d=0; d<3; d++) {
				int nr = x+dr[d];
				int nc = y+dc[d];
				
				if (nr>=0 && nr<100 && nc>=0 && nc<100) {
					x = nr;
					y = nc;
					arr[nr][nc] = 0;
				}
				else continue;
			}
		}
		
		System.out.printf("#%d %d", n, x);
		
	}

}
