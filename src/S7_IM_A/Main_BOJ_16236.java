package S7_IM_A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_16236 {

	static int n;
	static int[][] graph;
	static int[] dr = {-1, 0, 1, 0};	// 상, 좌 먼저?
	static int[] dc = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		graph = new int[n][n];
		
		// graph에 값 입력 받아서 저장
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if (graph[i][j] == 9) {
					//bfs 호출
					
				}
			}
		}
		
	}
	
	static int bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] {x, y, 0});	// 큐에 현재 좌표와 이동 거리 추가
		
		// 오류 피하기 용...
		return 0;
		
	}

}
