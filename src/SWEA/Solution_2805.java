package SWEA;

import java.util.Scanner;

public class Solution_2805 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int n = sc.nextInt();
//			sc.nextLine();
			
			int[][] arr = new int[n][n];
			
			for(int i=0; i<n; i++) {
				String s = sc.next();
				for(int j=0; j<n; j++) {
					arr[i][j] = s.charAt(j)-'0';
				}
			}
			
			int sum = 0;
			int left = n/2;
			int right = n/2;
			
			for(int i=0; i<n; i++) {
				for(int j=left; j<=right; j++) {
					sum += arr[i][j];
				}
				if (i<n/2) {
					left--;
					right++;
				}
				else {
					left++;
					right--;
				}
			}
			
			System.out.printf("#%d %d%n", t, sum);
			
		}

	}

}
