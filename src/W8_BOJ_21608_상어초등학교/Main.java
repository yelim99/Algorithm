package W8_BOJ_21608_상어초등학교;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[][] seat;
	static int[][] like;
	static int[][] empty;
	static int sum;
	static int[] order;	// 순서?
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		/* 문제) 상어초등학교
		 * 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
		 * 1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
		 * 2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 
		 * 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.
		 * 
		 *  학생의 만족도는 자리 배치가 모두 끝난 후에 구할 수 있다. 
		 *  학생의 만족도를 구하려면 그 학생과 인접한 칸에 앉은 좋아하는 학생의 수를 구해야 한다. 
		 *  그 값이 0이면 학생의 만족도는 0, 1이면 1, 2이면 10, 3이면 100, 4이면 1000이다.
		 *  학생의 만족도의 총 합을 구해보자.
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		seat = new int[n][n];
		like = new int[n][n];
		empty = new int[n][n];
		order = new int[n*n];
		
		// 좋아하는 학생 입력 받아서 저장
		for(int i=0; i<n*n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<4; j++) {
				int x = Integer.parseInt(st.nextToken());
				order[i] = x;
				like[x][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 맨 처음 값은 무조건 1,1이네! 상하좌우 비어있고, 행, 열 최소 값!
		seat[1][1] = order[0];
		
		// 요 다음부터 좋아하는 학생부터 검사해줘야해!

	}
	
	static void search(int r, int c) {
		int likeCnt = 0;
		for (int d=0; d<4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if (nr>=0 && nr<n*n && nc>=0 && nc<n*n) {
				// 자리에 좋아하는 학생이 있는지
				for (int i=0; i<4; i++) {
					if (like[seat[r][c]][i] == seat[nr][nc]) {
						likeCnt++;
					}
				}
			}
		}
	}

}
