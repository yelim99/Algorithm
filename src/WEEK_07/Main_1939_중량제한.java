package WEEK_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main_1939_중량제한 {
	
	static int n, m;
	static int start, end;
	static List<List<bridge>> graph = new ArrayList<>(); 
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		/* 문제) 중량제한
		 * 각각의 다리마다 중량제한이 있기 때문에 무턱대고 물품을 옮길 순 없다. 
		 * 한 번의 이동에서 옮길 수 있는 물품들의 중량의 최댓값을 구하는 프로그램을 작성하시오.
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<>());
		}
		
		int left = Integer.MAX_VALUE;
		int right = 0;
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new bridge(b, w));
			graph.get(b).add(new bridge(a, w));
			
			// 최대, 최소값 저장
			right = Math.max(right, w);
			left = Math.min(left, w);
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		// 이분탐색
		while (left <= right) {
			int mid = (left+right)/2;
			visited = new boolean[n+1];
			
			if (bfs(mid)) {
				left = mid+1;
				ans = mid;
			}
			else {
				right = mid-1;
			}
		}

		System.out.println(ans);
		
	}
	
	// 연결 확인
	static boolean bfs(int limit) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			// 도착점까지 갔다면 연결되어 있음. true 반환
			if (cur == end) {
				return true;
			}
			
			for(int i=0; i<graph.get(cur).size(); i++) {
				if (graph.get(cur).get(i).weight >= limit && !visited[graph.get(cur).get(i).go]) {
					visited[graph.get(cur).get(i).go] = true;
					q.add(graph.get(cur).get(i).go);
				}
			}
		}
		return false;
	}
	

	static class bridge {
		int go;
		int weight;
		
		public bridge(int go, int weight) {
			this.go = go;
			this.weight = weight;
		}
	
	}
	

}

