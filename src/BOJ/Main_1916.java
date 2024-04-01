package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1916 {
	
	static class Edge implements Comparable<Edge> {
		int to;
		int w;
		
		public Edge(int to, int w) {
			this.to = to;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return this.w-o.w;
		}
		
		
		
	}

	public static void main(String[] args) throws IOException {
		/* 문제) 최소비용 구하기
		 * 다익스트라로 다시 풀기...
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		// 간선 정보 저장할 리스트
		List<Edge>[] list = new ArrayList[n+1];
		
		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		
		// 간선 정보 입력받아서 저장
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new Edge(b, c));
			list[b].add(new Edge(a, c));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		boolean[] visited = new boolean[n+1];
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		visited[1] = true;
		
		for(Edge edge : list[0]) {
			pq.add(edge);
		}
		
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			if (visited[cur.to]) continue;
			
			visited[cur.to] = true;
			
			
			
		}
		
	}

}
