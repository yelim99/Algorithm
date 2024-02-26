package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_4613 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			char[][] arr = new char[n][m];
			
			// 각 행 별 내 색깔이 몇 개인지 저장해줄 배열
			int[] w = new int[n];
			int[] b = new int[n];
			int[] r = new int[n];
			
			// 배열에 색깔 값 저장하고 각 행의 본인 색 개수 세서 저장
			for(int i=0; i<n; i++) {
				String s = sc.next();
				for(int j=0; j<m; j++) {
					char c = s.charAt(j);
					arr[i][j] = c;
					if (c == 'W') {
						w[i]++;
					}
					else if (c == 'B') {
						b[i]++;
					}
					else {
						r[i]++;
					}
				}
			}
			
			int wCnt = 0;
			int bCnt = 0;
			int rCnt = 0;
			
			int total = 0;
			int min = Integer.MAX_VALUE;
			
			for(int i=0; i<n-2; i++) {
				wCnt += (m-w[i]);
				bCnt = 0;
				for(int j=i+1; j<n-1; j++) {
					bCnt += (m-b[j]);
					rCnt = 0;
					for(int k=j+1; k<n; k++) {
						rCnt += (m-r[k]);
					}
					total = wCnt+bCnt+rCnt;
					if (total<min) {
						min = total;
					}
				}
			}
			
			System.out.println(min);
			
		}

	}

}
