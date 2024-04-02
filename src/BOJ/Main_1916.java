package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1916 {
	
	static class Edge implements Comparable<Edge> {
		int v;
		int w;
		
		public Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
	}
	
	
	static final int inf = Integer.MAX_VALUE;
	static int n, m;
	static List<Edge>[] list;
	static boolean[] visited;
	static int[] dist;
	

	public static void main(String[] args) throws IOException {
		/* 문제) 최소비용 구하기
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new Edge(b, c));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		dist = new int[n+1];
		Arrays.fill(dist, inf);
		
		dijkstra(start);
		System.out.println(dist[end]);
		
	}
	
	static void dijkstra(int s) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		visited = new boolean[n+1];
		
		// 출발 지점은 0
		dist[s] = 0;
		
		pq.add(new Edge(s, 0));
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			if (visited[cur.v]) continue;
			
			visited[cur.v] = true;
			
			for(Edge edge : list[cur.v]) {
				if (!visited[edge.v] && dist[edge.v] > dist[cur.v]+edge.w) {
					dist[edge.v] = dist[cur.v]+edge.w;
					pq.add(new Edge(edge.v, dist[edge.v]));
				}
			}
		}
		
		
	}

}
