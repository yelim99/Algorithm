package SWEA_ladder;

import java.util.Scanner;

public class Solution2 {
	
	static int[] dx = {-1, 1};
	static boolean road;
	static int[][] arr = new int[100][100];
	
	public static int searchStart(int y, int x) {
		while(true) {
			if (y==0) break;
			road = false;
			for(int d=0; d<2; d++) {
				int nx = x+dx[d];
				if (nx<0 || nx>=100) continue;
				if (arr[y][nx] == 1) {
					road = true;
					x = nx;
					while (true) {
						nx = x+dx[d];
						if (nx<0 || nx>=100 || arr[y][nx]==0) break;
						else x = nx;
					}
				}
				if (road) break;
			}
			y--;
		}
		return x;
	}

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int test;
		int result = 0;
			
		for(int t=1; t<=10; t++) {
			test = sc.nextInt();
			for(int i=0; i<100; i++) {
				for(int y=0; y<100; y++) {
					arr[i][y] = sc.nextInt();
				}
			}
		
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
