package SWEA_ladder;

import java.util.Scanner;

public class Ladder1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] arr = new int[100][100];
		
		// 배열 요소 입력받기
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		int start = 0;	// 출발 지점 저장 변수
		
		// 좌우 탐색
		int[] dc = {-1, 1};
		
		int x = 0;	// 현재 위치 x좌표 
		int y = 0;	// 현재 위치 y좌표
		
		/* 시작점 x가 1일 때 [0][r] == 1
		좌우 탐색해서 1인 경우 이동. 0일 때까지 이동
		다음이 0이면 이동 중지, 아래로 이동.
		아래로 이동하면서 좌우 탐색, 1이면 또 0일 때까지 이동
		반복
		마지막 행에서 2인 경우 끝
		*/
		
		for (int c=0; c<100; c++) {
			if (arr[0][c] == 1) {
				start = c;
				x = c;
				for (int r=c; r<100; r++) {
					y = r;
					for (int d=0; d<2; d++) {		// 좌우 탐색
						int nc = c+dc[d];			// nr 없어도??
						
						if (r>=0 && r<100 && nc>=0 && nc<100) {
							if (arr[r][nc] == 1) {		// 좌우 탐색했을 때 1이면
								if (nc < c) {			// 1인 곳의 x좌표가 현재 x좌표보다 작으면
									x -= 1;				// 현재 좌표 1빼기
								} else {				// 아니면
									x += 1;				// 현재 좌표 1 더하기
								}
							} else if (arr[r][nc] == 0) {		// 0이면
								y += 1;		// 현재 y좌표 1 더하기
							}
							
							
						}
						
						
					}
				}
				if (arr[x][y] == 2) break;
			}
		}
		
		
		System.out.printf("#%d %d", n, start);
		
		
//		while (x < 100) {
//			for(int r=0; r<100; r++) {
//				for(int c=0; c<100; c++) {
//					if (arr[0][c] == 1) {
//						for(int d=0; d<99; d++) {
//							int nr = r+dr[d];
//							int nc = c+dc[d];
//							
//							if (arr[nr][nc] == 1) {
//								
//							}
//						}
//					}
//				}
//			}
//		}

	}

}
