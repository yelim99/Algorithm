package SWEA;

import java.util.Scanner;

public class Solution_1974 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		tc: for(int t=1; t<=T; t++) {
			
			int[][] arr = new int[9][9];
			
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			
			int result = 1;
			
			// 행 우선순회
			for(int i=0; i<9; i++) {
				// 카운팅배열
				int[] count = new int[10];
				for(int j=0; j<9; j++) {
					count[arr[i][j]]++;
					if (count[arr[i][j]] >= 2) {
						System.out.printf("#%d %d%n", t, 0);
						continue tc;
					}
				}
			}
			
				
			// 열 우선순회
			for(int j=0; j<9; j++) {
				// 카운팅배열
				int[] count = new int[10];
				for(int i=0; i<9; i++) {
					count[arr[i][j]]++;
					if (count[arr[i][j]] >= 2) {
						System.out.printf("#%d %d%n", t, 0);
						continue tc;
					}
				}
			}
	
			// 3*3 순회
			for(int i=0; i<9; i+=3) {
				for(int j=0; j<9; j+=3) {
					int[] count = new int[10];
					
					for(int r=i; r<i+3; r++) {
						for(int c=j; c<j+3; c++) {
							count[arr[i][j]]++;
							if (count[arr[r][c]] >= 2) {
								System.out.printf("#%d %d%n", t, 0);
								continue tc;
							}
						}
					}
					
					
				}
			}
			
			System.out.printf("#%d %d%n", t, 1);
			
			
		}

	}

}
