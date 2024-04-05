package S7_IM_A;

import java.util.Scanner;

public class Solution_1215_회문1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			int n = sc.nextInt();
//			sc.nextLine();

			char[][] arr = new char[8][8];
			for (int i = 0; i < 8; i++) {
				String s = sc.next();
				for (int j = 0; j < 8; j++) {
					arr[i][j] = s.charAt(j);
				}
			}

			int cnt = 0;
			boolean check = true;

			// 가로
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8 - n + 1; j++) {
					check = true;
					for (int k = 0; k < n/2; k++) {	// 반만 찾으면 됨
						if (arr[i][j+k] != arr[i][j-k+n-1]) {
							check = false;
						}
					}
					if (check)
						cnt++;
				}
			}

			// 세로
			for (int i = 0; i < 8-n+1; i++) {
				for (int j = 0; j < 8; j++) {
					check = true;
					for (int k = 0; k < n/2; k++) {
						if (arr[i+k][j] != arr[i-k+n-1][j]) {
							check = false;
						}
					}
					if (check)
						cnt++;
				}
			}
			
			System.out.printf("#%d %d%n", t, cnt);

		} // 테케 끝

	}

}
