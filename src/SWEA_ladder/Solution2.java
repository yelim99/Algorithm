package SWEA_ladder;

import java.util.Scanner;

public class Solution2 {
	
	static int[] dx = {-1, 1};	// 좌, 우
	static boolean road;	// 길인지 체크
	static int[][] arr = new int[100][100];
	
	// 시작점 찾는 메소드
	// 뒤에서부터 올라오고, y가 0일 경우 벗어난다.
	public static int searchStart(int y, int x) {
		while(true) {
			if (y==0) break;
			road = false;
			for(int d=0; d<2; d++) {
				int nx = x+dx[d];
				if (nx<0 || nx>=100) continue;
				
				// 길이 있다면
				if (arr[y][nx] == 1) {
					road = true;
					x = nx;		// 이동
					while (true) {
						nx = x+dx[d];
						// 범위를 벗어나거나 길이 아닌 경우 break
						if (nx<0 || nx>=100 || arr[y][nx]==0) break;
						else x = nx;	// 이동
					}
				}
				if (road) break;
			}
			y--;	// 행 하나 위로 올라가기
		}
		return x;
	}

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int test;
		int result = 0;
			
		for(int t=1; t<=10; t++) {
			test = sc.nextInt();
			// 배열 값 입력받기
			for(int i=0; i<100; i++) {
				for(int y=0; y<100; y++) {
					arr[i][y] = sc.nextInt();
				}
			}
		
			// 반복문 돌며 맨 마지막 행에 2 값을 체크(도착점)
			// 거기서부터 시작 - 메소드 호출
			for(int i=0; i<100; i++) {
				if (arr[99][i] == 2) {
					result = searchStart(99, i);
					break;
				}
			}
			
			System.out.printf("#%d %d\n", test, result);
		}
		
	}

}
