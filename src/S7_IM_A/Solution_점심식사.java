package S7_IM_A;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution_점심식사 {
	
	static class People {
		int r, c;
		
		public People(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static class Stair {
		int r, c, h;	// 좌표, 계단 높이
		
		public Stair(int r, int c, int h) {
			this.r = r;
			this.c = c;
			this.h = h;
		}
	}
		
	static int n;
	static int[][] map;
	static People[] p;
	static Stair[] s;
	static int pCnt;
	static int[] sel;
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			n = sc.nextInt();
			
			map = new int[n][n];
			pCnt = 0;
			int sCnt = 0;
			
			p = new People[10];
			s = new Stair[2];
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					map[i][j] = sc.nextInt();
					
					if (map[i][j] == 1) {
						p[pCnt++] = new People(i, j);
					}
					else if (map[i][j] >= 2) {
						s[sCnt++] = new Stair(i, j, map[i][j]);
					}
				}
			}
			
			sel = new int[pCnt];
			ans = Integer.MAX_VALUE;
			
			dfs(0);
			System.out.printf("#%d %d%n", t, ans);
			
			
		}	// 테케 끝
		
	}
	
	// 어느 계단으로 갈 지 구하는 경우의 수
	static void dfs(int idx) {
		if (idx == pCnt) {
			// 메소드 호출
			solve();
			return;
		}
		
		for(int i=0; i<2; i++) {
			sel[idx] = i;	// 각 사람이 어느 계단을 이용했는지 저장(0번 계단, 1번 계단)
			dfs(idx+1);
		}
		
	}
	
	// 시간 계산하는 메소드
	static void solve() {
		PriorityQueue<Integer> pq0 = new PriorityQueue<>();
		PriorityQueue<Integer> pq1 = new PriorityQueue<>();
		
		// 우선순위 큐에 각 계단으로 가는 사람들 계단까지의 거리 저장해주기
		for(int i=0; i<pCnt; i++) {
			if (sel[i] == 0) {
				pq0.add(Math.abs(p[i].r-s[0].r) + Math.abs(p[i].c-s[0].c));
			}
			else {
				pq1.add(Math.abs(p[i].r-s[1].r) + Math.abs(p[i].c-s[1].c));
			}
		}
		
		int people = pCnt;	// 남은 사람들 
		int[] s0 = new int[3];
		int[] s1 = new int[3];
		
		int time = 0;
		
		while(true) {
			// 남은 사람이 없을 때
			if (people==0) {
				boolean check = true;
				
				for(int i=0; i<3; i++) {
					// 0번 계단이 에 사람이 있으면 false
					if (s0[i] != 0) {
						check = false;
						break;
					}
					// 1번 계단에 사람이 있으면 false
					if (s1[i] != 0) {
						check = false;
						break;
					}
				}
				// 사람이 없으면 다 끝! while문 벗어나
				if (check) break;
			}
			
			// 남은 사람이 있으면
			for(int i=0; i<3; i++) {
				// 0번 계단 비어있으면
				if (s0[i] == 0) {
					// 0번 큐가 비어있지 않고 (사람이 있고)
					if (!pq0.isEmpty()) {
						// 계단입구에 왔다면
						if (pq0.peek() <= time) {
							people--;
							s0[i] = s[0].h;	// 0번 계단의 이동시간
							pq0.poll();
						}
					}
				}
				// 계단이 사용 중일 때
				else {
					s0[i]--;	// 이용시간 줄이
					if (s0[i] == 0) {
						// 0번 큐가 비어있지 않고 (사람이 있고)
						if (!pq0.isEmpty()) {
							// 계단입구에 왔다면
							if (pq0.peek() <= time) {
								people--;
								s0[i] = s[0].h;	// 0번 계단의 이동시간
								pq0.poll();
							}
						}
					}
				}
				
				// 	1번 계단 비어있으
				if (s1[i] == 0) {
					if(s1[i] == 0) {
						if (!pq1.isEmpty()) {
							if (pq1.peek() <= time) {
								people--;
								s1[i] = s[1].h;
								pq1.poll();
							}
						}
					}
				}
				else {
					s1[i]--;
					if(s1[i] == 0) {
						if (!pq1.isEmpty()) {
							if(pq1.peek() <= time) {
								people--;
								s1[i] = s[1].h;
								pq1.poll();
							}
						}
					}
				}
			}	// 남은 사람이 있을 때 for 끝
			
			time++;
			
		}
		
		ans = Math.min(time, ans);
		
	}

}
