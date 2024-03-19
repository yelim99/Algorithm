package W8_BOJ_21608_상어초등학교;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

class Seat {
	int r;
	int c;
	int likeFriend;
	int empty;
	
	public Seat(int r, int c, int likeFriend, int empty) {
		super();
		this.r = r;
		this.c = c;
		this.likeFriend = likeFriend;
		this.empty = empty;
	}
	
	
}

public class Main {
	
	static int n;
	static int[][] seat;
	static HashMap<Integer, int[]> hash;
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
		hash = new HashMap<>();
		
		// 좋아하는 학생 입력 받아서 저장
		for(int i=0; i<n*n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int student = Integer.parseInt(st.nextToken());
			int[] like = new int[4];
			for(int j=0; j<4; j++) {
				like[j] = Integer.parseInt(st.nextToken());
			}
			// 좋아하는 친구 hash에 저장
			hash.put(student, like);
			
			// 자리 앉기
			findSeat(student);
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(seat[i][j]+" ");
			}
			System.out.println();
		}
		
		int sum = 0;
		
		
		// 점수 구하기
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int cnt = 0;
				int[] friends = hash.get(seat[i][j]);
				for(int d=0; d<4; d++) {
					int nr = i+dr[d];
					int nc = j+dc[d];
					
					if (nr>=0 && nr<n && nc>=0 && nc<n) {
						for(int x=0; x<4; x++) {
							if (seat[nr][nc] == friends[x]) {
								cnt++;
							}
						}
					}
					
					// 1명-1, 2명-10, 3명-100, 4명-1000
					switch(cnt) {
					case 1: 
						sum+=1;
						break;
					case 2:
						sum+=10;
						break;
					case 3:
						sum+=100;
						break;
					case 4: 
						sum+=1000;
						break;
					}
				}
			}
		}
		
		System.out.println(sum);
		

	}
	
	// 자리 찾는 메소드
	static void findSeat(int student) {
		int[] friends = hash.get(student);
		// 정렬을 해주기 위해 리스트에 저장
		List<Seat> seats = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				
				int likeCnt = 0;
				int emptyCnt = 0;
				for (int d=0; d<4; d++) {
					int nr = i+dr[d];
					int nc = j+dc[d];
					
					if (nr>=0 && nr<n && nc>=0 && nc<n) {
						// 자리에 좋아하는 학생이 있는지
						for (int x=0; x<4; x++) {
							if (seat[nr][nc] == friends[x]) {
								likeCnt++;
							}
						}
						
						// 빈칸인지 확인
						if (seat[nr][nc] == 0) {
							emptyCnt++;
						}
					}
				}
				seats.add(new Seat(i, j, likeCnt, emptyCnt));
			}
		}
		
		// 정렬
		// 좋아하는 학생이 많은 칸 -> 비어있는 칸이 많은 칸 -> 행 작은 칸 -> 열 작은 칸
		seats.sort((o1, o2) -> {
			if (o1.likeFriend == o2.likeFriend) {
				if (o1.empty == o2.empty) {
					if (o1.r == o2.r) {
						return o1.c - o2.c;
					}
					return o1.r - o2.r;
				}
				return o1.empty - o2.empty;
			}
			return o1.likeFriend - o2.likeFriend;
		});
		
		// 자리 넣어주기
		for(Seat s : seats) {
			if (seat[s.r][s.c] == 0) {
				seat[s.r][s.c] = student;
				return;
			}
		}
		
	}
	


}
